package com.sefryek.brokerpro.web.rest.order;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.order.ModifyOrderRequest;
import com.sefryek.brokerpro.dto.response.mobile.order.AddOrModifyOrder;
import com.sefryek.brokerpro.service.order.ModifyOrderService;
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
public class ModifyOrderEndpoint {

    private ModifyOrderService service;

    @Autowired
    public ModifyOrderEndpoint(ModifyOrderService service) {
        this.service = service;
    }

    @POST
    @Path("v1/modify-order")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response modifyOrder(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid ModifyOrderRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<AddOrModifyOrder> result = service.modifyOrder(request);
        return Response.ok(result).build();
    }

}
