package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.market.activity.MarketActivityCode;
import com.sefryek.brokerpro.dto.request.market.activity.MarketActivityRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.market.activity.MarketActivity;
import com.sefryek.brokerpro.service.mapper.MarketActivityMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.tadbir.dto.response.market.activity.MarketActivityData;
import com.sefryek.brokerpro.tadbir.dto.response.market.activity.MarketActivityTAdbir;
import com.sefryek.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 25, Dec, 2016
 */
@Component
public class MarketActivityService extends Service<MarketActivityData> {

    @Autowired
    private MarketActivityMapper marketActivityMapper;

    public MarketActivityService() {
        super(MarketActivityData.class);
    }

    public Response<MarketActivity> findMarketActivity(MarketActivityRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMarketUrl(Constants.MARKET_ACTIVITY_URL));
        MarketActivityData responseTadbir = callWebServiceHttpMethodGET(urlBuilder);
        Response<MarketActivity> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            MarketActivityTAdbir marketActivityTAdbir = findByMarketCode(request, responseTadbir);
            Assert.notNull(marketActivityTAdbir);
            result.setResponse(marketActivityMapper.as(marketActivityTAdbir));
        }
        createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
        return result;
    }

    private MarketActivityTAdbir findByMarketCode(MarketActivityRequest request, MarketActivityData responseTadbir){
        if(ObjectUtils.isNull(request.getMarketCode())){
            request.setMarketCode(MarketActivityCode.BOURS);
        }
        MarketActivityTAdbir result = responseTadbir.getMarketActivity().stream()
                .filter(marketActivity -> request.getMarketCode().equals(marketActivity.getMarketCode()))
                .findAny()
                .orElse(null);

        if(ObjectUtils.isNull(result)){
            result = new MarketActivityTAdbir();
        }
        return result;
    }

}
