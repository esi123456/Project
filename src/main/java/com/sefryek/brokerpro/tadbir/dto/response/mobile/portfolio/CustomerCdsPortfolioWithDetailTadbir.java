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
 * @date: 07, Jan, 2017
 */
@JsonPropertyOrder({
        "PortfolioListWithDetail",
        "IsSuccessful",
        "ErrorCode",
        "ErrorDescription"
})
public class CustomerCdsPortfolioWithDetailTadbir extends TadbirResponse {

    @JsonProperty("PortfolioListWithDetail")
    private List<PortfolioWithDetailTadbir> portfolioListWithDetailList = new ArrayList<>();

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The portfolioListWithDetailList
     */
    @JsonProperty("PortfolioListWithDetail")
    public List<PortfolioWithDetailTadbir> getPortfolioListWithDetailList() {
        return portfolioListWithDetailList;
    }

    /**
     * @param portfolioListWithDetailList The PortfolioListWithDetailList
     */
    @JsonProperty("PortfolioListWithDetail")
    public void setPortfolioListWithDetailList(List<PortfolioWithDetailTadbir> portfolioListWithDetailList) {
        this.portfolioListWithDetailList = portfolioListWithDetailList;
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
