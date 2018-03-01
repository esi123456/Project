package com.sefryek.brokerpro.tadbir.dto.response.mobile.broker;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirPageableResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 29, May, 2017
 */
public class GetChangeBrokerResponseTadbir extends TadbirPageableResponse {
    @JsonProperty("List")
    private List<GetChangeBrokerTadbir> changeBrokerList;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<GetChangeBrokerTadbir> getChangeBrokerList() {
        return changeBrokerList;
    }

    public void setChangeBrokerList(List<GetChangeBrokerTadbir> changeBrokerList) {
        this.changeBrokerList = changeBrokerList;
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
        return "GetChangeBrokerResponseTadbir{" +
                "changeBrokerList=" + changeBrokerList +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
