package com.sefryek.brokerpro.service.mobile.peyment;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.mobile.peyment.WithdrawalDetailRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.peyment.WithdrawalDetail;
import com.sefryek.brokerpro.service.AuthStrategy;
import com.sefryek.brokerpro.service.Service;
import com.sefryek.brokerpro.service.mapper.WithdrawalDetailMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.payment.PaymentDetailResponseTadbir;
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
public class WithdrawalDetailService extends Service<PaymentDetailResponseTadbir> {

    @Autowired
    private WithdrawalDetailMapper withdrawalDetailMapper;

    public WithdrawalDetailService() {
        super(PaymentDetailResponseTadbir.class);
    }

    public Response<WithdrawalDetail> getWithdrawalDetail(WithdrawalDetailRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(), Constants.WITHDRAWAL_URL), ODataAuthStrategy.CUSTOMER_ISIN_URL);
        PaymentDetailResponseTadbir responseTadbir = callWebService(HttpMethod.GET, new Form(), urlBuilder, AuthStrategy.USER, request.getToken());
        Response<WithdrawalDetail> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            result.setResponse(withdrawalDetailMapper.as(responseTadbir.getPaymentDetail()));

        }
        createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
        return result;
    }
}
