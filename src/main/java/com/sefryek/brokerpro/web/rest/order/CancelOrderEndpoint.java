package com.sefryek.brokerpro.web.rest.order;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.order.CancelOrderRequest;
import com.sefryek.brokerpro.dto.response.mobile.order.CancelOrder;
import com.sefryek.brokerpro.service.order.CancelOrderService;
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
public class CancelOrderEndpoint {

    private CancelOrderService service;

    @Autowired
    public CancelOrderEndpoint(CancelOrderService service) {
        this.service = service;
    }

    @POST
    @Path("v1/cancel-order")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response cancelOrder(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid CancelOrderRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<CancelOrder> result = service.cancelOrder(request);
        return Response.ok(result).build();
    }

}
