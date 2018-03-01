package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.portfolio.RowDetailsRealTimePortfolioRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.portfolio.PortfolioRecords;
import com.sefryek.brokerpro.service.mapper.RowDetailsRealTimePortfolioMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.portfolio.RowDetailsRealTimePortfolioTadbir;
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
 * @date: 22, Apr, 2017
 */
@Component
public class RowDetailsRealTimePortfolioService extends Service<RowDetailsRealTimePortfolioTadbir> {

    @Autowired
    private RowDetailsRealTimePortfolioMapper rowDetailsRealTimePortfolioMapper;

    public RowDetailsRealTimePortfolioService() {
        super(RowDetailsRealTimePortfolioTadbir.class);
    }

    public Response<List<PortfolioRecords>> findRowDetailsRealTimePortfolio(RowDetailsRealTimePortfolioRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(), Constants.REAL_TIME_PORTFOLIO_LIST_URL), ODataAuthStrategy.CUSTOMER_ISIN_URL);
        urlBuilder.appendUrl(request.getSymbolISIN());
        RowDetailsRealTimePortfolioTadbir responseTadbir = callWebService(HttpMethod.GET, new Form(), urlBuilder, AuthStrategy.USER, request.getToken());
        Response<List<PortfolioRecords>> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            result.setResponse(rowDetailsRealTimePortfolioMapper.as(responseTadbir.getPortfolioRecordsTadbirList()));
        }
        createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
        return result;
    }

}
