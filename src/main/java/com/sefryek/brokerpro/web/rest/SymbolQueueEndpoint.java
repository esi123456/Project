package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.QueueRequest;
import com.sefryek.brokerpro.dto.response.market.queue.Queue;
import com.sefryek.brokerpro.service.SymbolQueueService;
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
 * @date: 14, Dec, 2016
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class SymbolQueueEndpoint {

    private SymbolQueueService service;

    @Autowired
    public SymbolQueueEndpoint(SymbolQueueService service) {
        this.service = service;
    }

    @POST
    @Path("v1/queues")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findQueue(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid QueueRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<List<Queue>> result = service.findQueue(request);
        return Response.ok(result).build();
    }

}
