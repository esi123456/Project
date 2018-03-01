package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.domain.Broker;
import com.sefryek.brokerpro.domain.Session;
import com.sefryek.brokerpro.dto.request.Language;
import com.sefryek.brokerpro.dto.request.Request;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.gateway.LoginGateway;
import com.sefryek.brokerpro.dto.response.market.price.first.SymbolState;
import com.sefryek.brokerpro.exception.*;
import com.sefryek.brokerpro.repository.cache.BrokerCacheRepository;
import com.sefryek.brokerpro.repository.cache.LoginGatewayCacheRepository;
import com.sefryek.brokerpro.security.xauth.ServiceProvider;
import com.sefryek.brokerpro.service.Retry.ServiceInputs;
import com.sefryek.brokerpro.service.mapper.PageableMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.order.event.AuthorizationEvent;
import com.sefryek.brokerpro.service.session.SessionManager;
import com.sefryek.brokerpro.tadbir.dto.response.market.price.first.PriceWithFirstQueueTadbir;
import com.sefryek.brokerpro.utils.PersianDateUtils;
import com.sefryek.util.DatePattern;
import com.sefryek.util.DateUtils;
import com.sefryek.util.ObjectUtils;
import com.sefryek.util.StringUtils;
import ma.glasnost.orika.MapperFacade;
import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.Assert;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.*;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import java.net.ConnectException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@PropertySource("classpath:brokers-${spring.profiles.active}.properties")
public abstract class Service<T> {

    public static final int TIMEOUT_VALUE = 10000;
    @Autowired
    private RetryPolicy retryPolicy;
    @Autowired
    protected PageableMapper pageableMapper;
    @Autowired
    private MapperFacade mapperFacade;
    @Autowired
    ServiceProvider serviceProvider;
    private Class<T> result;
    @Autowired
    private SessionManager sessionManager;
    @Autowired
    private Environment env;
    @Autowired
    private ClientConfig clientConfig;
    @Autowired
    private BrokerCacheRepository brokerCacheRepository;
    @Autowired
    private LoginGatewayCacheRepository loginGatewayCacheRepository;
    @Autowired
    private ApplicationEventPublisher publisher;

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    public Service(final Class<T> result) {
        this.result = result;
    }

    /** Market Service (doesn't need gateway token) **/
    public T callWebServiceHttpMethodGET(UrlBuilder urlBuilder) {
        return callWebService(HttpMethod.GET, new Form(), urlBuilder, AuthStrategy.NONE, null);
    }

    /** Non-Market Service (needs gateway token) **/
    public T callWebServiceHttpMethodGET(UrlBuilder urlBuilder, AuthStrategy authStrategy, String tokenOrBrokerCode) {
        return callWebService(HttpMethod.GET, new Form(), urlBuilder, authStrategy, tokenOrBrokerCode);
    }

    /** Market Service (doesn't need gateway token) **/
    public T callWebService(String httpMethod, Form form , UrlBuilder urlBuilder) {
        return callWebService(httpMethod, form, urlBuilder, AuthStrategy.NONE, null);
    }

    /**
     * Non-Market Service (needs gateway token)
     **/
    public T callWebService(String httpMethod, Form form, UrlBuilder urlBuilder, AuthStrategy authStrategy, String tokenOrBrokerCode) {
        return Failsafe.with(retryPolicy).get(() -> call(httpMethod, form, urlBuilder, authStrategy, tokenOrBrokerCode));
    }


    private T call(String httpMethod, Form form , UrlBuilder urlBuilder, AuthStrategy authStrategy, String tokenOrBrokerCode) throws ConnectException {
        ServiceInputs serviceInputs = new ServiceInputs(httpMethod, form, urlBuilder, authStrategy, tokenOrBrokerCode);
        clientConfig.property(ClientProperties.SUPPRESS_HTTP_COMPLIANCE_VALIDATION, true);
        Client client = ClientBuilder.newClient(clientConfig);
        client.property(ClientProperties.CONNECT_TIMEOUT, TIMEOUT_VALUE);
        client.property(ClientProperties.READ_TIMEOUT, TIMEOUT_VALUE);
        Session session = null;

        /** set UserName ans CustomerISIN in urlBuilder and form **/
        if (AuthStrategy.USER.equals(authStrategy)) {
            Assert.notNull(tokenOrBrokerCode);
            session = sessionManager.getSession(tokenOrBrokerCode);
            Assert.notNull(session);
            urlBuilder.setUserName(session.getUsername());
            urlBuilder.setCustomerISIN(session.getCustomerISIN());
            form.param("UserName", session.getUsername());
            form.param("CustomerISIN", session.getCustomerISIN());
        }

        String url = urlBuilder.build();
        log.info("Tadbir's URL service is: " + url);
        WebTarget service = client.target(url);
        Invocation.Builder request = service.request();

        /** set header **/
        if (AuthStrategy.USER.equals(authStrategy) && session != null) {
            request.header(Constants.X_TADBIR_AUTH, getToken(session.getBrokerCode()));
        } else if (AuthStrategy.GATEWAY.equals(authStrategy) && tokenOrBrokerCode != null){
            if(StringUtils.isEmpty(getToken(tokenOrBrokerCode))){
                log.warn(String.format("**** Gateway token for brokerCode = %s is null and service is: %s ****", tokenOrBrokerCode, url));
                return null;
            }
            request.header(Constants.X_TADBIR_AUTH, getToken(tokenOrBrokerCode));
        }

        javax.ws.rs.core.Response response = null;
        try {
            response = callServiceByMethodType(httpMethod, form, request, url, client, authStrategy, tokenOrBrokerCode);
        }catch (Exception e){
            log.error("cannot connect to " + url);
            new ConnectException("cannot connect to " + url);
            e.printStackTrace();
        }
        if(response != null){
            return checkResponseStatus(response, result, serviceInputs);
        }
        throw new InternalServerException();
    }

    public String getToken(String brokerCode) {
        Assert.notNull(brokerCode);
        LoginGateway loginGateway = loginGatewayCacheRepository.findByBrokerCode(brokerCode);
        if(ObjectUtils.isNotNull(loginGateway) && ObjectUtils.isNotNull(loginGateway.getToken())){
            return  loginGatewayCacheRepository.findByBrokerCode(brokerCode).getToken();
        }
        return null;
    }

    private javax.ws.rs.core.Response callServiceByMethodType(String httpMethod, Form form, Invocation.Builder request, String url, Client client, AuthStrategy authStrategy, String tokenOrBrokerCode) throws ConnectException{
        javax.ws.rs.core.Response response = null;
        if(HttpMethod.GET.equals(httpMethod)){
            response = request.get();
        } else if(HttpMethod.POST.equals(httpMethod)){
            response = request.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));
        } else if(HttpMethod.PUT.equals(httpMethod)){
            response = request.put(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));
        } else if(HttpMethod.DELETE.equals(httpMethod)){
            if(AuthStrategy.USER.equals(authStrategy)){
                Assert.notNull(tokenOrBrokerCode);
                Session session = sessionManager.getSession(tokenOrBrokerCode);
                Assert.notNull(session);
                response =client.target(url)
                        .request().header(Constants.X_TADBIR_AUTH, getToken(session.getBrokerCode()))
                        .build(HttpMethod.DELETE, Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED))
                        .invoke();
            } else if(AuthStrategy.GATEWAY.equals(authStrategy)){
                Assert.notNull(tokenOrBrokerCode);
                response =client.target(url)
                        .request().header(Constants.X_TADBIR_AUTH, getToken(tokenOrBrokerCode))
                        .build(HttpMethod.DELETE, Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED))
                        .invoke();
            } else if(AuthStrategy.NONE.equals(authStrategy)){
                response =client.target(url)
                        .request()
                        .build(HttpMethod.DELETE, Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED))
                        .invoke();
            }
        }
        return response;
    }

    private <T> T checkResponseStatus(javax.ws.rs.core.Response response, Class<T> result, ServiceInputs serviceInputs) {
        try {
            if (javax.ws.rs.core.Response.Status.OK.getStatusCode() == response.getStatus()) {
                return response.readEntity(result);
            } else if (javax.ws.rs.core.Response.Status.UNAUTHORIZED.getStatusCode() == response.getStatus()) {
                publisher.publishEvent(new AuthorizationEvent(serviceInputs));
                throw new AuthorizationException();
            } else if (javax.ws.rs.core.Response.Status.FORBIDDEN.getStatusCode() == response.getStatus()) {
                throw new AuthorizationException();
            } else if (javax.ws.rs.core.Response.Status.NOT_FOUND.getStatusCode() == response.getStatus()) {
                throw new NotFoundException("page not found");
            } else if (javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR.getStatusCode() <= response.getStatus()) {
                throw new InternalServerException();
            }
            throw new InternalServerException();
        } finally {
            response.close();
        }
    }

    public MapperFacade getMapperFacade() {
        return mapperFacade;
    }

    public Response createResponse(Response<?> response, boolean successful, String errorCode, String errorDescription) {
        response.setSuccessful(successful);
        response.setErrorCode(errorCode);
        response.setErrorDescription(errorDescription);
        return response;
    }

    public Response createNotSuccessResponse() {
        return createResponse(null, false, ErrorCode.DATA_NOT_FOUND_EXCEPTION.getCode(), ErrorCode.DATA_NOT_FOUND_EXCEPTION.getDescription());
    }

    public Response<?> createSuccessResponse(Response<?> response) {
        response.setSuccessful(Boolean.TRUE);
        return response;
    }

    protected String convertDateToStringByHyphen(Date date) {
        return DateUtils.convertDateToString(date, DatePattern.DATE_BY_HYPHEN_PATTERN);
    }

    protected String convertDateToStringByHyphenPlusOneDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        return DateUtils.convertDateToString(calendar.getTime(), DatePattern.DATE_BY_HYPHEN_PATTERN);
    }

    protected String convertDateToLong(Date date) {
        StringBuilder result = new StringBuilder(DateUtils.convertDateToString(date, DatePattern.MINIMIZED_DATE_PATTERN));
        result.append("0000");
        return result.toString();
    }

    protected String convertDateToStringBySlash(Date date) {
        return DateUtils.convertDateToString(date, DatePattern.DATE_PATTERN);
    }

    protected String convertDateToPersianBySlash(Date date) {
        return PersianDateUtils.convertGregorianToPersian(date, DatePattern.DATE_PATTERN);
    }

    public SessionManager getSessionManager() {
        return sessionManager;
    }

    protected PageRequest getPageRequest(Request request) {
        PageRequest pageRequest = pageableMapper.as(request);
        if (ObjectUtils.isNull(pageRequest)) {
            throw new PageableNotFoundException();
        }
        return pageRequest;
    }

    protected String createMarketUrl(String key) {
        return String.format("%s%s", getEnv().getProperty(Constants.MARKET_URL), getEnv().getProperty(key));
    }

    protected Environment getEnv() {
        return env;
    }

    protected String createMobileUrl(String token, String key) {
        Session session = sessionManager.getSession(token);
        if (ObjectUtils.isNull(session)) {
            throw new UserNotFoundException();
        }
        Broker broker = sessionManager.findByCodeAndDeviceType(session.getBrokerCode(), session.getDeviceType());
        Assert.notNull(broker);
        Assert.notNull(broker.getBrokerUrl());
        return String.format("%s%s", broker.getBrokerUrl(), getEnv().getProperty(key));
    }

    protected String findBrokerCodeByToken(String token) {
        Session session = sessionManager.getSession(token);
        if (ObjectUtils.isNull(session)) {
            throw new UserNotFoundException();
        }
        Broker broker = sessionManager.findByCodeAndDeviceType(session.getBrokerCode(), session.getDeviceType());
        Assert.notNull(broker);
        Assert.notNull(broker.getBrokerUrl());
        return broker.getCode();
    }

    protected String createMobileUrlByBroker(Broker broker, String key) {
        Assert.notNull(broker);
        Assert.notNull(broker.getBrokerUrl());
        return String.format("%s%s", broker.getBrokerUrl(), getEnv().getProperty(key));
    }

    protected Broker findBrokerByToken(String token) {
        Session session = sessionManager.getSession(token);
        if (ObjectUtils.isNull(session)) {
            throw new UserNotFoundException();
        }
        Broker broker = sessionManager.findByCodeAndDeviceType(session.getBrokerCode(), session.getDeviceType());
        Assert.notNull(broker);
        return broker;
    }

    protected String getLanguage(Request request) {
        return (ObjectUtils.isNotNull(request) && ObjectUtils.isNotNull(request.getLanguage()))
                ? request.getLanguage().getCode() : Language.PERSIAN.getCode();
    }

    protected Form addListAsFormArray(Form form, String parameterName, List<String> values) {
        Assert.notNull(form);
        Assert.notNull(parameterName);
        Assert.notNull(values);
        for (String value : values) {
            form.param(String.format("%s[]", parameterName), value);
        }
        return form;
    }

    protected String convertDateToStringTimeByColon(Date date) {
        return DateUtils.convertDateToString(date, DatePattern.TIME_PATTERN);
    }

    protected String convertDateToStringBySlashMothFirst(Date date) {
        return new SimpleDateFormat("MM/dd/yyyy").format(date);
    }

    protected List<Object> createSubListTadbir(Request request, List responseTadbir) {
        List<Object> out = new ArrayList<>();
        int startIndex = request.getPageable().getPage() * request.getPageable().getSize();
        int endIndex = (request.getPageable().getPage() + 1) * request.getPageable().getSize();
        if(startIndex < responseTadbir.size()){
            if(endIndex > responseTadbir.size()){
                out = responseTadbir.subList(startIndex, responseTadbir.size());
            } else {
                out = responseTadbir.subList(startIndex, endIndex);
            }
        }
        return out;
    }

    //todo its better to map symbolState in selma mapper later
    public SymbolState asSymbolState(PriceWithFirstQueueTadbir priceWithFirstQueueTadbir) {
        switch (priceWithFirstQueueTadbir.getFirstSymbolState()){
            case AUTHORIZED:{
                switch (priceWithFirstQueueTadbir.getSecondSymbolState()) {
                    case OPEN:
                        return SymbolState.AUTHORIZED;
                    case FROZEN:
                        return SymbolState.AUTHORIZED_FROZEN;
                    case SUSPENDED:
                        return SymbolState.AUTHORIZED_SUSPENDED;
                    case RESERVED:
                        return SymbolState.AUTHORIZED_RESERVED;

                    default:
                        throw new InvalidDataAccessApiUsageException(String.format("Logic error for '%s' in CustomSymbolStateMapper.mapSymbolState", priceWithFirstQueueTadbir.getSecondSymbolState()));
                }
            }
            case FORBIDDEN:{
                switch (priceWithFirstQueueTadbir.getSecondSymbolState()) {
                    case OPEN:
                        return SymbolState.FORBIDDEN;
                    case FROZEN:
                        return SymbolState.FORBIDDEN_FROZEN;
                    case SUSPENDED:
                        return SymbolState.FORBIDDEN_SUSPENDED;
                    case RESERVED:
                        return SymbolState.FORBIDDEN_RESERVED;

                    default:
                        throw new InvalidDataAccessApiUsageException(String.format("Logic error for '%s' in CustomSymbolStateMapper.mapSymbolState", priceWithFirstQueueTadbir.getSecondSymbolState()));
                }
            }
            default:
                throw new InvalidDataAccessApiUsageException(String.format("Logic error for '%s' in CustomSymbolStateMapper.mapSymbolState", priceWithFirstQueueTadbir.getFirstSymbolState()));
        }
    }

}
