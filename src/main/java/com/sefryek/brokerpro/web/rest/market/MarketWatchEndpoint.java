package com.sefryek.brokerpro.web.rest.market;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.market.watch.MarketWatchRequest;
import com.sefryek.brokerpro.dto.response.market.watch.MarketWatch;
import com.sefryek.brokerpro.service.market.watch.MarketWatchService;
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
 * @date: 30, May, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class MarketWatchEndpoint {

    private MarketWatchService service;

    @Autowired
    public MarketWatchEndpoint(MarketWatchService service) {
        this.service = service;
    }

    @POST
    @Path("v1/market-watch")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findMarketWatch(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid MarketWatchRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<MarketWatch> result = service.findMarketWatch(request);
        return Response.ok(result).build();
    }

}
