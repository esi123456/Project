package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.EditWatchListCategoryRequest;
import com.sefryek.brokerpro.dto.response.DefaultResponse;
import com.sefryek.brokerpro.service.DefaultService;
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
 * @date: 25, Feb, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class EditWatchListCategoryEndpoint {

    private DefaultService service;

    @Autowired
    public EditWatchListCategoryEndpoint(DefaultService service) {
        this.service = service;
    }

    @POST
    @Path("v1/edit-watch-list-category")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response editWatchListCategory(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid EditWatchListCategoryRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<DefaultResponse> result = service.editWatchListCategory(request);
        return Response.ok(result).build();
    }

}
