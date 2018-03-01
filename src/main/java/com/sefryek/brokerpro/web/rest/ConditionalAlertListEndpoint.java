package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.alert.ConditionalAlertListRequest;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.brokerpro.dto.response.mobile.alert.ConditionalAlertList;
import com.sefryek.brokerpro.service.ConditionalAlertListService;
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
 * @date: 29, Apr, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class ConditionalAlertListEndpoint {

    private ConditionalAlertListService service;

    @Autowired
    public ConditionalAlertListEndpoint(ConditionalAlertListService service) {
        this.service = service;
    }

    @POST
    @Path("v1/conditional-alert-list")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findConditionalAlertList(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid ConditionalAlertListRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<Page<ConditionalAlertList>> result = service.findConditionalAlertList(request);
        return Response.ok(result).build();
    }

}
