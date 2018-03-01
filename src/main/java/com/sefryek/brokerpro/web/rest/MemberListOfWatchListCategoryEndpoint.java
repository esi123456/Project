package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.MemberListOfWatchListCategoryRequest;
import com.sefryek.brokerpro.dto.response.market.price.first.PriceWithFirstQueue;
import com.sefryek.brokerpro.service.MemberListOfWatchListCategoryService;
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
 * @date: 26, Feb, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class MemberListOfWatchListCategoryEndpoint {

    private MemberListOfWatchListCategoryService service;

    @Autowired
    public MemberListOfWatchListCategoryEndpoint(MemberListOfWatchListCategoryService service) {
        this.service = service;
    }

    @POST
    @Path("v1/member-list-of-watch-list-category")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findMemberListOfWatchListCategory(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid MemberListOfWatchListCategoryRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<List<PriceWithFirstQueue>> result = service.findMemberListOfWatchListCategory(request);
        return Response.ok(result).build();
    }

}
