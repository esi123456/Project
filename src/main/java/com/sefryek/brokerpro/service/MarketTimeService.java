package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.market.time.MarketTime;
import com.sefryek.brokerpro.service.mapper.MarketTimeMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.time.MarketTimeTadbir;
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
 * @date: 11, Feb, 2017
 */
@Component
public class MarketTimeService extends Service<MarketTimeTadbir> {

    @Autowired
    private MarketTimeMapper marketTimeMapper;

    public MarketTimeService() {
        super(MarketTimeTadbir.class);
    }

    public Response<MarketTime> getMarketTime(EmptyRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(),Constants.TIME_URL), ODataAuthStrategy.NONE);
        MarketTimeTadbir result = callWebService(HttpMethod.GET, new Form(), urlBuilder, AuthStrategy.USER, request.getToken());
        Response<MarketTime> marketTimeResponse = new Response<>();
        if (result.isSuccessful()) {
            marketTimeResponse.setResponse(marketTimeMapper.as(result));
        }
        createResponse(marketTimeResponse, result.isSuccessful(), result.getErrorCode(), result.getErrorDescription());
        return marketTimeResponse;
    }

    public Response<MarketTime> getMarketTime2(EmptyRequest request) {
        UrlBuilder urlBuilder = new UrlBuilder("http://restapi.mofidonline.com/Mobile/V1/Time", ODataAuthStrategy.NONE);
        MarketTimeTadbir result = callWebServiceHttpMethodGET(urlBuilder, AuthStrategy.GATEWAY, "112");
        Response<MarketTime> marketTimeResponse = new Response<>();
        if (result.isSuccessful()) {
            marketTimeResponse.setResponse(marketTimeMapper.as(result));
        }
        createResponse(marketTimeResponse, result.isSuccessful(), result.getErrorCode(), result.getErrorDescription());
        return marketTimeResponse;
    }

}