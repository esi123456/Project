package com.sefryek.brokerpro.web.rest.mobile.payment;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.mobile.peyment.WithdrawalDetailRequest;
import com.sefryek.brokerpro.dto.response.mobile.peyment.WithdrawalDetail;
import com.sefryek.brokerpro.service.mobile.peyment.WithdrawalDetailService;
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
 * @date: 09, May, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class WithdrawalDetailEndpoint {

    private WithdrawalDetailService service;

    @Autowired
    public WithdrawalDetailEndpoint(WithdrawalDetailService service) {
        this.service = service;
    }

    @GET
    @Path("v1/withdrawal-detail")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response getWithdrawalDetail(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token) {
        WithdrawalDetailRequest request = new WithdrawalDetailRequest();
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<WithdrawalDetail> result = service.getWithdrawalDetail(request);
        return Response.ok(result).build();
    }

}
