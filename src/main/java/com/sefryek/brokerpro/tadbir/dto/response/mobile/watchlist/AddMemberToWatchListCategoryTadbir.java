package com.sefryek.brokerpro.tadbir.dto.response.mobile.watchlist;

import com.fasterxml.jackson.annotation.*;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 26, Feb, 2017
 */
@JsonPropertyOrder({
        "WatchListRowNum",
        "IsSuccessful",
        "ErrorCode",
        "ErrorDescription"
})
public class AddMemberToWatchListCategoryTadbir extends TadbirResponse {

    @JsonProperty("WatchListRowNum")
    private int watchListRowNum;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The watchListRowNum
     */
    @JsonProperty("WatchListRowNum")
    public int getWatchListRowNum() {
        return watchListRowNum;
    }

    /**
     * @param watchListRowNum The WatchListRowNum
     */
    @JsonProperty("WatchListRowNum")
    public void setWatchListRowNum(int watchListRowNum) {
        this.watchListRowNum = watchListRowNum;
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
