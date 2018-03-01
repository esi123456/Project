package com.sefryek.brokerpro.exception;


public class CommissionNotFoundException extends BrokerProException {
    public CommissionNotFoundException() {
    }

    public CommissionNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return ErrorCode.COMMISSION_NOT_FOUND_EXCEPTION.getDescription();
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.COMMISSION_NOT_FOUND_EXCEPTION;
    }


}
