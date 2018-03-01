package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.NaturalLegalRequest;
import com.sefryek.brokerpro.dto.response.market.reallegal.NaturalLegal;
import com.sefryek.brokerpro.service.NaturalLegalService;
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
 * @date: 12, Feb, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class NaturalLegalEndpoint {

    private NaturalLegalService service;

    @Autowired
    public NaturalLegalEndpoint(NaturalLegalService service) {
        this.service = service;
    }

    @POST
    @Path("v1/natural-legal")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findNaturalLegalData(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid NaturalLegalRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<NaturalLegal> result = service.findNaturalLegalData(request);
        return Response.ok(result).build();
    }

}
