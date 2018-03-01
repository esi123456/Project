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
 * @date: 26, Feb, 2017
 */
public class MemberListOfWatchListCategoryTadbir extends TadbirResponse {
    @JsonProperty("List")
    private List<WatchListRowTadbir> watchListRowTadbir = new ArrayList<>();

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<WatchListRowTadbir> getWatchListRowTadbir() {
        return watchListRowTadbir;
    }

    public void setWatchListRowTadbir(List<WatchListRowTadbir> watchListRowTadbir) {
        this.watchListRowTadbir = watchListRowTadbir;
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
        return "MemberListOfWatchListCategoryTadbir{" +
                "watchListRowTadbir=" + watchListRowTadbir +
                ", additionalProperties=" + additionalProperties +
                "} " + super.toString();
    }
}
