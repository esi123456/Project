package com.sefryek.brokerpro.dto.request.market.activity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.sefryek.util.StringUtils;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 21, Oct, 2017
 */
public enum MarketActivityCode {
    NONE("none"),
    BOURS("1"),
    FARABOURSE("2");

    private String value;

    MarketActivityCode(String value) {
        this.value = value;
    }

    @JsonCreator
    public static MarketActivityCode fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return BOURS;
        }

        //because of request sefryek
        for (MarketActivityCode marketActivityCode : MarketActivityCode.values()) {
            if (marketActivityCode.name().equals(key)) {
                return marketActivityCode;
            }
        }

        //because of response Tadbir
        for (MarketActivityCode marketActivityCode : MarketActivityCode.values()) {
            if (marketActivityCode.getValue().equals(key)) {
                return marketActivityCode;
            }
        }
        return BOURS;
    }

    public String getValue() {
        return value;
    }
}
