package com.sefryek.brokerpro.dto.response.mobile.alert.enumeration;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 24, Apr, 2017
 */
public enum ConditionalOrderActionType {
    NONE,
    ALL,
    CONDITION_MATCHING,
    SEND_TO_OMS_START,
    ADDED_TO_DATABASE,
    EDITED,
    SEND_TO_OMS_FINISHED,
    EXPIRED,
    DELETED,
    SEND_TO_OMS_FAILED,
    INITIAL_CONDITION_MATCHING;
}