package com.sefryek.brokerpro.web.rest.mobile.payment;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.mobile.peyment.InstantDepositTokenRequest;
import com.sefryek.brokerpro.dto.response.mobile.peyment.InstantDepositToken;
import com.sefryek.brokerpro.service.mobile.peyment.InstantDepositTokenService;
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
 * @date: 09, May, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class InstantDepositTokenEndpoint {

    private InstantDepositTokenService service;

    @Autowired
    public InstantDepositTokenEndpoint(InstantDepositTokenService service) {
        this.service = service;
    }

    @POST
    @Path("v1/instant-deposit-token")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response getInstantDepositToken(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid InstantDepositTokenRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<InstantDepositToken> result = service.getInstantDepositToken(request);
        return Response.ok(result).build();
    }

}
