package com.sefryek.brokerpro.dto.request.mobile.broker.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sefryek.util.StringUtils;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 30, May, 2017
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ChangeBrokerType {
    NONE("0"),
    STOCK_PAPER("1"),
    LAST_TRADE_IN_BROKER("2");

    private String value;

    ChangeBrokerType(String value) {
        this.value = value;
    }

    @JsonCreator
    public static ChangeBrokerType fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return NONE;
        }
        for (ChangeBrokerType changeBrokerType : ChangeBrokerType.values()) {
            if (changeBrokerType.name().equalsIgnoreCase(key)) {
                return changeBrokerType;
            }
        }
        return NONE;
    }

    public String getValue() {
        return value;
    }
}

