package com.sefryek.brokerpro.tadbir.dto.response.mobile.payment;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirPageableResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 20, May, 2017
 */
public class MoneyReceiptListTadbir extends TadbirPageableResponse {
    @JsonProperty("List")
    private List<MoneyReceiptTadbir> moneyReceiptList;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<MoneyReceiptTadbir> getMoneyReceiptList() {
        return moneyReceiptList;
    }

    public void setMoneyReceiptList(List<MoneyReceiptTadbir> moneyReceiptList) {
        this.moneyReceiptList = moneyReceiptList;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "MoneyReceiptListTadbir{" +
                "moneyReceiptList=" + moneyReceiptList +
                ", additionalProperties=" + additionalProperties +
                "} " + super.toString();
    }
}
