package com.sefryek.brokerpro.tadbir.dto.response.market.watch;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 30, May, 2017
 */

public class MarketWatchTadbir {
    @JsonProperty("PositiveCount")
    private Long positiveCount;
    @JsonProperty("NegativeCount")
    private Long negativeCount;
    @JsonProperty("UnchangedCount")
    private Long unchangedCount;
    @JsonProperty("MarketType")
    private MarketTypeTadbir marketType;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Long getPositiveCount() {
        return positiveCount;
    }

    public void setPositiveCount(Long positiveCount) {
        this.positiveCount = positiveCount;
    }

    public Long getNegativeCount() {
        return negativeCount;
    }

    public void setNegativeCount(Long negativeCount) {
        this.negativeCount = negativeCount;
    }

    public Long getUnchangedCount() {
        return unchangedCount;
    }

    public void setUnchangedCount(Long unchangedCount) {
        this.unchangedCount = unchangedCount;
    }

    public MarketTypeTadbir getMarketType() {
        return marketType;
    }

    public void setMarketType(MarketTypeTadbir marketType) {
        this.marketType = marketType;
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
        return "MarketWatchTadbir{" +
                "positiveCount=" + positiveCount +
                ", negativeCount=" + negativeCount +
                ", unchangedCount=" + unchangedCount +
                ", marketType=" + marketType +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
