package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.PriceRequest;
import com.sefryek.brokerpro.dto.response.market.price.Price;
import com.sefryek.brokerpro.service.SymbolPriceService;
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
 * @date: 18, Dec, 2016
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class SymbolPriceEndpoint {

    private SymbolPriceService service;

    @Autowired
    public SymbolPriceEndpoint(SymbolPriceService service) {
        this.service = service;
    }

    @POST
    @Path("v1/price")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findSymbolPrice(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid PriceRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<Price> result = service.findSymbolPrice(request);
        return Response.ok(result).build();
    }

}

