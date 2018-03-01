package com.sefryek.brokerpro.service.mobile.peyment;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.mobile.peyment.InstantDepositStatusRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.peyment.InstantDepositStatus;
import com.sefryek.brokerpro.service.AuthStrategy;
import com.sefryek.brokerpro.service.Service;
import com.sefryek.brokerpro.service.mapper.InstantDepositStatusMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.payment.MoneyTransferStatusResponseTadbir;
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
 * @date: 16, May, 2017
 */
@Component
public class InstantDepositStatusService extends Service<MoneyTransferStatusResponseTadbir> {

    @Autowired
    private InstantDepositStatusMapper instantDepositStatusMapper;

    public InstantDepositStatusService() {
        super(MoneyTransferStatusResponseTadbir.class);
    }

    public Response<InstantDepositStatus> getInstantDepositStatus(InstantDepositStatusRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(), Constants.INSTANT_DEPOSIT_URL), ODataAuthStrategy.USER_NAME_URL);
        urlBuilder.appendUrl(request.getInstantDepositId());
        MoneyTransferStatusResponseTadbir responseTadbir = callWebService(HttpMethod.GET, new Form(), urlBuilder, AuthStrategy.USER, request.getToken());
        Response<InstantDepositStatus> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            result.setResponse(instantDepositStatusMapper.as(responseTadbir.getStatus()));
        }
        createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
        return result;
    }
}
