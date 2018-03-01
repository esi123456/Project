package com.sefryek.brokerpro.tadbir.dto.response.mobile.watchlist;

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
 * @date: 22, Feb, 2017
 */
public class CategoryOfWatchListTadbir extends TadbirResponse {

    @JsonProperty("List")
    private List<WatchListsTadbir> watchListsTadbir = new ArrayList<>();

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<WatchListsTadbir> getWatchListsTadbir() {
        return watchListsTadbir;
    }

    public void setWatchListsTadbir(List<WatchListsTadbir> watchListsTadbir) {
        this.watchListsTadbir = watchListsTadbir;
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
        return "CategoryOfWatchListTadbir{" +
                "watchListsTadbir=" + watchListsTadbir +
                ", additionalProperties=" + additionalProperties +
                "} " + super.toString();
    }
}
