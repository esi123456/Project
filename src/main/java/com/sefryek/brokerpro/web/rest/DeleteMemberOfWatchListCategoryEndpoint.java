package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.DeleteMemberOfWatchListCategoryRequest;
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
 * @date: 26, Feb, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class DeleteMemberOfWatchListCategoryEndpoint {

    private DefaultService service;

    @Autowired
    public DeleteMemberOfWatchListCategoryEndpoint(DefaultService service) {
        this.service = service;
    }

    @POST
    @Path("v1/delete-member-of-watch-list-category")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response deleteMemberOfWatchListCategory(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid DeleteMemberOfWatchListCategoryRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<DefaultResponse> result = service.deleteMemberOfWatchListCategory(request);
        return Response.ok(result).build();
    }

}
