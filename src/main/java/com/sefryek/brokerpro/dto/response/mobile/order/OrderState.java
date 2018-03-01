package com.sefryek.brokerpro.dto.response.mobile.order;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 06, Feb, 2017
 */
public enum OrderState {
    NONE,
    MODIFY,
    ERROR,
    CANCEL,
    DELETE,
    DONE,
    ON_BOARD,
    ON_SENDING,
    PARTIALLY_EXECUTION,
    ON_CANCELING,
    ON_CANCEL_ERROR,
    ON_MODIFY_ERROR,
    DELETE_BY_BROKER,
    EXPIRED,
    PARTIALLY_EXECUTION_AND_EXPIRED,
    CANCEL_BY_BROKER_FOR_UNBLOCK,
    ON_MODIFY,
    DELETE_BY_NSC,
    CANCEL_BY_BROKER_FOR_ORDER_ON_AIR,
    ON_MODIFY_BOARD,
    ORDER_EXECUTED,
    PENDING_CONFIRM,
    CONFIRMED,
    PENDING_CANCEL_ORDER,
    CANCEL_ORDER_CONFIRMED,
    REJECT,
    CANCEL_PENDING_ORDER_BY_USER,
    CANCEL_CANCEL_PENDING_ORDER_BY_USER,
    IN_OMS_QUEUE;
}
