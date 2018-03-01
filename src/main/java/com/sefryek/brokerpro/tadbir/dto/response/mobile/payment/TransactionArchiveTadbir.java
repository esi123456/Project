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
 * @date: 30, May, 2017
 */
public class TransactionArchiveTadbir extends TadbirPageableResponse {
    @JsonProperty("List")
    private List<TransactionTadbir> transactionList;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<TransactionTadbir> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<TransactionTadbir> transactionList) {
        this.transactionList = transactionList;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public String toString() {
        return "TransactionArchiveTadbir{" +
                "transactionList=" + transactionList +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
