package com.sefryek.brokerpro.tadbir.dto.response.mobile.broker.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sefryek.util.StringUtils;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 29, May, 2017
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CreatedFromTadbir {
    NONE("None"),
    UNKNOWN("0"),
    TAP("1"),
    TCP("2"),
    TMP("3"),
    RAM("4"),
    DBS("5"),
    REG("6"),
    BSS("7"),
    OTS("8"),
    FND("9"),
    ACP("10"),
    ABP("11"),
    AOP("12");
    private String value;

    CreatedFromTadbir(String value) {
        this.value = value;
    }

    @JsonCreator
    public static CreatedFromTadbir fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return NONE;
        }
        for (CreatedFromTadbir createdFromTadbir : CreatedFromTadbir.values()) {
            if (createdFromTadbir.getValue().equalsIgnoreCase(key)) {
                return createdFromTadbir;
            }
        }
        return NONE;
    }

    public String getValue() {
        return value;
    }
}
