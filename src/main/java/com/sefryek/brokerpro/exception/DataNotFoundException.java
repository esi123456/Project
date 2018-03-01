package com.sefryek.brokerpro.exception;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 19, Feb, 2017
 */
public class DataNotFoundException extends BrokerProException {

    public DataNotFoundException() {
    }

    public DataNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return ErrorCode.DATA_NOT_FOUND_EXCEPTION.getDescription();
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.DATA_NOT_FOUND_EXCEPTION;
    }
}
