package com.sefryek.brokerpro.tadbir.dto.response.mobile.portfolio;

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
 * @date: 02, Jan, 2017
 */
public class CustomerCdsPortfolioTadbir extends TadbirResponse {
    @JsonProperty("List")
    private List<PortfolioTadbir> portfolioList = new ArrayList<>();

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<PortfolioTadbir> getPortfolioList() {
        return portfolioList;
    }

    public void setPortfolioList(List<PortfolioTadbir> portfolioList) {
        this.portfolioList = portfolioList;
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
        return "CustomerCdsPortfolioTadbir{" +
                "portfolioList=" + portfolioList +
                ", additionalProperties=" + additionalProperties +
                "} " + super.toString();
    }
}