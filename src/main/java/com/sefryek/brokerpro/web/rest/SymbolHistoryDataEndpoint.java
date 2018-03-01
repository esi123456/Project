package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.HistoryDataRequest;
import com.sefryek.brokerpro.dto.request.market.HistoryType;
import com.sefryek.brokerpro.dto.response.market.history.HistoryData;
import com.sefryek.brokerpro.service.HistoryDataService;
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
 * @date: 26, Dec, 2016
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class SymbolHistoryDataEndpoint {

    private HistoryDataService service;

    @Autowired
    public SymbolHistoryDataEndpoint(HistoryDataService service) {
        this.service = service;
    }

    @POST
    @Path("v1/symbol-history-data")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findSymbolHistoryData(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid HistoryDataRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<List<HistoryData>> result = service.findHistoryData(request, HistoryType.SYMBOL);
        return Response.ok(result).build();
    }

}
