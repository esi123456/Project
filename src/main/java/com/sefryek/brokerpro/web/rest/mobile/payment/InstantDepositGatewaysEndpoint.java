package com.sefryek.brokerpro.web.rest.mobile.payment;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.response.mobile.peyment.InstantDepositGateway;
import com.sefryek.brokerpro.service.mobile.peyment.InstantDepositGatewaysService;
import org.glassfish.jersey.server.ManagedAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

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
public class InstantDepositGatewaysEndpoint {

    private InstantDepositGatewaysService service;

    @Autowired
    public InstantDepositGatewaysEndpoint(InstantDepositGatewaysService service) {
        this.service = service;
    }

    @POST
    @Path("v1/instant-deposit-gateways")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findInstantDepositGateways(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid EmptyRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<List<InstantDepositGateway>> result = service.findInstantDepositGateways(request);
        return Response.ok(result).build();
    }

}
