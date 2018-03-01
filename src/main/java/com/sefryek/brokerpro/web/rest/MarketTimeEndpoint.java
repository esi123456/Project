package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.response.market.time.MarketTime;
import com.sefryek.brokerpro.service.MarketTimeService;
import org.glassfish.jersey.server.ManagedAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 11, Feb, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class MarketTimeEndpoint {

    private MarketTimeService service;

    @Autowired
    public MarketTimeEndpoint(MarketTimeService service) {
        this.service = service;
    }

    @GET
    @Path("v1/market-time")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response getMarketTime(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token) {
        EmptyRequest request = new EmptyRequest();
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<MarketTime> result = service.getMarketTime(request);
        return Response.ok(result).build();
    }

    @GET
    @Path("v1/market-time2")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response getMarketTime2() {
        EmptyRequest request = new EmptyRequest();
        com.sefryek.brokerpro.dto.response.Response<MarketTime> result = service.getMarketTime2(request);
        return Response.ok(result).build();
    }

}
