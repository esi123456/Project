package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.BestOfMarketRequest;
import com.sefryek.brokerpro.dto.response.market.price.first.PriceWithFirstQueue;
import com.sefryek.brokerpro.service.BestOfMarketWithFirstQueueService;
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
 * @date: 25, Feb, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class BestOfMarketWithFirstQueueEndpoint {

    private BestOfMarketWithFirstQueueService service;

    @Autowired
    public BestOfMarketWithFirstQueueEndpoint(BestOfMarketWithFirstQueueService service) {
        this.service = service;
    }

    @POST
    @Path("v1/best-of-market-with-first-queue")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findBestOfMarketWithFirstQueue(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid BestOfMarketRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<List<PriceWithFirstQueue>> result = service.findBestOfMarketWithFirstQueue(request);
        return Response.ok(result).build();
    }

}
