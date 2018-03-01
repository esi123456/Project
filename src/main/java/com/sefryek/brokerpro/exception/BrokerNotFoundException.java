package com.sefryek.brokerpro.exception;


public class BrokerNotFoundException extends BrokerProException {
    public BrokerNotFoundException() {
    }

    public BrokerNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return ErrorCode.BROKER_NOT_FOUND_EXCEPTION.getDescription();
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.BROKER_NOT_FOUND_EXCEPTION;
    }

}
