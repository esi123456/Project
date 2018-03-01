package com.sefryek.brokerpro.exception;

public class InternalServerException extends BrokerProException {
    public InternalServerException() {
    }

    public InternalServerException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return ErrorCode.INTERNAL_SERVER_EXCEPTION.getDescription();
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.INTERNAL_SERVER_EXCEPTION;
    }
}
