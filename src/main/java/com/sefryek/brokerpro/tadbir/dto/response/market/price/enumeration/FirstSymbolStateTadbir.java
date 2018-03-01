package com.sefryek.brokerpro.tadbir.dto.response.market.price.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sefryek.util.StringUtils;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 22, Jul, 2017
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum FirstSymbolStateTadbir {
    NONE("None"),
    AUTHORIZED("1"),
    FORBIDDEN("5");

    private String value;

    FirstSymbolStateTadbir(String value) {
        this.value = value;
    }

    @JsonCreator
    public static FirstSymbolStateTadbir fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return NONE;
        }
        for (FirstSymbolStateTadbir firstSymbolState : FirstSymbolStateTadbir.values()) {
            if (firstSymbolState.getValue().equals(key)) {
                return firstSymbolState;
            }
        }
        return NONE;
    }

    public String getValue() {
        return value;
    }
}