package com.sefryek.brokerpro.tadbir.dto.response.mobile.portfolio.stock;

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
 * @date: 09, Apr, 2017
 */
public class DailyCustomerStockPortfolioTadbir extends TadbirResponse {

    @JsonProperty("CustomerStockPortfolio")
    private List<CustomerStockPortfolioTadbir> customerStockPortfolioTadbirList = new ArrayList<>();

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<CustomerStockPortfolioTadbir> getCustomerStockPortfolioTadbirList() {
        return customerStockPortfolioTadbirList;
    }

    public void setCustomerStockPortfolioTadbirList(List<CustomerStockPortfolioTadbir> customerStockPortfolioTadbirList) {
        this.customerStockPortfolioTadbirList = customerStockPortfolioTadbirList;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


}
