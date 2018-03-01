package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.domain.Broker;
import com.sefryek.brokerpro.domain.BrokerInfo;
import com.sefryek.brokerpro.domain.Session;
import com.sefryek.brokerpro.dto.response.gateway.LoginGateway;
import com.sefryek.brokerpro.repository.cache.BrokerCacheRepository;
import com.sefryek.brokerpro.repository.cache.LoginGatewayCacheRepository;
import com.sefryek.brokerpro.repository.mongo.BrokerInfoRepository;
import com.sefryek.brokerpro.service.Retry.ServiceInputs;
import com.sefryek.brokerpro.service.mapper.LoginGatewayMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.service.order.event.AuthorizationEvent;
import com.sefryek.brokerpro.service.session.event.LoginEvent;
import com.sefryek.brokerpro.tadbir.dto.response.LoginGatewayTadbir;
import com.sefryek.util.ObjectUtils;
import com.sefryek.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.Form;
import java.util.Date;
import java.util.List;

/**
 * Created by Amin on 6/22/2017.
 */
@Component
public class LoginGatewayService extends Service<LoginGatewayTadbir> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private LoginGatewayCacheRepository loginGatewayCacheRepository;

    @Autowired
    LoginGatewayMapper loginGatewayMapper;

    @Autowired
    BrokerCacheRepository brokerCacheRepository;
    @Autowired
    BrokerInfoRepository brokerInfoRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    public LoginGatewayService() {
        super(LoginGatewayTadbir.class);
    }

    public void loginAllBrokers() {
        List<Broker> brokerList = brokerCacheRepository.findAllByActiveTrue();
        for (Broker broker : brokerList) {
            publisher.publishEvent(new LoginEvent(broker));
        }
    }

    @Async
    @EventListener
    public void handleLogin(LoginEvent event) {
        Assert.notNull(event);
        Assert.notNull(event.getBroker());
        try {
            log.info(String.format("broker %s login started", event.getBroker().getCode()));
            loginOneBroker(event.getBroker());
            log.info(String.format("broker %s login finished", event.getBroker().getCode()));
        } catch (Exception ex) {
            log.error(String.format("broker %s login failed - %s", event.getBroker().getCode(),  ex.getMessage()), ex);
        }
    }

    protected void loginOneBroker(Broker broker) {
        BrokerInfo brokerInfo = brokerInfoRepository.findByCode(broker.getCode());
        if (ObjectUtils.isNotNull(brokerInfo)) {
            Form form = new Form();
            form.param("UserName", brokerInfo.getUserName());
            form.param("Password", brokerInfo.getPassword());
            UrlBuilder urlBuilder = new UrlBuilder(createMobileUrlByBroker(broker, Constants.GATEWAY_LOGIN_URL), ODataAuthStrategy.NONE);
            LoginGatewayTadbir responseTadbir = callWebService(HttpMethod.POST, form, urlBuilder);
            if (responseTadbir != null && responseTadbir.isSuccessful()) {
                Assert.notNull(responseTadbir.getToken());
                //this is for mapping brokerCode in LoginGateway
                responseTadbir.setBrokerCode(broker.getCode());
                LoginGateway loginGateway = loginGatewayMapper.as(responseTadbir);
                loginGatewayCacheRepository.save(loginGateway);
            } else {
                log.info(String.format("Response for broker %s with brokerCode= %s is null or unsuccessful.", broker.getCode(), broker.getEnName()));
            }
        } else {
            log.info(String.format("Data not found in broker_info collection for brokerCode: %s and brokerName: %s - %s", broker.getCode(), broker.getEnName(), new Date().toString()));
        }
    }

    @Async
    @EventListener
    public void handleAddOrder(AuthorizationEvent event) {
        retryAuthorization(event.getServiceInputs());
    }

    /**
     * This method call when gateway token is invalid.
     * In this method firs call loginGateway service for updating gateway's token, then recall the service that couldn't get response because of the expired or invalid token.
     **/
    private void retryAuthorization(ServiceInputs serviceInputs) {
        Session session;
        String brokerCode = StringUtils.EMPTY;
        if (AuthStrategy.USER.equals(serviceInputs.getAuthStrategy())) {
            Assert.notNull(serviceInputs.getTokenOrBrokerCode());
            session = getSessionManager().getSession(serviceInputs.getTokenOrBrokerCode());
            Assert.notNull(session);
            brokerCode = session.getBrokerCode();
        } else if (AuthStrategy.GATEWAY.equals(serviceInputs.getAuthStrategy())) {
            brokerCode = serviceInputs.getTokenOrBrokerCode();
        }
        if (StringUtils.isNotEmpty(brokerCode)) {
            Broker broker = brokerCacheRepository.findByCodeAndActiveTrue(brokerCode);
            if (ObjectUtils.isNotNull(broker)) {
                loginOneBroker(broker);
            }
        }
    }


}



