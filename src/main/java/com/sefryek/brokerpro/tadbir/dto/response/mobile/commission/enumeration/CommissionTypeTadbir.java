package com.sefryek.brokerpro.tadbir.dto.response.mobile.commission.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sefryek.util.StringUtils;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, Jul, 2017
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CommissionTypeTadbir {
    NONE("None"),
    NORMAL("0"),
    BAZARGARDAN("1");

    private String value;

    CommissionTypeTadbir(String value) {
        this.value = value;
    }

    @JsonCreator
    public static CommissionTypeTadbir fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return NONE;
        }
        for (CommissionTypeTadbir commissionTypeTadbir : CommissionTypeTadbir.values()) {
            //for response from Tadbir
            if (commissionTypeTadbir.value.equalsIgnoreCase(key)) {
                return commissionTypeTadbir;
            }
        }
        return NONE;
    }

    public String getValue() {
        return value;
    }

}
