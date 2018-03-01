package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.QueueRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.market.queue.Queue;
import com.sefryek.brokerpro.service.mapper.QueuesMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.market.queue.QueuesTadbir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by amin.malekpour on 2016-12-13.
 */
@Component
public class SymbolQueueService extends Service<QueuesTadbir> {

    @Autowired
    private QueuesMapper queuesMapper;

    public SymbolQueueService() {
        super(QueuesTadbir.class);
    }

    public Response<List<Queue>> findQueue(QueueRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMarketUrl(Constants.SYMBOL_QUEUE_URL), ODataAuthStrategy.NONE);
        urlBuilder.appendUrl(request.getSymbolISIN());
        QueuesTadbir result = callWebServiceHttpMethodGET(urlBuilder);
        Response<List<Queue>> queuesResponse = new Response<>();
        if (result.isSuccessful()) {
            queuesResponse.setResponse(queuesMapper.as(result.getQueueTadbir()));
        }
        createResponse(queuesResponse, result.isSuccessful(), result.getErrorCode(), result.getErrorDescription());
        return queuesResponse;
    }

}
