package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.Language;
import com.sefryek.brokerpro.dto.request.SymbolPriceWithFirstQueueRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.market.price.first.PriceWithFirstQueue;
import com.sefryek.brokerpro.dto.response.market.price.first.SymbolState;
import com.sefryek.brokerpro.service.mapper.PriceListWithFirstQueueEnglishMapper;
import com.sefryek.brokerpro.service.mapper.PriceListWithFirstQueuePersianMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.tadbir.dto.response.market.price.first.PricesWithFirstQueueTadbir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 31, Dec, 2016
 */
@Component
public class SymbolPriceWithFirstQueueService extends Service<PricesWithFirstQueueTadbir> {

//    @Autowired
//    private PriceWithFirstQueuePersianMapper priceWithFirstQueuePersianMapper;
//
//    @Autowired
//    private PriceWithFirstQueueEnglishMapper priceWithFirstQueueEnglishMapper;

    @Autowired
    private PriceListWithFirstQueuePersianMapper priceListWithFirstQueuePersianMapper;

    @Autowired
    private PriceListWithFirstQueueEnglishMapper priceListWithFirstQueueEnglishMapper;

    public SymbolPriceWithFirstQueueService() {
        super(PricesWithFirstQueueTadbir.class);
    }

    public Response<PriceWithFirstQueue> findSymbolPriceListWithFirstQueue(SymbolPriceWithFirstQueueRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMarketUrl(Constants.MARKET_SYMBOL_URL));
        urlBuilder.addEqualFilter("SymbolISIN", request.getSymbolISIN());
        PricesWithFirstQueueTadbir responseTadbir = callWebServiceHttpMethodGET(urlBuilder);
        Response<List<PriceWithFirstQueue>> resultList = new Response<>();
        Response<PriceWithFirstQueue> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            if (Language.ENGLISH.equals(request.getLanguage())) {
                resultList.setResponse(priceListWithFirstQueueEnglishMapper.as(responseTadbir.getPriceListWithFirstQueueTadbir()));
            } else {
                resultList.setResponse(priceListWithFirstQueuePersianMapper.as(responseTadbir.getPriceListWithFirstQueueTadbir()));
            }

            result.setResponse(resultList.getResponse().get(0));
            //todo its better to map symbolState in selma mapper later
            result.getResponse().setSymbolState(SymbolState.AUTHORIZED);
        }
        createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
        return result;
    }



}
