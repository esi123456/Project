package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.SymbolPriceListWithFirstQueueRequest;
import com.sefryek.brokerpro.dto.response.market.price.first.PriceWithFirstQueue;
import com.sefryek.brokerpro.service.SymbolPriceListWithFirstQueueService;
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
 * @date: 07, Mar, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class SymbolPriceListWithFirstQueueEndpoint {

    private SymbolPriceListWithFirstQueueService service;

    @Autowired
    public SymbolPriceListWithFirstQueueEndpoint(SymbolPriceListWithFirstQueueService service) {
        this.service = service;
    }

    @POST
    @Path("v1/symbol-price-list-with-first-queue")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findSymbolPriceListWithFirstQueue(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid SymbolPriceListWithFirstQueueRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<List<PriceWithFirstQueue>> result = service.findSymbolPriceListWithFirstQueue(request);
        return Response.ok(result).build();
    }

}
