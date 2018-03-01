package com.sefryek.brokerpro.tadbir.dto.response.mobile.alert.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sefryek.util.StringUtils;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 03, May, 2017
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum EqualityTypeTadbir {
    NONE("None"),
    EQUALITY("1"),
    NOT_EQUAL("2"),
    GREATER("3"),
    GREATER_OR_EQUAL("4"),
    LESS("5"),
    LESS_OR_EQUAL("6");

    private String value;

    EqualityTypeTadbir(String value) {
        this.value = value;
    }

    @JsonCreator
    public static EqualityTypeTadbir fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return NONE;
        }
        for (EqualityTypeTadbir equalityTypeTadbir : EqualityTypeTadbir.values()) {
            if (equalityTypeTadbir.name().equalsIgnoreCase(key)) {
                return equalityTypeTadbir;
            }
        }
        return NONE;
    }

    public String getValue() {
        return value;
    }
}
