package com.sefryek.brokerpro.tadbir.dto.response.market.index;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 24, Jul, 2017
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndexInfoTadbir {
    @JsonProperty("IndexHistoricalDataResult")
    private Map<String, IndexDetailTadbir> indexDetailMap  = new HashMap<>();

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    public Map<String, IndexDetailTadbir> getIndexDetailMap() {
        return indexDetailMap;
    }

    public void setIndexDetailMap(Map<String, IndexDetailTadbir> indexDetailMap) {
        this.indexDetailMap = indexDetailMap;
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
        return "IndexInfoTadbir{" +
                "indexDetailMap=" + indexDetailMap +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}