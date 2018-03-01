package com.sefryek.brokerpro.tadbir.dto.response.mobile.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 18, Dec, 2016
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RemainTadbir extends TadbirResponse{
    @JsonProperty("RealBalance")
    private Double realBalance;
    @JsonProperty("BlockedBalance")
    private Double blockedBalance;
    @JsonProperty("AccountBalance")
    private Double accountBalance;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Double getRealBalance() {
        return realBalance;
    }

    public void setRealBalance(Double realBalance) {
        this.realBalance = realBalance;
    }

    public Double getBlockedBalance() {
        return blockedBalance;
    }

    public void setBlockedBalance(Double blockedBalance) {
        this.blockedBalance = blockedBalance;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public String toString() {
        return "Remain{" +
                "realBalance=" + realBalance +
                ", blockedBalance=" + blockedBalance +
                ", accountBalance=" + accountBalance +
                ", additionalProperties=" + additionalProperties +
                "} " + super.toString();
    }
}
