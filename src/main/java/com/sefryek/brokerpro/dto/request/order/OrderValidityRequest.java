package com.sefryek.brokerpro.dto.request.order;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sefryek.util.StringUtils;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum OrderValidityRequest {
    DAY("74"), GOOD_TILL_DATE("68"), GOOD_TILL_CANCEL("70"), FILL_KILL("69"), TRADING_SESSION("83");

    private String value;

    OrderValidityRequest(String value) {
        this.value = value;
    }

    @JsonCreator
    public static OrderValidityRequest fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return DAY;
        }
        for (OrderValidityRequest orderValidityRequest : OrderValidityRequest.values()) {
            if (orderValidityRequest.name().equalsIgnoreCase(key)) {
                return orderValidityRequest;
            }
        }
        // FIXME: 2/6/2017 change to another value or return exception
        return DAY;
    }

    public String getValue() {
        return value;
    }
}
