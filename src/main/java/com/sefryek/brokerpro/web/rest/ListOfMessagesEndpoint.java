package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.brokerpro.dto.response.market.message.ListOfMessage;
import com.sefryek.brokerpro.service.ListOfMessagesService;
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
 * @date: 09, Jan, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class ListOfMessagesEndpoint {

    private ListOfMessagesService service;

    @Autowired
    public ListOfMessagesEndpoint(ListOfMessagesService service) {
        this.service = service;
    }

    @POST
    @Path("v1/list-of-messages")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findListOfMessages(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid EmptyRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<Page<ListOfMessage>> result = service.findListOfMessages(request);
        return Response.ok(result).build();
    }

}
