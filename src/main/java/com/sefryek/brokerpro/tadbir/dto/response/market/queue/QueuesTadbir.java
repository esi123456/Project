package com.sefryek.brokerpro.tadbir.dto.response.market.queue;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirPageableResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 14, Dec, 2016
 */
public class QueuesTadbir extends TadbirPageableResponse {

    @JsonProperty("List")
    private List<QueueTadbir> queueTadbir = new ArrayList<>();

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<QueueTadbir> getQueueTadbir() {
        return queueTadbir;
    }

    public void setQueueTadbir(List<QueueTadbir> queueTadbir) {
        this.queueTadbir = queueTadbir;
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
        return "QueuesTadbir{" +
                "queueTadbir=" + queueTadbir +
                ", additionalProperties=" + additionalProperties +
                "} " + super.toString();
    }
}
