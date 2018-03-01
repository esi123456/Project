package com.sefryek.brokerpro.tadbir.dto.response.mobile.payment.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sefryek.util.StringUtils;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 16, May, 2017
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TransferStateTadbir {
    NONE("NONE"),
    OK("0"),
    FIRST_REQUEST_SENT("1"),
    ERROR_IN_FIRST_REQUEST("2"),
    SENT_TO_BANK_PAGE("3"),
    ERROR_IN_REDIRECT_FROM_BANK_PAGE("4"),
    SEND_VERIFY_REQUEST("5"),
    ERROR_IN_VERIFY_REQUEST("6"),
    INSERT_TO_AUTOMATION("7"),
    ERROR_IN_INSERT_TO_AUTOMATION("8"),
    SEND_SETTLE_REQUEST("9"),
    ERROR_IN_SETTLE_REQUEST("10"),
    CANCELED_FROM_CUSTOMER("11"),
    ADD_VOUCHER_ACCOUNTING("12"),
    ERROR_IN_ADD_VOUCHER_ACCOUNTING("13"),
    TRANSACTION_REVERSED("14"),
    SESSION_IS_EXPIRED("15"),
    TRANSACTION_NOT_FOUND("16"),
    RECEIVED_FROM_BANK("17"),
    ERROR_IN_BANK_OPERATION("18"),
    INSERT_TO_TBS("19"),
    ERROR_IN_INSERT_TO_TBS("20");

    private String value;

    TransferStateTadbir(String value) {
        this.value = value;
    }

    @JsonCreator
    public static TransferStateTadbir fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return NONE;
        }
        for (TransferStateTadbir transferStateTadbir : TransferStateTadbir.values()) {
            if (transferStateTadbir.value.equalsIgnoreCase(key)) {
                return transferStateTadbir;
            }
        }
        return NONE;
    }

    public String getValue() {
        return value;
    }
}
