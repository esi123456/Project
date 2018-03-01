package com.sefryek.brokerpro.dto.request.alert.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sefryek.util.StringUtils;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 24, Apr, 2017
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ConditionalOrderActionTypeRequest {
    NONE("None"),
    ALL("-1"),
    CONDITION_MATCHING("1"),
    SEND_TO_OMS_START("2"),
    ADDED_TO_DATABASE("3"),
    EDITED("4"),
    SEND_TO_OMS_FINISHED("5"),
    EXPIRED("7"),
    DELETED("8"),
    SEND_TO_OMS_FAILED("9"),
    INITIAL_CONDITION_MATCHING("10");
    private String value;

    ConditionalOrderActionTypeRequest(String value) {
        this.value = value;
    }

    @JsonCreator
    public static ConditionalOrderActionTypeRequest fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return NONE;
        }
        for (ConditionalOrderActionTypeRequest conditionalOrderActionTypeRequest : ConditionalOrderActionTypeRequest.values()) {
            if (conditionalOrderActionTypeRequest.name().equalsIgnoreCase(key)) {
                return conditionalOrderActionTypeRequest;
            }
        }
        return NONE;
    }

    public String getValue() {
        return value;
    }
}
