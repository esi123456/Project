package com.sefryek.brokerpro.web.rest.portfolio.stock;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.brokerpro.dto.response.mobile.portfolio.stock.DailyCustomerStockPortfolio;
import com.sefryek.brokerpro.service.DailyCustomerStockPortfolioService;
import org.glassfish.jersey.server.ManagedAsync;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, Apr, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class DailyCustomerStockPortfolioEndpoint {

    private DailyCustomerStockPortfolioService service;

    public DailyCustomerStockPortfolioEndpoint(DailyCustomerStockPortfolioService service) {
        this.service = service;
    }

    @POST
    @Path("v1/daily-customer-stock-portfolio")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findDailyCustomerStockPortfolio(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid EmptyRequest request){
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<Page<DailyCustomerStockPortfolio>> result = service.findCustomerStockPortfolio(request);
        return Response.ok(result).build();
    }

}
