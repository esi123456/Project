package com.sefryek.brokerpro.tadbir.dto.response.mobile.payment.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sefryek.util.StringUtils;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, May, 2017
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PaymentStateTadbir {
    NONE("0"),
    ALL("1"),
    CANCELED("2"),
    RECEIVED("3"),
    PAID("4"),
    BEING_PROCESSED("5"),
    NOT_SET("6"),
    REQUEST_CANCEL("7"),
    BEING_PROCESSED_BY_OTHER("8"),
    TROUBLE_SHOOTING("9");

    private String value;

    PaymentStateTadbir(String value) {
        this.value = value;
    }

    @JsonCreator
    public static PaymentStateTadbir fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return NONE;
        }
        for (PaymentStateTadbir paymentStateTadbir : PaymentStateTadbir.values()) {
            if (paymentStateTadbir.value.equalsIgnoreCase(key)) {
                return paymentStateTadbir;
            }
        }
        return NONE;
    }

    public String getValue() {
        return value;
    }
}
