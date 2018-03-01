package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.brokerpro.dto.response.mobile.portfolio.Portfolio;
import com.sefryek.brokerpro.service.CustomerCdsPortfolioService;
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
 * @date: 02, Jan, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class CustomerCdsPortfolioEndpoint {

    private CustomerCdsPortfolioService service;

    @Autowired
    public CustomerCdsPortfolioEndpoint(CustomerCdsPortfolioService service) {
        this.service = service;
    }

    @POST
    @Path("v1/customer-cds-portfolio")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findCustomerCdsPortfolio(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid EmptyRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<Page<Portfolio>> result = service.findCustomerCdsPortfolio(request);
        return Response.ok(result).build();
    }

}