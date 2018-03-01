package com.sefryek.brokerpro.tadbir.dto.response.mobile.alert.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sefryek.util.StringUtils;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 29, Apr, 2017
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ConditionalOrderActionTypeTadbir {
    CONDITION_MATCHING("در انتظار تطبیق"),
    SEND_TO_OMS_START("آماده ارسال"),
    ADDED_TO_DATABASE("ثبت شده در سیستم"),
    EDITED("ویرایش"),
    SEND_TO_OMS_FINISHED("ارسال شده"),
    EXPIRED("منقضی شده"),
    DELETED("حذف شده"),
    SEND_TO_OMS_FAILED("خطا در ارسال"),
    INITIAL_CONDITION_MATCHING("شروع تطبیق شرایط");

    private String value;

    ConditionalOrderActionTypeTadbir(String value) {
        this.value = value;
    }

    @JsonCreator
    public static ConditionalOrderActionTypeTadbir fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return CONDITION_MATCHING;
        }
        for (ConditionalOrderActionTypeTadbir conditionalOrderActionTypeTadbir : ConditionalOrderActionTypeTadbir.values()) {
            if (conditionalOrderActionTypeTadbir.name().equalsIgnoreCase(key)) {
                return conditionalOrderActionTypeTadbir;
            }
        }
        return CONDITION_MATCHING; // FIXME: 2/6/2017 change to another value or return exception
    }

    public String getValue() {
        return value;
    }
}
