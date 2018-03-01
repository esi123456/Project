package com.sefryek.brokerpro.web.rest.order;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.order.AddOrdersRequest;
import com.sefryek.brokerpro.service.order.AddOrdersService;
import org.glassfish.jersey.server.ManagedAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.*;
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
public class AddOrdersEndpoint {

    private AddOrdersService service;

    @Autowired
    public AddOrdersEndpoint(AddOrdersService service) {
        this.service = service;
    }

    @POST
    @Path("v1/add-orders")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response addOrders(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid AddOrdersRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response result = service.addOrders(request);
        return Response.ok(result).build();
    }

}
