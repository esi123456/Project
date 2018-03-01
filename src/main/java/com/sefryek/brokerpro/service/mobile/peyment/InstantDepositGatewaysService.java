package com.sefryek.brokerpro.service.mobile.peyment;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.request.Language;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.peyment.InstantDepositGateway;
import com.sefryek.brokerpro.service.AuthStrategy;
import com.sefryek.brokerpro.service.Service;
import com.sefryek.brokerpro.service.mapper.InstantDepositGatewaysMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.payment.MoneyTransferGatewaysTadbir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.Form;
import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, May, 2017
 */
@Component
public class InstantDepositGatewaysService extends Service<MoneyTransferGatewaysTadbir> {

    @Autowired
    private InstantDepositGatewaysMapper instantDepositGatewaysMapper;

    public InstantDepositGatewaysService() {
        super(MoneyTransferGatewaysTadbir.class);
    }

    public Response<List<InstantDepositGateway>> findInstantDepositGateways(EmptyRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(), Constants.MONEY_TRANSFER_GATEWAYS_URL), ODataAuthStrategy.NONE);
        urlBuilder.appendUrl(Boolean.TRUE);
        urlBuilder.appendUrl(request.getLanguage() != null ? request.getLanguage().getCode() : Language.PERSIAN.getCode());
        MoneyTransferGatewaysTadbir responseTadbir = callWebService(HttpMethod.GET, new Form(), urlBuilder, AuthStrategy.USER, request.getToken());
        Response<List<InstantDepositGateway>> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            result.setResponse(instantDepositGatewaysMapper.as(responseTadbir.getMoneyTransferGatewaysTadbir()));
        }
        createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
        return result;
    }

}
