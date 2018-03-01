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
 * @date: 22, Apr, 2017
 */
public class RowDetailsRealTimePortfolioTadbir extends TadbirResponse {
    @JsonProperty("PortfolioRecords")
    private List<PortfolioRecordsTadbir> portfolioRecordsTadbirList = new ArrayList<>();

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<PortfolioRecordsTadbir> getPortfolioRecordsTadbirList() {
        return portfolioRecordsTadbirList;
    }

    public void setPortfolioRecordsTadbirList(List<PortfolioRecordsTadbir> portfolioRecordsTadbirList) {
        this.portfolioRecordsTadbirList = portfolioRecordsTadbirList;
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
        return "RowDetailsRealTimePortfolioTadbir{" +
                "portfolioRecordsTadbirList=" + portfolioRecordsTadbirList +
                ", additionalProperties=" + additionalProperties +
                "} " + super.toString();
    }
}
