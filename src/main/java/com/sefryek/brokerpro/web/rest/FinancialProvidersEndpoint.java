package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.domain.FinancialProvider;
import com.sefryek.brokerpro.service.FinancialProvidersService;
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
 * @date: 30, Jan, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class FinancialProvidersEndpoint {

    private FinancialProvidersService service;

    @Autowired
    public FinancialProvidersEndpoint(FinancialProvidersService service) {
        this.service = service;
    }

    @POST
    @Path("v1/financial-providers")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    @Valid
    public Response findFinancialProviders(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid EmptyRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<List<FinancialProvider>> result = service.findFinancialProviders(request);
        return Response.ok(result).build();
    }

}
