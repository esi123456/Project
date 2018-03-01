package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.Language;
import com.sefryek.brokerpro.dto.request.Request;
import com.sefryek.brokerpro.dto.request.SymbolPriceListWithFirstQueueRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.market.price.first.PriceWithFirstQueue;
import com.sefryek.brokerpro.dto.response.market.price.first.SymbolState;
import com.sefryek.brokerpro.service.mapper.PriceListWithFirstQueueEnglishMapper;
import com.sefryek.brokerpro.service.mapper.PriceListWithFirstQueuePersianMapper;
import com.sefryek.brokerpro.service.odata.OrFilters;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.tadbir.dto.response.market.price.first.PriceWithFirstQueueTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.market.price.first.PricesWithFirstQueueTadbir;
import com.sefryek.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 06, Mar, 2017
 */
@Component
public class SymbolPriceListWithFirstQueueService extends Service<PricesWithFirstQueueTadbir> {

    @Autowired
    private PriceListWithFirstQueuePersianMapper priceListWithFirstQueuePersianMapper;

    @Autowired
    private PriceListWithFirstQueueEnglishMapper priceListWithFirstQueueEnglishMapper;

    public SymbolPriceListWithFirstQueueService() {
        super(PricesWithFirstQueueTadbir.class);
    }

    public Response<List<PriceWithFirstQueue>> findSymbolPriceListWithFirstQueue(SymbolPriceListWithFirstQueueRequest request) {
        PricesWithFirstQueueTadbir responseTadbir = findByMemberList(request);
        return createGatewayResponseByLanguage(responseTadbir, request);
    }

    public PricesWithFirstQueueTadbir findByMemberList(SymbolPriceListWithFirstQueueRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
//        UrlBuilder urlBuilder = new UrlBuilder(createMarketUrl(Constants.MARKET_SYMBOL_URL));
//        OrFilters orFilters = new OrFilters();
//        for (String symbolISIN : request.getSymbolsISIN()) {
//            orFilters.addEqualFilter("SymbolISIN", symbolISIN);
//        }
//        urlBuilder.addOrFilters(orFilters);
//        return callWebServiceHttpMethodGET(urlBuilder);

        return findPricesWithFirstQueueTadbirInSteps(request);
    }

    //todo: Filter in OData couldn't accept more than 20 records so we have to limit sending in OData until Tadbir fix this problem
    private PricesWithFirstQueueTadbir findPricesWithFirstQueueTadbirInSteps(SymbolPriceListWithFirstQueueRequest request) {
        PricesWithFirstQueueTadbir responseTadbir = new PricesWithFirstQueueTadbir();
        List<PriceWithFirstQueueTadbir> priceListTadbir = new ArrayList<>();
        int maxSizeInPage = 20; //because Tadbir's OData filters couldn't be more than 20
        int size = request.getSymbolsISIN().size();
        int pages = size / maxSizeInPage;
        for(int i=0; i<=pages; i++){
            UrlBuilder urlBuilder = new UrlBuilder(createMarketUrl(Constants.MARKET_SYMBOL_URL));
            OrFilters orFilters = new OrFilters();
            for(int j=(i * maxSizeInPage); j<Math.min(((i+1) * maxSizeInPage), size); j++){
                String symbolISIN = request.getSymbolsISIN().get(j);
                orFilters.addEqualFilter("SymbolISIN", symbolISIN);
            }
            if(orFilters.getOrFilterList().size() > 0){
                urlBuilder.addOrFilters(orFilters);
                PricesWithFirstQueueTadbir tempResponseTadbir = callWebServiceHttpMethodGET(urlBuilder);
                responseTadbir = tempResponseTadbir;
                if(tempResponseTadbir.isSuccessful()){
                    priceListTadbir.addAll(tempResponseTadbir.getPriceListWithFirstQueueTadbir());
                } else {
                    break;
                }
            }
        }
        if(CollectionUtils.isNotEmpty(priceListTadbir)){
            responseTadbir.setPriceListWithFirstQueueTadbir(priceListTadbir);
            responseTadbir.setTotalRecord(Long.valueOf(priceListTadbir.size()));
        }
        return responseTadbir;
    }

    protected Response<List<PriceWithFirstQueue>> createGatewayResponseByLanguage(PricesWithFirstQueueTadbir responseTadbir, Request request) {
        Response<List<PriceWithFirstQueue>> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            if (Language.ENGLISH.equals(request.getLanguage())) {
                result.setResponse(priceListWithFirstQueueEnglishMapper.as(responseTadbir.getPriceListWithFirstQueueTadbir()));
            } else {
                result.setResponse(priceListWithFirstQueuePersianMapper.as(responseTadbir.getPriceListWithFirstQueueTadbir()));
            }
            //todo its better to map symbolState in selma mapper later
            for (int i=0; i<responseTadbir.getPriceListWithFirstQueueTadbir().size(); i++) {
                PriceWithFirstQueueTadbir priceWithFirstQueueTadbir = responseTadbir.getPriceListWithFirstQueueTadbir().get(i);
                result.getResponse().get(i).setSymbolState(SymbolState.AUTHORIZED);
            }
        }
        return createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
    }

}
