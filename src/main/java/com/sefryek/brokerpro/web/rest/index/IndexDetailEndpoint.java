package com.sefryek.brokerpro.web.rest.index;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.response.market.Index.IndexDetail;
import com.sefryek.brokerpro.service.market.IndexDetailService;
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
 * @date: 28, May, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class IndexDetailEndpoint {

    private IndexDetailService service;

    @Autowired
    public IndexDetailEndpoint(IndexDetailService service) {
        this.service = service;
    }

    @GET
    @Path("v1/index-detail")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response getIndexDetail(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token) {
        EmptyRequest request = new EmptyRequest();
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<List<IndexDetail>> result = service.getIndexDetail(request);
        return Response.ok(result).build();
    }

}
