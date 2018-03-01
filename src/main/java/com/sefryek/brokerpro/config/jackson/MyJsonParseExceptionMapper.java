package com.sefryek.brokerpro.config.jackson;

import com.fasterxml.jackson.core.JsonParseException;
import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.exception.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Implementation of {@link ExceptionMapper} to send down a "400 Bad Request"
 * in the event unparsable JSON is received.
 *
 * @since 2.2
 */
@Provider
public class MyJsonParseExceptionMapper implements ExceptionMapper<JsonParseException> {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public Response toResponse(JsonParseException exception) {
        com.sefryek.brokerpro.dto.response.Response response = new com.sefryek.brokerpro.dto.response.Response();
        response.setSuccessful(Boolean.FALSE);
        response.setErrorCode(ErrorCode.VALIDATION_EXCEPTION.getCode());
        response.setErrorDescription(exception.getMessage());
        Response result = Response.status(ErrorCode.VALIDATION_EXCEPTION.getHttpResponseCode()).entity(response).build();
        log.error(String.format("%s Exception in {} with cause = {}", Constants.ERROR_LOG), this.getClass().getName(), response);
        return result;
    }
}