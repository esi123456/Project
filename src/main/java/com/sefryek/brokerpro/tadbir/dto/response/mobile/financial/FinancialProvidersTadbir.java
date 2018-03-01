package com.sefryek.brokerpro.tadbir.dto.response.mobile.financial;

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
 * @date: 30, Jan, 2017
 */
public class FinancialProvidersTadbir extends TadbirResponse {

    @JsonProperty("List")
    private List<FinancialProviderTadbir> financialProviders = new ArrayList<>();

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<FinancialProviderTadbir> getFinancialProviders() {
        return financialProviders;
    }

    public void setFinancialProviders(List<FinancialProviderTadbir> financialProviders) {
        this.financialProviders = financialProviders;
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
        return "FinancialProvidersTadbir{" +
                "financialProviders=" + financialProviders +
                ", additionalProperties=" + additionalProperties +
                "} " + super.toString();
    }
}
