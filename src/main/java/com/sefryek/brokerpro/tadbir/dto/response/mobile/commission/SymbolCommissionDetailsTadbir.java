package com.sefryek.brokerpro.tadbir.dto.response.mobile.commission;

/**
 * Copyright 2016 (C) syspod.co
 *
 * @auther: Ashkan Haghighi Kia
 * @email: kia@syspod.co
 */


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirResponse;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SymbolCommissionDetailsTadbir extends TadbirResponse {

    @JsonProperty("Commision")
    private Map<String, CommissionDetailTadbir> commissionDetails = new HashMap<String, CommissionDetailTadbir>();

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Map<String, CommissionDetailTadbir> getCommissionDetails() {
        return commissionDetails;
    }

    public void setCommissionDetails(Map<String, CommissionDetailTadbir> commissionDetails) {
        this.commissionDetails = commissionDetails;
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
        return "SymbolCommissionDetailsTadbir{" +
                "commissionDetails=" + commissionDetails +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}