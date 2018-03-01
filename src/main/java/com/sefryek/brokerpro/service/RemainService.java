package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.account.Remain;
import com.sefryek.brokerpro.service.mapper.RemainMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.account.RemainTadbir;
import com.sefryek.util.ObjectUtils;
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
 * @date: 18, Dec, 2016
 */
@Component
public class RemainService extends Service<RemainTadbir> {

    @Autowired
    private RemainMapper remainMapper;

    public RemainService() {
        super(RemainTadbir.class);
    }

    public Response<Remain> getRemain(EmptyRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(), Constants.REMAIN_URL), ODataAuthStrategy.CUSTOMER_ISIN_URL);
        RemainTadbir responseTadbir = callWebService(HttpMethod.GET, new Form(), urlBuilder, AuthStrategy.USER, request.getToken());
        Response<Remain> result = new Response<>();
        if(ObjectUtils.isNotNull(responseTadbir)){
            if (responseTadbir.isSuccessful()) {
                result.setResponse(remainMapper.as(responseTadbir));
            }
        } else {
            return createNotSuccessResponse();
        }
        return createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
    }

}
