package com.sefryek.brokerpro.dto.response.mobile.peyment;

import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 31, Jul, 2017
 */
public class DepositReason {
    private List<String> reasonList;

    public List<String> getReasonList() {
        return reasonList;
    }

    public void setReasonList(List<String> reasonList) {
        this.reasonList = reasonList;
    }

    @Override
    public String toString() {
        return "DepositReason{" +
                "reasonList=" + reasonList +
                '}';
    }
}
