package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.CheckVersionCodeRequest;
import com.sefryek.brokerpro.dto.response.CheckVersionCode;
import com.sefryek.brokerpro.service.CheckVersionCodeService;
import org.glassfish.jersey.server.ManagedAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 01, May, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class CheckVersionCodeEndpoint {

    private CheckVersionCodeService service;

    @Autowired
    public CheckVersionCodeEndpoint(CheckVersionCodeService service) {
        this.service = service;
    }

    @POST
    @Path("v1/check-version-code")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response checkVersionCode(@Valid CheckVersionCodeRequest request) {
        com.sefryek.brokerpro.dto.response.Response<CheckVersionCode> result = service.checkVersionCode(request);
        return Response.ok(result).build();
    }

}
