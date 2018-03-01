package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.AddMemberToWatchListCategoryRequest;
import com.sefryek.brokerpro.dto.response.mobile.watchlist.AddMemberToWatchListCategory;
import com.sefryek.brokerpro.service.AddMemberToWatchListCategoryService;
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
 * @date: 26, Feb, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class AddMemberToWatchListCategoryEndpoint {

    private AddMemberToWatchListCategoryService service;

    @Autowired
    public AddMemberToWatchListCategoryEndpoint(AddMemberToWatchListCategoryService service) {
        this.service = service;
    }

    @POST
    @Path("v1/add-member-to-watch-list-category")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response addMemberToWatchListCategory(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid AddMemberToWatchListCategoryRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<AddMemberToWatchListCategory> result = service.addMemberToWatchListCategory(request);
        return Response.ok(result).build();
    }

}
