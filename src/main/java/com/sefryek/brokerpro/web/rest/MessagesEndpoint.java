package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.MessagesRequest;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.brokerpro.dto.response.mobile.message.Message;
import com.sefryek.brokerpro.service.MessagesService;
import org.glassfish.jersey.server.ManagedAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 11, Mar, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class MessagesEndpoint {

    private MessagesService service;

    @Autowired
    public MessagesEndpoint(MessagesService service) {
        this.service = service;
    }

    @POST
    @Path("v1/messages")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response getMessages(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid MessagesRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<Page<Message>> result = service.getMessages(request);
        return Response.ok(result).build();
    }

}
