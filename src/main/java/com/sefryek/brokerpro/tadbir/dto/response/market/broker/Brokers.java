package com.sefryek.brokerpro.tadbir.dto.response.market.broker;
/*
 * Copyright 2016 (C) syspod.co
 * 
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirResponse;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Brokers extends TadbirResponse {
    @JsonProperty("Broker")
    private List<Broker> mobileList = new ArrayList<>();

    public List<Broker> getBroker() {
        return mobileList;
    }

    public void setBroker(List<Broker> mobileList) {
        this.mobileList = mobileList;
    }

    @Override
    public String toString() {
        return "Brokers{" +
                "mobileList=" + mobileList +
                "} " + super.toString();
    }
}