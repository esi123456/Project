package com.sefryek.brokerpro.tadbir.dto.response.mobile.payment;

import com.fasterxml.jackson.annotation.*;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, May, 2017
 */

public class MoneyTransferTokenTadbir extends TadbirResponse {

    @JsonProperty("MoneyTransfer")
    private MoneyTransferTadbir moneyTransferTadbir;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public MoneyTransferTadbir getMoneyTransferTadbir() {
        return moneyTransferTadbir;
    }

    public void setMoneyTransferTadbir(MoneyTransferTadbir moneyTransferTadbir) {
        this.moneyTransferTadbir = moneyTransferTadbir;
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
        return "MoneyTransferGatewaysTadbir{" +
                "moneyTransferTadbir=" + moneyTransferTadbir +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
