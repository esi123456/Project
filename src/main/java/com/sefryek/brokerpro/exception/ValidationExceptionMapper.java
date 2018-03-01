package com.sefryek.brokerpro.exception;

import javax.annotation.Priority;
import javax.validation.ValidationException;
import javax.ws.rs.Priorities;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Priority(Priorities.USER)
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException> {

    @Override
    public Response toResponse(final ValidationException exception) {
        com.sefryek.brokerpro.dto.response.Response response = new com.sefryek.brokerpro.dto.response.Response();
        response.setSuccessful(Boolean.FALSE);
        response.setErrorCode(ErrorCode.VALIDATION_EXCEPTION.getCode());
        response.setErrorDescription(exception.getMessage());
        return Response.status(ErrorCode.VALIDATION_EXCEPTION.getHttpResponseCode()).entity(response).type(MediaType.APPLICATION_JSON_TYPE).build();
    }
}