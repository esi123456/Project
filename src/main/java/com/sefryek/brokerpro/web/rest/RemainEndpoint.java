package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.response.mobile.account.Remain;
import com.sefryek.brokerpro.service.RemainService;
import org.glassfish.jersey.server.ManagedAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 18, Dec, 2016
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class RemainEndpoint {

    private RemainService service;

    @Autowired
    public RemainEndpoint(RemainService service) {
        this.service = service;
    }

    @GET
    @Path("v1/remain")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response getRemain(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token) {
        EmptyRequest request = new EmptyRequest();
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<Remain> result = service.getRemain(request);
        return Response.ok(result).build();
    }

}
