package com.sefryek.brokerpro.tadbir.dto.response.mobile.payment;

import com.fasterxml.jackson.annotation.*;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 21, May, 2017
 */
public class BrokerBankAccountsTadbir extends TadbirResponse {

    @JsonProperty("BankAccounts")
    private List<BrokerBankAccountTadbir> brokerBankAccounts;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<BrokerBankAccountTadbir> getBrokerBankAccounts() {
        return brokerBankAccounts;
    }

    public void setBrokerBankAccounts(List<BrokerBankAccountTadbir> brokerBankAccounts) {
        this.brokerBankAccounts = brokerBankAccounts;
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
        return "BrokerBankAccountsTadbir{" +
                "brokerBankAccounts=" + brokerBankAccounts +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
