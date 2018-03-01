package com.sefryek.brokerpro.exception;

import com.sefryek.brokerpro.config.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionMapper extends AbstractExceptionMapper implements
        javax.ws.rs.ext.ExceptionMapper<Throwable> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public Response toResponse(Throwable e) {
        if (log.isErrorEnabled()) {
            log.error(String.format("%s %s", Constants.ERROR_LOG, e.getMessage()), e);
        }
        return createResponse(e.getMessage());
    }

    private Response createResponse(String message) {
        com.sefryek.brokerpro.dto.response.Response response = new com.sefryek.brokerpro.dto.response.Response();
        response.setSuccessful(Boolean.FALSE);
        response.setErrorCode(ErrorCode.UNKNOWN_EXCEPTION.getCode());
        response.setErrorDescription(ErrorCode.UNKNOWN_EXCEPTION.getDescription());
        return Response.status(ErrorCode.UNKNOWN_EXCEPTION.getHttpResponseCode()).entity(response).type(MediaType.APPLICATION_JSON_TYPE).build();
    }
}