package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.MessageByIdRequest;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.market.message.ListOfMessage;
import com.sefryek.brokerpro.exception.ErrorCode;
import com.sefryek.brokerpro.service.mapper.ListOfMessagesMapper;
import com.sefryek.brokerpro.service.mapper.ListOfMessagesPageMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.tadbir.dto.response.market.message.list.ListOfMessagesTadbir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 04, Mar, 2017
 */
@Component
public class MessageByIdService extends Service<ListOfMessagesTadbir> {

    @Autowired
    private ListOfMessagesMapper listOfMessagesMapper;

    @Autowired
    private ListOfMessagesPageMapper listOfMessagesPageMapper;

    public MessageByIdService() {
        super(ListOfMessagesTadbir.class);
    }

    public Response<ListOfMessage> findMessageById(MessageByIdRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMarketUrl(Constants.LIST_OF_MESSAGES_URL));
        if(request.getMessageId() == null){
            return  createResponse(null, false, ErrorCode.BAD_REQUEST_EXCEPTION.getCode(), ErrorCode.BAD_REQUEST_EXCEPTION.getDescription());
        }
        urlBuilder.addEqualFilter("MessageId", request.getMessageId());
        ListOfMessagesTadbir responseTadbir = callWebServiceHttpMethodGET(urlBuilder);
        Response<ListOfMessage> result = new Response<>();
        if (responseTadbir.isSuccessful()) {
            List<ListOfMessage> out = listOfMessagesMapper.as(responseTadbir.getListOfMessages());
            PageImpl<ListOfMessage> istOfMessagePage = new PageImpl<>(out, new PageRequest(0, 1), responseTadbir.getTotalRecord());
            Page<ListOfMessage> page = listOfMessagesPageMapper.as(istOfMessagePage);
            result.setResponse(page.getContent().get(0));
        }
        return createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
    }

}
