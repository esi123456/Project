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
public enum OrderSide {
    NONE("None"), BUY("0"), SELL("1");

    private String value;

    OrderSide(String value) {
        this.value = value;
    }

    @JsonCreator
    public static OrderSide fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return NONE;
        }
        for (OrderSide orderSide : OrderSide.values()) {
            if (orderSide.getValue().equals(key)) {
                return orderSide;
            }
        }
        return NONE;
    }

    public String getValue() {
        return value;
    }
}
