package com.sefryek.brokerpro.tadbir.dto.response.market.broker;
/*
 * Copyright 2016 (C) syspod.co
 * 
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sefryek.util.StringUtils;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BrokerDeviceType {

    ANDROID("1"),
    IOS("2"),
    ALL("3");

    private final String code;

    BrokerDeviceType(String code) {
        this.code = code;
    }

    @JsonCreator
    public static BrokerDeviceType fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return ALL;
        }
        for (BrokerDeviceType brokerDeviceType : BrokerDeviceType.values()) {
            if (brokerDeviceType.getCode().equals(key)) {
                return brokerDeviceType;
            }
        }
        return ALL;
    }

    public String getCode() {
        return code;
    }
}
