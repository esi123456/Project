package com.sefryek.brokerpro.service.market;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.market.Index.IndexDetail;
import com.sefryek.brokerpro.service.Service;
import com.sefryek.brokerpro.service.mapper.IndexDetailMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.tadbir.dto.response.market.index.IndexDetailResponseTadbir;
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
 * @date: 28, May, 2017
 */
@Component
public class IndexDetailService extends Service<IndexDetailResponseTadbir> {

    @Autowired
    private IndexDetailMapper indexDetailMapper;

    public IndexDetailService() {
        super(IndexDetailResponseTadbir.class);
    }

    public Response<List<IndexDetail>> getIndexDetail(EmptyRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMarketUrl(Constants.MAIN_LAST_INFO_INDEX_URL));
        IndexDetailResponseTadbir responseTadbir = callWebServiceHttpMethodGET(urlBuilder);
        Response<List<IndexDetail>> queuesResponse = new Response<>();
        if (responseTadbir.isSuccessful()) {
            queuesResponse.setResponse(new ArrayList<>(indexDetailMapper.as(responseTadbir.getIndexInfo()).getIndexDetailMap().values()));
        }
        createResponse(queuesResponse, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
        return queuesResponse;
    }

}
