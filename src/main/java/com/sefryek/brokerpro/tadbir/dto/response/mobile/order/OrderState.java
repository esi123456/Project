package com.sefryek.brokerpro.tadbir.dto.response.mobile.order;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sefryek.util.StringUtils;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 06, Feb, 2017
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum OrderState {
    NONE("0"),
    MODIFY("1"),
    ERROR("2"),
    CANCEL("3"),
    DELETE("4"),
    DONE("5"),
    ON_BOARD("6"),
    ON_SENDING("7"),
    PARTIALLY_EXECUTION("8"),
    ON_CANCELING("9"),
    ON_CANCEL_ERROR("10"),
    ON_MODIFY_ERROR("11"),
    DELETE_BY_BROKER("12"),
    EXPIRED("13"),
    PARTIALLY_EXECUTION_AND_EXPIRED("14"),
    CANCEL_BY_BROKER_FOR_UNBLOCK("15"),
    ON_MODIFY("16"),
    DELETE_BY_NSC("17"),
    CANCEL_BY_BROKER_FOR_ORDER_ON_AIR("18"),
    ON_MODIFY_BOARD("19"),
    ORDER_EXECUTED("20"),
    PENDING_CONFIRM("21"),
    CONFIRMED("22"),
    PENDING_CANCEL_ORDER("23"),
    CANCEL_ORDER_CONFIRMED("24"),
    REJECT("25"),
    CANCEL_PENDING_ORDER_BY_USER("26"),
    CANCEL_CANCEL_PENDING_ORDER_BY_USER("27"),
    IN_OMS_QUEUE("28");

    private String value;

    OrderState(String value) {
        this.value = value;
    }

    @JsonCreator
    public static OrderState fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return NONE;
        }
        for (OrderState orderState : OrderState.values()) {
            if (orderState.getValue().equals(key)) {
                return orderState;
            }
        }
        // FIXME: 02/06/2017 it's better to return exception or another type
        return NONE;
    }

    public String getValue() {
        return value;
    }
}
