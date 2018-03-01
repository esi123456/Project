package com.sefryek.brokerpro.web.rest.mobile.order;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.order.OrderDetailRequest;
import com.sefryek.brokerpro.dto.response.mobile.order.OrderDetail;
import com.sefryek.brokerpro.service.order.OrderDetailService;
import org.glassfish.jersey.server.ManagedAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 24, Sep, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class OrderDetailEndpoint {

    private OrderDetailService service;

    @Autowired
    public OrderDetailEndpoint(OrderDetailService service) {
        this.service = service;
    }

    @POST
    @Path("v1/order-detail")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findOrderDetail(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid OrderDetailRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<List<OrderDetail>> result = service.findOrderDetail(request);
        return Response.ok(result).build();
    }

}