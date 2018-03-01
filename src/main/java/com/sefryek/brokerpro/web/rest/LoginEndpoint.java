package com.sefryek.brokerpro.web.rest;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.LoginAdditionalData;
import com.sefryek.brokerpro.dto.request.LoginRequest;
import com.sefryek.brokerpro.dto.response.DefaultResponse;
import com.sefryek.brokerpro.dto.response.Login;
import com.sefryek.brokerpro.exception.AuthorizationException;
import com.sefryek.brokerpro.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.glassfish.jersey.server.ManagedAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/services")
@Produces(Constants.APPLICATION_JSON)
@Api(value = "Login Endpoint", produces = Constants.APPLICATION_JSON)
public class LoginEndpoint {

    private static final Class clazz = getLoginResponseClass();
    private LoginService service;

    @Autowired
    public LoginEndpoint(LoginService service) {
        this.service = service;
    }

    private static Class<?> getLoginResponseClass() {
        return new com.sefryek.brokerpro.dto.response.Response<Login>().getClass();
    }

    @POST
    @Path("v1/login")
    @ManagedAsync
    @Consumes(Constants.APPLICATION_JSON)
    @ApiOperation(value = "Login v1", response = Login.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "login resource found"),
            @ApiResponse(code = 404, message = "login resource not found")
    })
    public Response login(@Valid LoginRequest login, @Context HttpServletRequest request) {
        login.setAdditionalData(new LoginAdditionalData(request.getRemoteAddr()));
        com.sefryek.brokerpro.dto.response.Response<Login> result = service.authenticate(login);
        return Response.ok(result).build();
    }


    @GET
    @Path("v1/logout")
    @ManagedAsync
    @Consumes(MediaType.APPLICATION_JSON)
    public Response logout(@HeaderParam(Constants.AUTHENTICATION_TOKEN_HEADER_KEY) String token) {
        com.sefryek.brokerpro.dto.response.Response<DefaultResponse> result = service.invalidate(token);
        return Response.ok(result).build();
    }

    @GET
    @Path("authentication-failed")
    @ManagedAsync
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticationFailedGetMethod() {
        throw new AuthorizationException("Authentication & Authorization failed");
    }


    @POST
    @Path("authentication-failed")
    @ManagedAsync
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticationFailedPostMethod() {
        throw new AuthorizationException("Authentication & Authorization failed");
    }

    @PUT
    @Path("authentication-failed")
    @ManagedAsync
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticationFailedPutMethod() {
        throw new AuthorizationException("Authentication & Authorization failed");
    }

    @DELETE
    @Path("authentication-failed")
    @ManagedAsync
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticationFailedDeleteMethod() {
        throw new AuthorizationException("Authentication & Authorization failed");
    }
}
