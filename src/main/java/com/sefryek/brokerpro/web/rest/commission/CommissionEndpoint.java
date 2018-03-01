package com.sefryek.brokerpro.web.rest.commission;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.domain.Commission;
import com.sefryek.brokerpro.dto.request.commission.CommissionRequest;
import com.sefryek.brokerpro.service.commision.CommissionService;
import org.glassfish.jersey.server.ManagedAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @auther: Ashkan Haghighi Kia
 * @email: kia@syspod.co
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class CommissionEndpoint {

    private CommissionService service;

    @Autowired
    public CommissionEndpoint(CommissionService service) {
        this.service = service;
    }

    @POST
    @Path("v1/commission-detail")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findCommission(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid CommissionRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<Commission> result = service.findCommission(request);
        return Response.ok(result).build();
    }

}
