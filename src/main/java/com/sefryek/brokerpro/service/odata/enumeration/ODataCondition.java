package com.sefryek.brokerpro.service.odata.enumeration;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 25, Jul, 2017
 */
public enum ODataCondition {
    EQUAL("eq"),
    GREATER_THAN("gt"),
    LESS_THAN("ls");

    String value;

    ODataCondition(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
