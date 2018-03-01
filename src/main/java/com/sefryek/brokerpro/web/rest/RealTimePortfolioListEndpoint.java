package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.portfolio.RealTimePortfolioListRequest;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.brokerpro.dto.response.mobile.portfolio.RealTimePortfolioList;
import com.sefryek.brokerpro.service.RealTimePortfolioListService;
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
 * @date: 19, Apr, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class RealTimePortfolioListEndpoint {

    private RealTimePortfolioListService service;

    @Autowired
    public RealTimePortfolioListEndpoint(RealTimePortfolioListService service) {
        this.service = service;
    }

    @POST
    @Path("v1/real-time-portfolio-list")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findRealTimePortfolio(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid RealTimePortfolioListRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<Page<RealTimePortfolioList>> result = service.findRealTimePortfolio(request);
        return Response.ok(result).build();
    }

}
