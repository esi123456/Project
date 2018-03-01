package com.sefryek.brokerpro.tadbir.dto.response.mobile.watchlist;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 22, Feb, 2017
 */
public class WatchListsTadbir {
    @JsonProperty("Title")
    private String categoryName;
    @JsonProperty("WatchListId")
    private Long categoryId;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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
        return "WatchListsTadbir{" +
                "categoryName='" + categoryName + '\'' +
                ", categoryId=" + categoryId +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
