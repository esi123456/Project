package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.response.mobile.portfolio.PortfolioWithDetail;
import com.sefryek.brokerpro.service.CustomerCdsPortfolioWithDetailService;
import org.glassfish.jersey.server.ManagedAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 07, Jan, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class CustomerCdsPortfolioWithDetailEndpoint {

    private CustomerCdsPortfolioWithDetailService service;

    @Autowired
    public CustomerCdsPortfolioWithDetailEndpoint(CustomerCdsPortfolioWithDetailService service) {
        this.service = service;
    }

    @GET
    @Path("v1/customer-cds-portfolio-with-detail")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findCustomerCdsPortfolioWithDetail(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token) {
        EmptyRequest request = new EmptyRequest();
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<List<PortfolioWithDetail>> result = service.findCustomerCdsPortfolioWithDetail(request);
        return Response.ok(result).build();
    }

}
