package com.sefryek.brokerpro.web.rest.mobile.broker;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.mobile.broker.DeleteChangeBrokerRequest;
import com.sefryek.brokerpro.dto.request.mobile.broker.GetChangeBrokerRequest;
import com.sefryek.brokerpro.dto.request.mobile.broker.AddChangeBrokerRequest;
import com.sefryek.brokerpro.dto.response.DefaultResponse;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.brokerpro.dto.response.mobile.broker.ChangeBroker;
import com.sefryek.brokerpro.service.mobile.broker.ChangeBrokerService;
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
 * @date: 29, May, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class ChangeBrokerEndpoint {

    private ChangeBrokerService service;

    @Autowired
    public ChangeBrokerEndpoint(ChangeBrokerService service) {
        this.service = service;
    }

    @POST
    @Path("v1/change-broker-list")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findChangeBroker(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid GetChangeBrokerRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<Page<ChangeBroker>> result = service.findChangeBroker(request);
        return Response.ok(result).build();
    }

    @POST
    @Path("v1/add-change-broker")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response addChangeBroker(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid AddChangeBrokerRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<DefaultResponse> result = service.addChangeBroker(request);
        return Response.ok(result).build();
    }

    @POST
    @Path("v1/delete-change-broker")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response deleteChangeBroker(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid DeleteChangeBrokerRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<DefaultResponse> result = service.deleteChangeBroker(request);
        return Response.ok(result).build();
    }

}
