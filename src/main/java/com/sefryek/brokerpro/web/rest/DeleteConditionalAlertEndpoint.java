package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.alert.DeleteConditionalAlertRequest;
import com.sefryek.brokerpro.dto.response.mobile.alert.DeleteConditionalAlert;
import com.sefryek.brokerpro.service.DeleteConditionalAlertService;
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
 * @date: 03, May, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class DeleteConditionalAlertEndpoint {

    private DeleteConditionalAlertService service;

    @Autowired
    public DeleteConditionalAlertEndpoint(DeleteConditionalAlertService service) {
        this.service = service;
    }

    @POST
    @Path("v1/delete-conditional-alert")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response deleteConditionalAlert(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid DeleteConditionalAlertRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<DeleteConditionalAlert> result = service.deleteConditionalAlert(request);
        return Response.ok(result).build();
    }

}
