package com.sefryek.brokerpro.tadbir.dto.response.mobile.order;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sefryek.util.StringUtils;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 06, Feb, 2017
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum OrderValidity {
    NONE("None"),
    DAY("74"),
    GOOD_TILL_DATE("68"),
    GOOD_TILL_CANCEL("70"),
    FILL_KILL("69"),
    TRADING_SESSION("83");

    private String value;

    OrderValidity(String value) {
        this.value = value;
    }

    @JsonCreator
    public static OrderValidity fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return NONE;
        }
        for (OrderValidity orderValidity : OrderValidity.values()) {
            if (orderValidity.getValue().equals(key)) {
                return orderValidity;
            }
        }
        return NONE;
    }

    public String getValue() {
        return value;
    }
}
