package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.domain.Commission;
import com.sefryek.brokerpro.dto.request.SymbolPriceListWithFirstQueueRequest;
import com.sefryek.brokerpro.dto.request.commission.CommissionRequest;
import com.sefryek.brokerpro.dto.request.portfolio.RealTimePortfolioListRequest;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.market.price.first.PriceWithFirstQueue;
import com.sefryek.brokerpro.dto.response.mobile.portfolio.RealTimePortfolioList;
import com.sefryek.brokerpro.service.commision.CommissionService;
import com.sefryek.brokerpro.service.mapper.RealTimePortfolioListMapper;
import com.sefryek.brokerpro.service.mapper.RealTimePortfolioListPageMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.market.price.first.PricesWithFirstQueueTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.portfolio.stock.PortfoliosTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.portfolio.stock.RealTimePortfolioListTadbir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.Form;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 19, Apr, 2017
 */
@Component
public class RealTimePortfolioListService extends Service<RealTimePortfolioListTadbir> {

    @Autowired
    private RealTimePortfolioListMapper realTimePortfolioListMapper;

    @Autowired
    private SymbolPriceListWithFirstQueueService symbolPriceListWithFirstQueueService;

    @Autowired
    private MemberListOfWatchListCategoryService memberListOfWatchListCategoryService;

    @Autowired
    private DailyCustomerStockPortfolioService dailyCustomerStockPortfolioService;

    @Autowired
    private CommissionService commissionService;

    @Autowired
    private RealTimePortfolioListPageMapper realTimePortfolioListPageMapper;

    public RealTimePortfolioListService() {
        super(RealTimePortfolioListTadbir.class);
    }

    public Response<Page<RealTimePortfolioList>> findRealTimePortfolio(RealTimePortfolioListRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(), Constants.REAL_TIME_PORTFOLIO_LIST_URL), ODataAuthStrategy.CUSTOMER_ISIN_URL);
        urlBuilder.appendUrl(request.getAllPortfolio() == null ? Boolean.FALSE : request.getAllPortfolio());
        RealTimePortfolioListTadbir responseTadbir = callWebService(HttpMethod.GET, new Form(), urlBuilder, AuthStrategy.USER, request.getToken());
        //We have to get RealTimePortfolioListService response for creating a request for WatchListWithFirstQueueService and finally set WatchListWithFirstQueueService response to RealTimePortfolioListService response
        Response<List<RealTimePortfolioList>> tempResult = new Response<>();
        Response<Page<RealTimePortfolioList>> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            List<RealTimePortfolioList> tempOut;
            List<Object> tempSubListTadbir = createSubListTadbir(request, responseTadbir.getRealTimePortfolioListTadbirList());
            List<PortfoliosTadbir> subListTadbir = (List<PortfoliosTadbir>) (List<?>) tempSubListTadbir;
            tempOut = realTimePortfolioListMapper.as(subListTadbir);

            tempResult.setResponse(tempOut);
            //SymbolPriceListWithFirstQueueService should call
            SymbolPriceListWithFirstQueueRequest priceRequest = memberListOfWatchListCategoryService.createPriceRequest(request.getToken(), request.getLanguage(), createSymbolList(tempResult));
            PricesWithFirstQueueTadbir priceTadbir = symbolPriceListWithFirstQueueService.findByMemberList(priceRequest);
            Response<List<PriceWithFirstQueue>> priceResult = symbolPriceListWithFirstQueueService.createGatewayResponseByLanguage(priceTadbir, request);
            //SymbolPriceListWithFirstQueueService should set to result(just priceWithFirstQueue)
            tempResult.setResponse(setPriceWithFirstQueueToResult(request, tempResult, priceResult.getResponse()).getResponse());

            List<RealTimePortfolioList> out = tempResult.getResponse();
            PageImpl<RealTimePortfolioList> orderPage = new PageImpl<>(out, new PageRequest(request.getPageable().getPage(), request.getPageable().getSize()), responseTadbir.getRealTimePortfolioListTadbirList().size());
            Page<RealTimePortfolioList> page = realTimePortfolioListPageMapper.as(orderPage);
            result.setResponse(page);
        }
        createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
        return result;
    }

    private List<String> createSymbolList(Response<List<RealTimePortfolioList>> realTimePortfolioListResponse) {
        List<String> symbolList = new ArrayList<>();
        for (RealTimePortfolioList realTimePortfolioList : realTimePortfolioListResponse.getResponse()) {
            Assert.notNull(realTimePortfolioList.getSymbolISIN());
            symbolList.add(realTimePortfolioList.getSymbolISIN());
        }
        return symbolList;
    }

    private Response<List<RealTimePortfolioList>> setPriceWithFirstQueueToResult(RealTimePortfolioListRequest request, Response<List<RealTimePortfolioList>> result, List<PriceWithFirstQueue> priceWithFirstQueueResponse){
        for (int i = 0; i < result.getResponse().size(); i++) {
            RealTimePortfolioList realTimePortfolioList = result.getResponse().get(i);
            Assert.notNull(realTimePortfolioList);
            Assert.notNull(realTimePortfolioList.getSymbolISIN());
            //set Commission
            CommissionRequest commissionRequest = new CommissionRequest();
            commissionRequest.setToken(request.getToken());
            commissionRequest.setSymbolISIN(result.getResponse().get(i).getSymbolISIN());
            //todo is it better to get commission az a list?
            Commission commission = commissionService.findCommission(commissionRequest).getResponse();
            Assert.notNull(commission);
            result.getResponse().get(i).setCommissionDetail(commission);
            //set PriceWithFirstQueue
            result.getResponse().get(i).setPriceWithFirstQueue(dailyCustomerStockPortfolioService.setPriceWithFirstQueue(priceWithFirstQueueResponse, realTimePortfolioList.getSymbolISIN()));
        }
        return result;
    }
}
