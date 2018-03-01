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
public enum OrderFormTadbir {

    UNKNOWN("unknown"),
    NONE("0"),
    WEB("2"),
    COUNTER("5"),
    STAND("6"),
    PORTFOLIO("7"),
    GOZARESH_SAHAM("9"),
    MOBILE("12"),
    METATRADER("14"),
    CONDITIONAL_ORDER("15"),
    CALL_CENTER("16"),
    BASKET_ORDER("17"),
    SAMA("18"),
    ROBOT("19"),
    ONLINE_PLUS("20"),
    API("21"),
    BROKER_API("22"),
    CLIENT_API("23"),
    TEST_SYSTEM("24");

    private String value;

    OrderFormTadbir(String value) {
        this.value = value;
    }

    @JsonCreator
    public static OrderFormTadbir fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return UNKNOWN;
        }
        for (OrderFormTadbir orderForm : OrderFormTadbir.values()) {
            if (orderForm.getValue().equals(key)) {
                return orderForm;
            }
        }
        return UNKNOWN;
    }

    public String getValue() {
        return value;
    }
}
