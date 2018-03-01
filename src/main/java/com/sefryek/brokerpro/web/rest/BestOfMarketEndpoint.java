package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.BestOfMarketRequest;
import com.sefryek.brokerpro.dto.response.market.price.Price;
import com.sefryek.brokerpro.service.BestOfMarketService;
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
 * @date: 08, Jan, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class BestOfMarketEndpoint {

    private BestOfMarketService service;

    @Autowired
    public BestOfMarketEndpoint(BestOfMarketService service) {
        this.service = service;
    }

    @POST
    @Path("v1/best-of-market")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findBestOfMarket(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid BestOfMarketRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<List<Price>> result = service.findBestOfMarket(request);
        return Response.ok(result).build();
    }

}
