package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.order.OrderListRequest;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.brokerpro.dto.response.mobile.order.Order;
import com.sefryek.brokerpro.service.order.OrderListService;
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
 * @date: 28, Jan, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class OrderListEndpoint {

    private OrderListService service;

    @Autowired
    public OrderListEndpoint(OrderListService service) {
        this.service = service;
    }

    @POST
    @Path("v1/order-list")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findOrderList(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid OrderListRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<Page<Order>> result = service.findOrderList(request);
        return Response.ok(result).build();
    }

}
