package com.sefryek.brokerpro.service.odata.enumeration;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 24, Jul, 2017
 */
public enum Direction {
    ASC("asc"),
    DESC("desc");

    String value;

    Direction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
