package com.sefryek.brokerpro.exception;


public class PageableNotFoundException extends BrokerProException {
    public PageableNotFoundException() {
    }

    public PageableNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return ErrorCode.PAGEABLE_NOT_FOUND_EXCEPTION.getDescription();
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.PAGEABLE_NOT_FOUND_EXCEPTION;
    }

}
