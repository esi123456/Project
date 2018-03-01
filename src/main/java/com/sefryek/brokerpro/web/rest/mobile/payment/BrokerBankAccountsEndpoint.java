package com.sefryek.brokerpro.web.rest.mobile.payment;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.response.mobile.peyment.BrokerBankAccounts;
import com.sefryek.brokerpro.service.mobile.peyment.BrokerBankAccountsService;
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
 * @date: 21, May, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class BrokerBankAccountsEndpoint {

    private BrokerBankAccountsService service;

    @Autowired
    public BrokerBankAccountsEndpoint(BrokerBankAccountsService service) {
        this.service = service;
    }

    @GET
    @Path("v1/broker-bank-accounts")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findAllBrokerBankAccounts(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token) {
        EmptyRequest request = new EmptyRequest();
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<List<BrokerBankAccounts>> result = service.findAllBrokerBankAccounts(request);
        return Response.ok(result).build();
    }

}