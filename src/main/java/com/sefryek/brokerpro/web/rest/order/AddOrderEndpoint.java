package com.sefryek.brokerpro.web.rest.order;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.order.AddOrderRequest;
import com.sefryek.brokerpro.dto.response.mobile.order.AddOrModifyOrder;
import com.sefryek.brokerpro.service.order.AddOrderService;
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
public class AddOrderEndpoint {

    private AddOrderService service;

    @Autowired
    public AddOrderEndpoint(AddOrderService service) {
        this.service = service;
    }

    @POST
    @Path("v1/add-order")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response addOrder(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid AddOrderRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<AddOrModifyOrder> result = service.addOrder(request);
        return Response.ok(result).build();
    }

}
