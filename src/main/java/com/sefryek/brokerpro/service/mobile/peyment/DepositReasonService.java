package com.sefryek.brokerpro.service.mobile.peyment;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.peyment.DepositReason;
import com.sefryek.brokerpro.service.AuthStrategy;
import com.sefryek.brokerpro.service.Service;
import com.sefryek.brokerpro.service.mapper.DepositReasonMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.payment.DepositReasonTadbir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 31, Jul, 2017
 */
@Component
public class DepositReasonService extends Service<DepositReasonTadbir> {

    @Autowired
    private DepositReasonMapper depositReasonMapper;

    public DepositReasonService() {
        super(DepositReasonTadbir.class);
    }

    public Response<DepositReason> findDepositReason(EmptyRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(), Constants.DEPOSIT_URL), ODataAuthStrategy.NONE);
        urlBuilder.appendUrl("MoneyReason");
        DepositReasonTadbir responseTadbir = callWebServiceHttpMethodGET(urlBuilder, AuthStrategy.USER, request.getToken());
        Response<DepositReason> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            result.setResponse(depositReasonMapper.as(responseTadbir));
        }
        createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
        return result;
    }

}