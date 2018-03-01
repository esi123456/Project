package com.sefryek.brokerpro.tadbir.dto.response.mobile.financial;

import com.fasterxml.jackson.annotation.*;

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
public class FinancialProviderTadbir {
    /** this parameter will be set manually **/
    private String brokerCode;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("FinancialId")
    private Integer financialId;
    @JsonProperty("Names")
    private List<FinancialNameTadbir> names = new ArrayList<>();
    @JsonProperty("Active")
    private Boolean active;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getBrokerCode() {
        return brokerCode;
    }

    public void setBrokerCode(String brokerCode) {
        this.brokerCode = brokerCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFinancialId() {
        return financialId;
    }

    public void setFinancialId(Integer financialId) {
        this.financialId = financialId;
    }

    public List<FinancialNameTadbir> getNames() {
        return names;
    }

    public void setNames(List<FinancialNameTadbir> names) {
        this.names = names;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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
        return "FinancialProviderTadbir{" +
                "brokerCode='" + brokerCode + '\'' +
                ", name='" + name + '\'' +
                ", financialId=" + financialId +
                ", names=" + names +
                ", active=" + active +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
