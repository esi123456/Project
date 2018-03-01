package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.domain.Commission;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.request.Language;
import com.sefryek.brokerpro.dto.request.SymbolPriceListWithFirstQueueRequest;
import com.sefryek.brokerpro.dto.request.commission.CommissionRequest;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.market.price.first.PriceWithFirstQueue;
import com.sefryek.brokerpro.dto.response.mobile.portfolio.stock.DailyCustomerStockPortfolio;
import com.sefryek.brokerpro.service.commision.CommissionService;
import com.sefryek.brokerpro.service.mapper.DailyCustomerStockPortfolioEnglishMapper;
import com.sefryek.brokerpro.service.mapper.DailyCustomerStockPortfolioPageMapper;
import com.sefryek.brokerpro.service.mapper.DailyCustomerStockPortfolioPersianMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.market.price.first.PricesWithFirstQueueTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.portfolio.stock.CustomerStockPortfolioTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.portfolio.stock.DailyCustomerStockPortfolioTadbir;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.Form;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, Apr, 2017
 */
@Component
public class DailyCustomerStockPortfolioService extends Service<DailyCustomerStockPortfolioTadbir> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DailyCustomerStockPortfolioPersianMapper dailyCustomerStockPortfolioPersianMapper;

    @Autowired
    DailyCustomerStockPortfolioEnglishMapper dailyCustomerStockPortfolioEnglishMapper;

    @Autowired
    private SymbolPriceListWithFirstQueueService symbolPriceListWithFirstQueueService;

    @Autowired
    private MemberListOfWatchListCategoryService memberListOfWatchListCategoryService;

    @Autowired
    private CommissionService commissionService;

    @Autowired
    private DailyCustomerStockPortfolioPageMapper dailyCustomerStockPortfolioPageMapper;

    public DailyCustomerStockPortfolioService() {
        super(DailyCustomerStockPortfolioTadbir.class);
    }

    public Response<Page<DailyCustomerStockPortfolio>> findCustomerStockPortfolio(EmptyRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(), Constants.DAILY_CUSTOMER_STOCK_PORTFOLIO_URL) , ODataAuthStrategy.CUSTOMER_ISIN_URL);
        urlBuilder.appendUrl(convertDateToLong(new Date()));
        DailyCustomerStockPortfolioTadbir responseTadbir = callWebService(HttpMethod.GET, new Form(), urlBuilder, AuthStrategy.USER, request.getToken());
        //We have to get DailyCustomerStockPortfolioService response for creating a request for WatchListWithFirstQueueService and finally set WatchListWithFirstQueueService response to DailyCustomerStockPortfolioService response
        Response<List<DailyCustomerStockPortfolio>> tempResult = new Response<>();
        Response<Page<DailyCustomerStockPortfolio>> result = new Response<>();
        try {
        if (responseTadbir.isSuccessful()) {
            List<DailyCustomerStockPortfolio> tempOut;
            List<Object> tempSubListTadbir = createSubListTadbir(request, responseTadbir.getCustomerStockPortfolioTadbirList());
            List<CustomerStockPortfolioTadbir> subListTadbir = (List<CustomerStockPortfolioTadbir>) (List<?>) tempSubListTadbir;
            if (Language.ENGLISH.equals(request.getLanguage())) {
                tempOut = dailyCustomerStockPortfolioEnglishMapper.as(subListTadbir);
            } else {
                tempOut = dailyCustomerStockPortfolioPersianMapper.as(subListTadbir);
            }
            tempResult.setResponse(tempOut);

            //SymbolPriceListWithFirstQueueService should call
            SymbolPriceListWithFirstQueueRequest symbolPriceListWithFirstQueueRequest = memberListOfWatchListCategoryService.createPriceRequest(request.getToken(), request.getLanguage(), createNscCodeList(tempResult));
            PricesWithFirstQueueTadbir symbolPriceListWithFirstQueueTadbir = symbolPriceListWithFirstQueueService.findByMemberList(symbolPriceListWithFirstQueueRequest);
            Response<List<PriceWithFirstQueue>> priceWithFirstQueueResponse = symbolPriceListWithFirstQueueService.createGatewayResponseByLanguage(symbolPriceListWithFirstQueueTadbir, request);
            //SymbolPriceListWithFirstQueueService should set to result(just priceWithFirstQueue)
            tempResult.setResponse(setPriceWithFirstQueueToResult(request, tempResult, priceWithFirstQueueResponse.getResponse()).getResponse());

            List<DailyCustomerStockPortfolio> out = tempResult.getResponse();
            PageImpl<DailyCustomerStockPortfolio> orderPage = new PageImpl<>(out, new PageRequest(request.getPageable().getPage(), request.getPageable().getSize()), responseTadbir.getCustomerStockPortfolioTadbirList().size());
            Page<DailyCustomerStockPortfolio> page = dailyCustomerStockPortfolioPageMapper.as(orderPage);
            result.setResponse(page);
        }
        createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
        return result;
        } catch (Exception e) {
            log.error("the data recieved from client was not pageable, message =", e.getMessage());
            return null;
        }
    }

    private List<String> createNscCodeList(Response<List<DailyCustomerStockPortfolio>> dailyCustomerStockPortfolioResponse) {
        List<String> nscCodeList = new ArrayList<>();
        for (DailyCustomerStockPortfolio dailyCustomerStockPortfolio : dailyCustomerStockPortfolioResponse.getResponse()) {
            Assert.notNull(dailyCustomerStockPortfolio.getSymbolISIN());
            nscCodeList.add(dailyCustomerStockPortfolio.getSymbolISIN());
        }
        return nscCodeList;
    }

    private Response<List<DailyCustomerStockPortfolio>> setPriceWithFirstQueueToResult(EmptyRequest request, Response<List<DailyCustomerStockPortfolio>> result, List<PriceWithFirstQueue> priceWithFirstQueueResponse){
        for (int i = 0; i < result.getResponse().size(); i++) {
            DailyCustomerStockPortfolio dailyCustomerStockPortfolio = result.getResponse().get(i);
            Assert.notNull(dailyCustomerStockPortfolio);
            Assert.notNull(dailyCustomerStockPortfolio.getSymbolISIN());
            //set Commission
            CommissionRequest commissionRequest = new CommissionRequest();
            commissionRequest.setToken(request.getToken());
            commissionRequest.setSymbolISIN(result.getResponse().get(i).getSymbolISIN());
            //todo is it better to get commission az a list?
            Commission commission = commissionService.findCommission(commissionRequest).getResponse();
            Assert.notNull(commission);
            result.getResponse().get(i).setCommissionDetail(commission);
            //set PriceWithFirstQueue
            result.getResponse().get(i).setPriceWithFirstQueue(setPriceWithFirstQueue(priceWithFirstQueueResponse, dailyCustomerStockPortfolio.getSymbolISIN()));
        }
        return result;
    }

    public PriceWithFirstQueue setPriceWithFirstQueue(List<PriceWithFirstQueue> priceWithFirstQueueResponse, String nscCode){
        PriceWithFirstQueue result;
        for (int j = 0; j < priceWithFirstQueueResponse.size(); j++) {
            PriceWithFirstQueue priceWithFirstQueue = priceWithFirstQueueResponse.get(j);
            Assert.notNull(priceWithFirstQueue);
            Assert.notNull(priceWithFirstQueue.getSymbolISIN());
            if (nscCode.equals(priceWithFirstQueue.getSymbolISIN())) {
                return priceWithFirstQueue;
            }
        }
        return  null;
    }
}



