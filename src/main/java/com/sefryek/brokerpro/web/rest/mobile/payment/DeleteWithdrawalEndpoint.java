package com.sefryek.brokerpro.web.rest.mobile.payment;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.mobile.peyment.DeleteWithdrawalRequest;
import com.sefryek.brokerpro.dto.response.DefaultResponse;
import com.sefryek.brokerpro.service.DefaultService;
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
 * @date: 10, May, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class DeleteWithdrawalEndpoint {

    private DefaultService service;

    @Autowired
    public DeleteWithdrawalEndpoint(DefaultService service) {
        this.service = service;
    }

    @POST
    @Path("v1/delete-withdrawal")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response deleteWithdrawal(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid DeleteWithdrawalRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<DefaultResponse> result = service.deleteWithdrawal(request);
        return Response.ok(result).build();
    }

}
