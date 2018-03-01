package com.sefryek.brokerpro.web.rest.mobile.payment;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.brokerpro.dto.response.mobile.peyment.WithdrawalList;
import com.sefryek.brokerpro.service.mobile.peyment.WithdrawalListService;
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
public class WithdrawalListEndpoint {

    private WithdrawalListService service;

    @Autowired
    public WithdrawalListEndpoint(WithdrawalListService service) {
        this.service = service;
    }

    @POST
    @Path("v1/withdrawal-list")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response getWithdrawalList(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid EmptyRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<Page<WithdrawalList>> result = service.getWithdrawalList(request);
        return Response.ok(result).build();
    }

}
