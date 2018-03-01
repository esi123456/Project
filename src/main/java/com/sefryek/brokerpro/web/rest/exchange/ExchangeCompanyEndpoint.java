package com.sefryek.brokerpro.web.rest.exchange;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.response.DefaultResponse;
import com.sefryek.brokerpro.service.ExchangeCompanyService;
import io.swagger.annotations.Api;
import org.glassfish.jersey.server.ManagedAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @auther: Ashkan Haghighi Kia
 * @email: kia@syspod.co
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
@Api(value = "Exchange Endpoint", produces = Constants.APPLICATION_JSON)
public class ExchangeCompanyEndpoint {

    private ExchangeCompanyService service;

    @Autowired
    public ExchangeCompanyEndpoint(ExchangeCompanyService service) {
        this.service = service;
    }

    @GET
    @Path("sync/v1/exchanges-company")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response syncBrokersWithMongo() {
        com.sefryek.brokerpro.dto.response.Response<DefaultResponse> result = service.syncExchangesWithMongo();
        return Response.ok(result).build();
    }

}