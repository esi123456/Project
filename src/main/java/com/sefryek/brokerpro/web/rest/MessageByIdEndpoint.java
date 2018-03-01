package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.MessageByIdRequest;
import com.sefryek.brokerpro.dto.response.market.message.ListOfMessage;
import com.sefryek.brokerpro.service.MessageByIdService;
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
 * @date: 04, Mar, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class MessageByIdEndpoint {

    private MessageByIdService service;

    @Autowired
    public MessageByIdEndpoint(MessageByIdService service) {
        this.service = service;
    }

    @POST
    @Path("v1/message-by-id")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findMessageById(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid MessageByIdRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<ListOfMessage> result = service.findMessageById(request);
        return Response.ok(result).build();
    }

}
