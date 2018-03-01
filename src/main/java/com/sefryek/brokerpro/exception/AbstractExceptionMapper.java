package com.sefryek.brokerpro.exception;

import com.sefryek.brokerpro.config.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public abstract class AbstractExceptionMapper {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    protected Response errorResponse(int status, String message, String code) {
        return customizeResponse(status, message, code);
    }

    private Response customizeResponse(int status, String message, String code) {
        com.sefryek.brokerpro.dto.response.Response response = new com.sefryek.brokerpro.dto.response.Response();
        response.setSuccessful(Boolean.FALSE);
        response.setErrorCode(code);
        response.setErrorDescription(message);
        return Response.status(status).entity(response).type(MediaType.APPLICATION_JSON_TYPE).build();
    }

    protected Response errorResponse(int status, String message, String code, Throwable t) {
        log.error(String.format("%s %s", Constants.ERROR_LOG, t.getMessage()), t); // logging stack trace.

        return customizeResponse(status, message, code);
    }
}