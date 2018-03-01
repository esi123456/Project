package com.sefryek.brokerpro.exception;


public class UserNotFoundException extends BrokerProException {
    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return ErrorCode.USER_NOT_FOUND_EXCEPTION.getDescription();
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.USER_NOT_FOUND_EXCEPTION;
    }


}
