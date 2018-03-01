package com.sefryek.brokerpro.tadbir.dto.response.market.best;

import com.fasterxml.jackson.annotation.*;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirResponse;
import com.sefryek.brokerpro.tadbir.dto.response.market.price.Price;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 08, Jan, 2017
 */
@JsonPropertyOrder({
        "Prices",
        "IsSuccessful",
        "ErrorCode",
        "ErrorDescription"
})
public class BestOfMarketsTadbir extends TadbirResponse {

    @JsonProperty("Prices")
    private List<Price> bestOfMarketTadbir = new ArrayList<>();

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The bestOfMarketTadbir
     */
    @JsonProperty("Prices")
    public List<Price> getBestOfMarketTadbir() {
        return bestOfMarketTadbir;
    }

    /**
     * @param bestOfMarketTadbir The BestOfMarketTadbir
     */
    @JsonProperty("Prices")
    public void setBestOfMarketTadbir(List<Price> bestOfMarketTadbir) {
        this.bestOfMarketTadbir = bestOfMarketTadbir;
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
