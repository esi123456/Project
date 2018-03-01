package com.sefryek.brokerpro.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public abstract class BrokerProException extends WebApplicationException {

    public BrokerProException() {
    }

    public BrokerProException(String message) {
        super(message);
    }

    public Response createResponse(Response.Status status) {
        return createResponse(getMessage(), status);
    }

    private Response createResponse(String message, Response.Status status) {
        com.sefryek.brokerpro.dto.response.Response response = new com.sefryek.brokerpro.dto.response.Response();
        response.setSuccessful(Boolean.FALSE);
        response.setErrorCode(getErrorCode().getCode());
        response.setErrorDescription(message);
        //@todo this part must be changed dynamically
        return Response.status(status).entity(response).type(MediaType.APPLICATION_JSON_TYPE).build();
    }

    public abstract String getMessage();

    public abstract ErrorCode getErrorCode();

    public Response createResponse() {
        com.sefryek.brokerpro.dto.response.Response response = new com.sefryek.brokerpro.dto.response.Response();
        response.setSuccessful(Boolean.FALSE);
        response.setErrorCode(getErrorCode().getCode());
        response.setErrorDescription(getErrorCode().getDescription());
        return Response.status(getErrorCode().getHttpResponseCode()).entity(response).type(MediaType.APPLICATION_JSON_TYPE).build();
    }


}
