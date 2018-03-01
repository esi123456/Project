package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.response.mobile.CustomerDevice;
import com.sefryek.brokerpro.service.CustomerDeviceService;
import org.glassfish.jersey.server.ManagedAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Ismael Sadeghi
 * @email: ismaelsadeghi111@gmail.com
 * @date: 13, Jan, 2018
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class CustomerDeviceEndpoint {

    private CustomerDeviceService service;

    @Autowired
    public CustomerDeviceEndpoint(CustomerDeviceService service) {
        this.service = service;
    }

    @GET
    @Path("v1/customer_device")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response getCustomerDevice(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token) {
        EmptyRequest request = new EmptyRequest();
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<CustomerDevice> result = service.findCustomerDevice(request);
        return Response.ok(result).build();
    }
}
