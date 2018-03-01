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
public enum SecondSymbolStateTadbir {
    NONE("None"),
    OPEN("0"),
    FROZEN("1"),
    SUSPENDED("2"),
    RESERVED("3");

    private String value;

    SecondSymbolStateTadbir(String value) {
        this.value = value;
    }

    @JsonCreator
    public static SecondSymbolStateTadbir fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return NONE;
        }
        for (SecondSymbolStateTadbir secondSymbolState : SecondSymbolStateTadbir.values()) {
            if (secondSymbolState.getValue().equals(key)) {
                return secondSymbolState;
            }
        }
        return NONE;
    }

    public String getValue() {
        return value;
    }
}