package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.MessageByIdRequest;
import com.sefryek.brokerpro.dto.response.DefaultResponse;
import com.sefryek.brokerpro.service.DefaultService;
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
 * @date: 15, Apr, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class MessageReadFlagEndpoint {

    private DefaultService service;

    @Autowired
    public MessageReadFlagEndpoint(DefaultService service) {
        this.service = service;
    }

    @POST
    @Path("v1/message-read-flag")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response setMessageReadFlag(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid MessageByIdRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<DefaultResponse> result = service.setMessageReadFlag(request);
        return Response.ok(result).build();
    }

}