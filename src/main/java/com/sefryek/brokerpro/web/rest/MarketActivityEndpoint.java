package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.market.activity.MarketActivityCode;
import com.sefryek.brokerpro.dto.request.market.activity.MarketActivityRequest;
import com.sefryek.brokerpro.dto.response.market.activity.MarketActivity;
import com.sefryek.brokerpro.service.MarketActivityService;
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
 * @date: 25, Dec, 2016
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class MarketActivityEndpoint {

    private MarketActivityService service;

    @Autowired
    public MarketActivityEndpoint(MarketActivityService service) {
        this.service = service;
    }

    @GET
    @Path("v1/market-activity")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findMarketActivity(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token) {
        //todo change this after device change this service
        MarketActivityRequest marketActivityRequest = new MarketActivityRequest();
        marketActivityRequest.setMarketCode(MarketActivityCode.BOURS);
        marketActivityRequest.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<MarketActivity> result = service.findMarketActivity(marketActivityRequest);
        return Response.ok(result).build();
    }

    @POST
    @Path("v1/market-activity")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findMarketActivity(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, MarketActivityRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<MarketActivity> result = service.findMarketActivity(request);
        return Response.ok(result).build();
    }

}
