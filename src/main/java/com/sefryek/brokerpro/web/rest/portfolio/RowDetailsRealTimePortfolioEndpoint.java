package com.sefryek.brokerpro.web.rest.portfolio;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.portfolio.RowDetailsRealTimePortfolioRequest;
import com.sefryek.brokerpro.dto.response.mobile.portfolio.PortfolioRecords;
import com.sefryek.brokerpro.service.RowDetailsRealTimePortfolioService;
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
 * @date: 22, Apr, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class RowDetailsRealTimePortfolioEndpoint {

    private RowDetailsRealTimePortfolioService service;

    @Autowired
    public RowDetailsRealTimePortfolioEndpoint(RowDetailsRealTimePortfolioService service) {
        this.service = service;
    }

    @POST
    @Path("v1/row-details-real-time-portfolio")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findRowDetailsRealTimePortfolio(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid RowDetailsRealTimePortfolioRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<List<PortfolioRecords>> result = service.findRowDetailsRealTimePortfolio(request);
        return Response.ok(result).build();
    }

}
