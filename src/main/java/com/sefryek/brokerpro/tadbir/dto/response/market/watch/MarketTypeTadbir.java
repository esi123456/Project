package com.sefryek.brokerpro.tadbir.dto.response.market.watch;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sefryek.util.StringUtils;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 10, Jun, 2017
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MarketTypeTadbir {
    NONE("None"),
    EXCHANGE("Exchange"),
    FARABORSE("Faraborse");

    private String value;

    MarketTypeTadbir(String value) {
        this.value = value;
    }

    @JsonCreator
    public static MarketTypeTadbir fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return NONE;
        }
        for (MarketTypeTadbir marketTypeTadbir : MarketTypeTadbir.values()) {
            if (marketTypeTadbir.name().equalsIgnoreCase(key)) {
                return marketTypeTadbir;
            }
        }
        return NONE;
    }

    public String getValue() {
        return value;
    }
}
