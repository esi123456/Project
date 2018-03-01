package com.sefryek.brokerpro.tadbir.dto.response.mobile.alert.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sefryek.util.StringUtils;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 29, Apr, 2017
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AlertTypesTadbir {
    EMAIL("Email"),
    SMS("SMS"),
    WEB_NOTIFICATION("WebNotification"),
    MOBILE_NOTIFICATION("MobileNotification");

    private String value;

    AlertTypesTadbir(String value) {
        this.value = value;
    }

    @JsonCreator
    public static AlertTypesTadbir fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return EMAIL;
        }
        for (AlertTypesTadbir alertTypesTadbir : AlertTypesTadbir.values()) {
            if (alertTypesTadbir.name().equalsIgnoreCase(key)) {
                return alertTypesTadbir;
            }
        }
        return EMAIL; // FIXME: 2/6/2017 change to another value or return exception
    }

    public String getValue() {
        return value;
    }
}
