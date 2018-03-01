package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.domain.Broker;
import com.sefryek.brokerpro.dto.request.BrokerRequest;
import com.sefryek.brokerpro.dto.response.DefaultResponse;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.brokerpro.service.BrokerService;
import io.swagger.annotations.Api;
import org.glassfish.jersey.server.ManagedAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
@Api(value = "Broker Endpoint", produces = Constants.APPLICATION_JSON)
public class BrokerEndpoint {

    private BrokerService service;

    @Autowired
    public BrokerEndpoint(BrokerService service) {
        this.service = service;
    }

    @POST
    @Path("v1/brokers")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findAllBrokers(@Valid BrokerRequest request) {
        com.sefryek.brokerpro.dto.response.Response<Page<Broker>> result = service.findActiveBrokersByDeviceType(request);
        return Response.ok(result).build();
    }

    @GET
    @Path("sync/v1/brokers")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response syncBrokersWithMongo() {
        com.sefryek.brokerpro.dto.response.Response<DefaultResponse> result = service.syncBrokersWithMongo();
        return Response.ok(result).build();
    }

}
