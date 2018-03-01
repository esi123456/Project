package com.sefryek.brokerpro.tadbir.dto.response.mobile.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirResponse;

import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 31, Jul, 2017
 */
public class DepositReasonTadbir extends TadbirResponse {

    @JsonProperty("List")
    private List<String> reasonList;

    public List<String> getReasonList() {
        return reasonList;
    }

    public void setReasonList(List<String> reasonList) {
        this.reasonList = reasonList;
    }

    @Override
    public String toString() {
        return "DepositReasonTadbir{" +
                "reasonList=" + reasonList +
                "} " + super.toString();
    }
}