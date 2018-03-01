package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.response.gateway.LoginGateway;
import com.sefryek.brokerpro.tadbir.dto.response.LoginGatewayTadbir;
import org.springframework.stereotype.Component;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 10, Jul, 2017
 */
@Component
public class CustomLoginGatewayMapper implements SelmaObjectMapper<LoginGatewayTadbir, LoginGateway> {

    @Override
    public LoginGateway as(LoginGatewayTadbir in) {
        if (in != null) {
            LoginGateway out = new LoginGateway();
            out.setBrokerCode(in.getBrokerCode());
            out.setToken(String.format(Constants.LOGIN_GATEWAY_TOKEN_BASIC, in.getToken()));
            out.setLsToken(in.getLsToken());
            return out;
        }
        return null;
    }
}
