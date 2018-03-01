package com.sefryek.brokerpro.service.market.watch;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.market.watch.MarketWatchRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.market.watch.MarketWatch;
import com.sefryek.brokerpro.service.Service;
import com.sefryek.brokerpro.service.mapper.MarketWatchMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.tadbir.dto.response.market.watch.MarketWatchResponseTadbir;
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
 * @date: 30, May, 2017
 */
@Component
public class MarketWatchService extends Service<MarketWatchResponseTadbir> {

    @Autowired
    private MarketWatchMapper marketWatchMapper;

    public MarketWatchService() {
        super(MarketWatchResponseTadbir.class);
    }

    public Response<MarketWatch> findMarketWatch(MarketWatchRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMarketUrl(Constants.MARKET_WATCH_URL));
        MarketWatchResponseTadbir responseTadbir = callWebServiceHttpMethodGET(urlBuilder);
        List<MarketWatch> resultList = new ArrayList<>();
        Response<MarketWatch> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            resultList.addAll(marketWatchMapper.as(responseTadbir.getMarketWatchList()));
            MarketWatch marketWatch = resultList.stream()
                    .filter(x -> request.getMarketType().equals(x.getMarketType()))
                    .findAny()
                    .orElse(null);
            result.setResponse(marketWatch);
        }

        return createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
    }

}
