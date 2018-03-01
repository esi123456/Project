package com.sefryek.brokerpro.tadbir.dto.response.mobile.payment;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, May, 2017
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MoneyTransferGatewayTadbir {
    @JsonProperty("Title")
    private String bankName ;
    @JsonProperty("ID")
    private Long bankGatewayId ;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Long getBankGatewayId() {
        return bankGatewayId;
    }

    public void setBankGatewayId(Long bankGatewayId) {
        this.bankGatewayId = bankGatewayId;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public String toString() {
        return "MoneyTransferGatewayTadbir{" +
                "bankName='" + bankName + '\'' +
                ", bankGatewayId=" + bankGatewayId +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
