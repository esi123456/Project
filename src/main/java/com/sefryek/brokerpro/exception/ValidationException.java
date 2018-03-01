package com.sefryek.brokerpro.exception;


public class ValidationException extends BrokerProException {
    public ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return ErrorCode.VALIDATION_EXCEPTION.getDescription();
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.VALIDATION_EXCEPTION;
    }

}
