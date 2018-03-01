package com.sefryek.brokerpro.exception;

public enum ErrorCode {

    AUTHORIZATION_EXCEPTION(1000, 401, "AUTHORIZATION_EXCEPTION", "authentication & authorization for operations are not permitted"),
    INTERNAL_SERVER_EXCEPTION(1001, 500, "INTERNAL_SERVER_EXCEPTION", "internal server exception"),
    USER_NOT_FOUND_EXCEPTION(1002, 200, "USER_NOT_FOUND_EXCEPTION", "user not found exception"),
    UNKNOWN_EXCEPTION(1003, 500, "UNKNOWN_EXCEPTION", "unknown error occurred"),
    VALIDATION_EXCEPTION(1004, 400, "VALIDATION_EXCEPTION", "validation exception occurred"),
    MAPPING_VALIDATION_EXCEPTION(1005, 400, "MAPPING_VALIDATION_EXCEPTION", "mapping validation exception occurred"),
    CONSTRAINT_VIOLATION_EXCEPTION(1006, 400, "CONSTRAINT_VIOLATION_EXCEPTION", "constraint violation exception occurred"),
    NOT_FOUND_EXCEPTION(1007, 404, "NOT_FOUND_EXCEPTION", "not found exception occurred"),
    BROKER_NOT_FOUND_EXCEPTION(1008, 200, "BROKER_NOT_FOUND_EXCEPTION", "broker not found exception occurred"),
    PAGEABLE_NOT_FOUND_EXCEPTION(1009, 200, "PAGEABLE_NOT_FOUND_EXCEPTION", "pageable not found exception occurred"),
    COMMISSION_NOT_FOUND_EXCEPTION(1010, 200, "COMMISSION_NOT_FOUND_EXCEPTION", "commission not found exception occurred"),
    DATA_NOT_FOUND_EXCEPTION(1011, 200, "DATA_NOT_FOUND_EXCEPTION", "data not found exception"),
    BAD_REQUEST_EXCEPTION(1012, 400, "REQUEST_IS_NOT_VALID", "request is not valid"),
    FINANCIAL_NOT_FOUND_EXCEPTION(1013, 200, "FINANCIAL_NOT_FOUND_EXCEPTION", "financial not found exception occurred");
    private Integer number;
    private Integer httpResponseCode;
    private String code;
    private String description;

    ErrorCode(Integer number, Integer httpResponseCode, String code, String description) {
        this.number = number;
        this.httpResponseCode = httpResponseCode;
        this.code = code;
        this.description = description;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getHttpResponseCode() {
        return httpResponseCode;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }


}
