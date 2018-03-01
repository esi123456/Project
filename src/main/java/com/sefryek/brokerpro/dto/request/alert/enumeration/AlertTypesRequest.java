package com.sefryek.brokerpro.dto.request.alert.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.sefryek.util.StringUtils;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 30, Apr, 2017
 */
public enum AlertTypesRequest {
    NONE("None"),
    SEND_ORDER("SendOrder"),
    SMS("SMS"),
    POP_UP("PopUp"),
    SMS_POP_UP("SMS_PopUp");

    private String value;

    AlertTypesRequest(String value) {
        this.value = value;
    }

    @JsonCreator
    public static AlertTypesRequest fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return NONE;
        }
        for (AlertTypesRequest alertTypesRequest : AlertTypesRequest.values()) {
            if (alertTypesRequest.name().equalsIgnoreCase(key)) {
                return alertTypesRequest;
            }
        }
        return NONE; // FIXME: 2/6/2017 change to another value or return exception
    }

    public String getValue() {
        return value;
    }
}
