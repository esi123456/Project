package com.sefryek.brokerpro.web.rest.mobile.payment;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.mobile.peyment.InstantDepositStatusRequest;
import com.sefryek.brokerpro.dto.response.mobile.peyment.InstantDepositStatus;
import com.sefryek.brokerpro.service.mobile.peyment.InstantDepositStatusService;
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
 * @date: 16, May, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class InstantDepositStatusEndpoint {

    private InstantDepositStatusService service;

    @Autowired
    public InstantDepositStatusEndpoint(InstantDepositStatusService service) {
        this.service = service;
    }

    @POST
    @Path("v1/instant-deposit-status")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response getInstantDepositStatus(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid InstantDepositStatusRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<InstantDepositStatus> result = service.getInstantDepositStatus(request);
        return Response.ok(result).build();
    }

}
