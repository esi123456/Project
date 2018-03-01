package com.sefryek.brokerpro.dto.response.mobile.peyment.enumeration;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 13, May, 2017
 */
public enum TransferState {
    NONE,
    OK,
    FIRST_REQUEST_SENT,
    ERROR_IN_FIRST_REQUEST,
    SENT_TO_BANK_PAGE,
    ERROR_IN_REDIRECT_FROM_BANK_PAGE,
    SEND_VERIFY_REQUEST,
    ERROR_IN_VERIFY_REQUEST,
    INSERT_TO_AUTOMATION,
    ERROR_IN_INSERT_TO_AUTOMATION,
    SEND_SETTLE_REQUEST,
    ERROR_IN_SETTLE_REQUEST,
    CANCELED_FROM_CUSTOMER,
    ADD_VOUCHER_ACCOUNTING,
    ERROR_IN_ADD_VOUCHER_ACCOUNTING,
    TRANSACTION_REVERSED,
    SESSION_IS_EXPIRED,
    TRANSACTION_NOT_FOUND,
    RECEIVED_FROM_BANK,
    ERROR_IN_BANK_OPERATION,
    INSERT_TO_TBS,
    ERROR_IN_INSERT_TO_TBS;
}
