package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.SymbolPriceWithFirstQueueRequest;
import com.sefryek.brokerpro.dto.response.market.price.first.PriceWithFirstQueue;
import com.sefryek.brokerpro.service.SymbolPriceWithFirstQueueService;
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
 * @date: 31, Dec, 2016
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class SymbolPriceWithFirstQueueEndpoint {

    private SymbolPriceWithFirstQueueService service;

    @Autowired
    public SymbolPriceWithFirstQueueEndpoint(SymbolPriceWithFirstQueueService service) {
        this.service = service;
    }

    @POST
    @Path("v1/symbol-price-with-first-queue")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findSymbolPriceWithFirstQueue(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid SymbolPriceWithFirstQueueRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<PriceWithFirstQueue> result = service.findSymbolPriceListWithFirstQueue(request);
        return Response.ok(result).build();
    }

}
