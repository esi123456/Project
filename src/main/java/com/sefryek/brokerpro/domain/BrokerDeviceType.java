package com.sefryek.brokerpro.domain;
/*
 * Copyright 2016 (C) syspod.co
 * 
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */

import java.util.Locale;

public enum BrokerDeviceType {

    ANDROID("ANDROID"),
    IOS("IOS"),
    ALL("ALL");

    private final String code;

    BrokerDeviceType(String code) {
        this.code = code;
    }

    public static BrokerDeviceType fromString(String value) {
        try {
            return BrokerDeviceType.valueOf(value.toUpperCase(Locale.US));
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format(
                    "Invalid value '%s' for orders given! Has to be either 'ANDROID' or 'IOS' or 'ALL' (case insensitive).", value), e);
        }
    }

    public String getCode() {
        return code;
    }
}
