package com.sefryek.brokerpro.exception;

public class AuthorizationException extends BrokerProException {

    public AuthorizationException() {
    }

    public AuthorizationException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return ErrorCode.AUTHORIZATION_EXCEPTION.getDescription();
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.AUTHORIZATION_EXCEPTION;
    }
}
