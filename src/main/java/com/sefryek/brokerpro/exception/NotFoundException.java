package com.sefryek.brokerpro.exception;


public class NotFoundException extends BrokerProException {

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return ErrorCode.NOT_FOUND_EXCEPTION.getDescription();
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.NOT_FOUND_EXCEPTION;
    }
}
