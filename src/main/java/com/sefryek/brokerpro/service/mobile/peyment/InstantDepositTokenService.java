package com.sefryek.brokerpro.service.mobile.peyment;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.mobile.peyment.InstantDepositTokenRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.peyment.InstantDepositToken;
import com.sefryek.brokerpro.service.AuthStrategy;
import com.sefryek.brokerpro.service.Service;
import com.sefryek.brokerpro.service.mapper.InstantDepositTokenMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.payment.MoneyTransferTokenTadbir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.Form;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, May, 2017
 */
@Component
public class InstantDepositTokenService extends Service<MoneyTransferTokenTadbir> {

    @Autowired
    private InstantDepositTokenMapper instantDepositTokenMapper;

    public InstantDepositTokenService() {
        super(MoneyTransferTokenTadbir.class);
    }

    public Response<InstantDepositToken> getInstantDepositToken(InstantDepositTokenRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        Form form = new Form();
        form.param("FinancialId", String.valueOf(request.getBankGatewayId()));
        form.param("Amount", String.valueOf(request.getAmount()));
        form.param("RedirectUrl", String.valueOf(request.getRedirectUrl() != null ? request.getRedirectUrl() : Constants.EMPTY_STRING));
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(), Constants.INSTANT_DEPOSIT_URL), ODataAuthStrategy.NONE);
        MoneyTransferTokenTadbir responseTadbir = callWebService(HttpMethod.POST, form, urlBuilder, AuthStrategy.USER, request.getToken());
        Response<InstantDepositToken> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            result.setResponse(instantDepositTokenMapper.as(responseTadbir.getMoneyTransferTadbir()));
        }
        createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
        return result;
    }
}
