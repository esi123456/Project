package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.dto.request.HealthCheckRequest;
import com.sefryek.brokerpro.dto.response.HealthCheck;
import com.sefryek.brokerpro.service.HealthCheckService;
import org.glassfish.jersey.server.ManagedAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 19, Feb, 2017
 */
@Component
@Path("/services")
@Produces(MediaType.APPLICATION_JSON)
public class HealthCheckEndpoint {

    private HealthCheckService service;
    @Autowired
    public HealthCheckEndpoint(HealthCheckService service) {
        this.service = service;
    }

    @POST
    @Path("v1/health-check")
    @ManagedAsync
    @Consumes(MediaType.APPLICATION_JSON)
    public Response executeHealthCheck(@Valid HealthCheckRequest request) {
        com.sefryek.brokerpro.dto.response.Response<HealthCheck> result = service.executeHealthCheck(request);
        return Response.ok(result).build();
    }

    @GET
    @Path("v1/health-check")
    @ManagedAsync
    @Consumes(MediaType.APPLICATION_JSON)
    public Response executeHealthCheck() {
        com.sefryek.brokerpro.dto.response.Response<HealthCheck> result = service.executeHealthCheck();
        return Response.ok(result).build();
    }

}
