package com.sefryek.brokerpro.web.rest.mobile.payment;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.response.mobile.peyment.DepositReason;
import com.sefryek.brokerpro.service.mobile.peyment.DepositReasonService;
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
 * @date: 31, Jul, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class DepositReasonEndpoint {

    private DepositReasonService service;

    @Autowired
    public DepositReasonEndpoint(DepositReasonService service) {
        this.service = service;
    }

    @GET
    @Path("v1/deposit-reason")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findDepositReason(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token) {
        EmptyRequest request = new EmptyRequest();
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<DepositReason> result = service.findDepositReason(request);
        return Response.ok(result).build();
    }

}