package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.domain.Broker;
import com.sefryek.brokerpro.domain.BrokerDeviceType;
import com.sefryek.brokerpro.domain.Session;
import com.sefryek.brokerpro.dto.request.LoginRequest;
import com.sefryek.brokerpro.dto.response.DefaultResponse;
import com.sefryek.brokerpro.dto.response.Login;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.exception.BrokerNotFoundException;
import com.sefryek.brokerpro.exception.UserNotFoundException;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.session.SessionManager;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.customer.CustomerTadbir;
import com.sefryek.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.Form;

@Component
public class LoginService extends Service<CustomerTadbir> {

    @Autowired
    private SessionManager sessionManager;

    @Autowired
    private BrokerService brokerService;

    public LoginService() {
        super(CustomerTadbir.class);
    }

    public Response<Login> authenticate(LoginRequest loginRequest) {
        Assert.notNull(loginRequest);
        Form form = new Form();
        form.param("Username", loginRequest.getUsername());
        form.param("Password", loginRequest.getPassword());
        BrokerDeviceType brokerDeviceType = BrokerDeviceType.fromString(String.valueOf(loginRequest.getDeviceType()));
        Broker broker = brokerService.findByCodeAndDeviceType(loginRequest.getBrokerCode(), brokerDeviceType);
        if (StringUtils.isEmpty(broker.getBrokerUrl())) {
            throw new BrokerNotFoundException();
        }
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrlByBroker(broker, Constants.MOBILE_CUSTOMER_URL));
        CustomerTadbir responseTadbir = callWebService(HttpMethod.POST, form, urlBuilder, AuthStrategy.GATEWAY, loginRequest.getBrokerCode());
        Response<Login> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            Session session = sessionManager.createSession(loginRequest.getUsername(), responseTadbir.getCustomerISIN(),responseTadbir.getLsToken(), broker, loginRequest.getDeviceType());
            Login login = new Login(session.getId(), responseTadbir.getLsToken(), broker.getLsUrl(), responseTadbir.getCustomerTitle(), responseTadbir.getCustomerISIN());
            result.setResponse(login);
            createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
            return result;
        }
        throw new UserNotFoundException();
    }

    public Response<DefaultResponse> invalidate(String token) {
        Assert.notNull(token);
        sessionManager.deleteSession(token);
        Response<DefaultResponse> logoutResponse = new Response<>();
        logoutResponse.setSuccessful(true);
        return logoutResponse;
    }
}
