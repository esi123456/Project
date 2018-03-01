package com.sefryek.brokerpro.tadbir.dto.response.mobile.alert.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sefryek.util.StringUtils;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 30, Apr, 2017
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ConditionCategoryTadbir {
    PRICE_CONDITIONS("PriceConditions"),
    SYMBOL_CONDITIONS("SymbolConditions"),
    QUEUE_CONDITIONS("QueueConditions");
    private String value;

    ConditionCategoryTadbir(String value) {
        this.value = value;
    }

    @JsonCreator
    public static ConditionCategoryTadbir fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return PRICE_CONDITIONS;
        }
        for (ConditionCategoryTadbir conditionCategoryTadbir : ConditionCategoryTadbir.values()) {
            if (conditionCategoryTadbir.name().equalsIgnoreCase(key)) {
                return conditionCategoryTadbir;
            }
        }
        return PRICE_CONDITIONS; // FIXME: 2/6/2017 change to another value or return exception
    }

    public String getValue() {
        return value;
    }
}
