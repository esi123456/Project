package com.sefryek.brokerpro.web.rest.mobile.exchanges;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.domain.ExchangeBroker;
import com.sefryek.brokerpro.dto.request.exchange.ExchangeBrokerRequest;
import com.sefryek.brokerpro.dto.response.DefaultResponse;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.brokerpro.service.mobile.exchange.ExchangeBrokerService;
import io.swagger.annotations.Api;
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
 * @date: 11, Nov, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
@Api(value = "Exchange Broker Endpoint", produces = Constants.APPLICATION_JSON)
public class ExchangeBrokerEndpoint {

    private ExchangeBrokerService service;

    @Autowired
    public ExchangeBrokerEndpoint(ExchangeBrokerService service) {
        this.service = service;
    }

    @POST
    @Path("v1/exchanges")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findAllExchanges(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid ExchangeBrokerRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<Page<ExchangeBroker>> result = service.findExchanges(request);
        return Response.ok(result).build();
    }

    @GET
    @Path("sync/v1/exchanges-broker")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response syncBrokersWithMongo() {
        com.sefryek.brokerpro.dto.response.Response<DefaultResponse> result = service.syncExchangesWithMongo();
        return Response.ok(result).build();
    }

}
