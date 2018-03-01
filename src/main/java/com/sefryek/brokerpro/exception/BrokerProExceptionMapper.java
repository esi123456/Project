package com.sefryek.brokerpro.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class BrokerProExceptionMapper extends AbstractExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<BrokerProException> {

    @Override
    public Response toResponse(BrokerProException BrokerProException) {
        return this.errorResponse(BrokerProException.getErrorCode().getHttpResponseCode(), BrokerProException.getMessage(), BrokerProException.getErrorCode().getCode(), BrokerProException);
    }
}
