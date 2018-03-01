package com.sefryek.brokerpro.tadbir.dto.response.mobile.payment.enumeration;

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
public enum DepositStateTadbir {
    NONE("None"),
    REVIEW_MODE("tbs_cashflowstate_ReviewMode"),
    CANCEL_BY_CUSTOMER("tbs_cashflowstate_CancelByCustomer"),
    DELETED("tbs_cashflowstate_Deleted"),
    ACTION_MODE("tbs_cashflowstate_ActionMode"),
    TROUBLE_SHOOTING("tbs_cashflowstate_Troubleshooting"),
    DONE("tbs_cashflowstate_Done");

    private String value;

    DepositStateTadbir(String value) {
        this.value = value;
    }

    @JsonCreator
    public static DepositStateTadbir fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return NONE;
        }
        for (DepositStateTadbir depositStateTadbir : DepositStateTadbir.values()) {
            if (depositStateTadbir.value.equalsIgnoreCase(key)) {
                return depositStateTadbir;
            }
        }
        return NONE;
    }

    public String getValue() {
        return value;
    }
}
