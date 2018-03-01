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
public enum BrokerStateTadbir {
    NONE("none"),
    UNKNOWN("0"),
    IN_PROGRESS("1"),
    DISSUASION("2"),
    CANCELED("3"),
    DONE("4");

    private String value;

    BrokerStateTadbir(String value) {
        this.value = value;
    }

    @JsonCreator
    public static BrokerStateTadbir fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return NONE;
        }
        for (BrokerStateTadbir brokerStateTadbir : BrokerStateTadbir.values()) {
            if (brokerStateTadbir.getValue().equalsIgnoreCase(key)) {
                return brokerStateTadbir;
            }
        }
        return NONE;
    }

    public String getValue() {
        return value;
    }
}