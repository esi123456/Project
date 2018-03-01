package com.sefryek.brokerpro.web.rest.gateway;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.gateway.OnlineUsersRequest;
import com.sefryek.brokerpro.dto.response.gateway.OnlineUsers;
import com.sefryek.brokerpro.service.gateway.OnlineUsersService;
import org.glassfish.jersey.server.ManagedAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author Amin Malekpour
 * @email amin.malekpour@hotmail.com
 * @date 16 Dec 2017
 */
@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
public class OnlineUsersEndpoint {

    private OnlineUsersService service;

    @Autowired
    public OnlineUsersEndpoint(OnlineUsersService service) {
        this.service = service;
    }

    @POST
    @Path("v1/online-users")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    public Response findOnlineUsers(@Valid OnlineUsersRequest request) {
        com.sefryek.brokerpro.dto.response.Response<List<OnlineUsers>> result = service.executeOnlineUsers(request);
        return Response.ok(result).build();
    }

}
