package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.alert.AddConditionalAlertRequest;
import com.sefryek.brokerpro.dto.response.mobile.alert.AddConditionalAlert;
import com.sefryek.brokerpro.service.AddConditionalAlertService;
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
 * @date: 30, Apr, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class AddConditionalAlertEndpoint {

    private AddConditionalAlertService service;

    @Autowired
    public AddConditionalAlertEndpoint(AddConditionalAlertService service) {
        this.service = service;
    }

    @POST
    @Path("v1/add-conditional-alert")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response addConditionalAlert(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid AddConditionalAlertRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<AddConditionalAlert> result = service.addConditionalAlert(request);
        return Response.ok(result).build();
    }

}
