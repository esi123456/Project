package com.sefryek.brokerpro.tadbir.dto.response.mobile.payment;

import com.fasterxml.jackson.annotation.*;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, May, 2017
 */
public class MoneyTransferGatewaysTadbir extends TadbirResponse {
    @JsonProperty("List")
    private List<MoneyTransferGatewayTadbir> moneyTransferGatewaysTadbir = new ArrayList<>();

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<MoneyTransferGatewayTadbir> getMoneyTransferGatewaysTadbir() {
        return moneyTransferGatewaysTadbir;
    }

    public void setMoneyTransferGatewaysTadbir(List<MoneyTransferGatewayTadbir> moneyTransferGatewaysTadbir) {
        this.moneyTransferGatewaysTadbir = moneyTransferGatewaysTadbir;
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
                "moneyTransferGatewaysTadbir=" + moneyTransferGatewaysTadbir +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
