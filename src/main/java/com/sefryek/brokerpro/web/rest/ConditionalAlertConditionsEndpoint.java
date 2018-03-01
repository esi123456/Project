package com.sefryek.brokerpro.web.rest;

        import com.sefryek.brokerpro.config.Constants;
        import com.sefryek.brokerpro.dto.request.alert.ConditionalAlertConditionsRequest;
        import com.sefryek.brokerpro.dto.response.mobile.alert.ConditionalAlertConditions;
        import com.sefryek.brokerpro.service.ConditionalAlertConditionsService;
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
 * @date: 06, May, 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class ConditionalAlertConditionsEndpoint {

    private ConditionalAlertConditionsService service;

    @Autowired
    public ConditionalAlertConditionsEndpoint(ConditionalAlertConditionsService service) {
        this.service = service;
    }

    @POST
    @Path("v1/conditional-alert-conditions")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findAlertConditions(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token, @Valid ConditionalAlertConditionsRequest request) {
        request.setToken(token);
        com.sefryek.brokerpro.dto.response.Response<List<ConditionalAlertConditions>> result = service.findAlertConditions(request);
        return Response.ok(result).build();
    }

}
