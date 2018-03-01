package com.sefryek.brokerpro.tadbir.dto.response.mobile.order.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sefryek.util.StringUtils;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 22, Oct, 2017
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum OrderMarketTypeTadbir {

    UNKNOWN("unknown"),
    TEHRAN_STOCK("1");

    private String value;

    OrderMarketTypeTadbir(String value) {
        this.value = value;
    }

    @JsonCreator
    public static OrderMarketTypeTadbir fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return UNKNOWN;
        }
        for (OrderMarketTypeTadbir marketCode : OrderMarketTypeTadbir.values()) {
            if (marketCode.getValue().equals(key)) {
                return marketCode;
            }
        }
        return UNKNOWN;
    }

    public String getValue() {
        return value;
    }
}
