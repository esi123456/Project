package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.MessagesRequest;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.message.Message;
import com.sefryek.brokerpro.service.mapper.MessagePageMapper;
import com.sefryek.brokerpro.service.mapper.MessagesMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.message.MessagesTadbir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.Form;
import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 11, Mar, 2017
 */
@Component
public class MessagesService extends Service<MessagesTadbir> {

    @Autowired
    private MessagesMapper messagesMapper;

    @Autowired
    private MessagePageMapper messagePageMapper;

    public MessagesService() {
        super(MessagesTadbir.class);
    }

    public Response<Page<Message>> getMessages(MessagesRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(), Constants.MESSAGES_URL), ODataAuthStrategy.USER_NAME_ODATA, true, request.getPageable());
        urlBuilder.addEqualFilter("IsRead", request.getOnlyRead());
        if(request.getMessageId() != null){
            if(request.getMessageId() != 0){
                urlBuilder.addEqualFilter("MessageId", request.getMessageId());
            }
        }
        MessagesTadbir result = callWebService(HttpMethod.GET, new Form(), urlBuilder, AuthStrategy.USER, request.getToken());
        Response<Page<Message>> gatewayResponse = new Response<>();
        if (result.isSuccessful()) {
            List<Message> out = messagesMapper.as(result.getMessageList());
            org.springframework.data.domain.Page<Message> messagePage = new PageImpl<>(out, new PageRequest(request.getPageable().getPage(), request.getPageable().getSize()), result.getTotalRecord());
            Page<Message> page = messagePageMapper.as(messagePage);
            gatewayResponse.setResponse(page);
        }
        createResponse(gatewayResponse, result.isSuccessful(), result.getErrorCode(), result.getErrorDescription());
        return gatewayResponse;
    }
}
