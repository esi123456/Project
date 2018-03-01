package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.HistoryDataRequest;
import com.sefryek.brokerpro.dto.request.market.HistoryType;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.market.history.HistoryData;
import com.sefryek.brokerpro.service.mapper.HistoryDataMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.tadbir.dto.response.market.history.HistoryDataResponseTadbir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 26, Dec, 2016
 */
@Component
public class HistoryDataService extends Service<HistoryDataResponseTadbir> {

    @Autowired
    private HistoryDataMapper historyDataMapper;

    public HistoryDataService() {
        super(HistoryDataResponseTadbir.class);
    }

    public Response<List<HistoryData>> findHistoryData(HistoryDataRequest request, HistoryType historyType) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        HistoryDataResponseTadbir responseTadbir = new HistoryDataResponseTadbir();
        Response<List<HistoryData>> result = new Response<>();
        UrlBuilder urlBuilder = null;
        if (HistoryType.SYMBOL.equals(historyType)) {
            urlBuilder = new UrlBuilder(createMarketUrl(Constants.SYMBOL_HISTORY_DATA_URL));
        } else if (HistoryType.INDEX.equals(historyType)) {
            urlBuilder = new UrlBuilder(createMarketUrl(Constants.INDEX_HISTORY_DATA_URL));
        }
        if (urlBuilder != null) {
            Date today = new Date();
            urlBuilder.appendUrl(request.getSymbolISIN());
            urlBuilder.appendUrl(convertDateToStringByHyphen(today));
            urlBuilder.appendUrl(convertDateToStringByHyphenPlusOneDay(today));
            urlBuilder.appendUrl(request.getTimePart());
            responseTadbir = callWebServiceHttpMethodGET(urlBuilder);
            if (responseTadbir.isSuccessful()) {
                result.setResponse(historyDataMapper.as(responseTadbir.getHistoryData()));
            }
        }
        createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
        return result;

    }
}
