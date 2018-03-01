package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.BestOfMarketRequest;
import com.sefryek.brokerpro.dto.request.Language;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.market.price.Price;
import com.sefryek.brokerpro.service.mapper.BestOfMarketEnglishMapper;
import com.sefryek.brokerpro.service.mapper.BestOfMarketPersianMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.tadbir.dto.response.market.best.BestOfMarketsTadbir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.ws.rs.core.Form;
import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 08, Jan, 2017
 */
@Component
public class BestOfMarketService extends Service<BestOfMarketsTadbir> {

    @Autowired
    private BestOfMarketPersianMapper bestOfMarketPersianMapper;

    @Autowired
    private BestOfMarketEnglishMapper bestOfMarketEnglishMapper;

    public BestOfMarketService() {
        super(BestOfMarketsTadbir.class);
    }

    public Response<List<Price>> findBestOfMarket(BestOfMarketRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        Form form = new Form();
        form.param("sorting", String.valueOf(request.getSorting()));
        BestOfMarketsTadbir result = callWebServiceHttpMethodGET(new UrlBuilder(createMarketUrl(Constants.BEST_OF_MARKET_URL)));
        Response<List<Price>> bestOfMarketResponse = new Response<>();
        if (result.isSuccessful()) {
            if (Language.ENGLISH.equals(request.getLanguage())) {
                bestOfMarketResponse.setResponse(bestOfMarketEnglishMapper.as(result.getBestOfMarketTadbir()));
            } else {
                bestOfMarketResponse.setResponse(bestOfMarketPersianMapper.as(result.getBestOfMarketTadbir()));
            }
        }
        createResponse(bestOfMarketResponse, result.isSuccessful(), result.getErrorCode(), result.getErrorDescription());
        return bestOfMarketResponse;
    }

}
