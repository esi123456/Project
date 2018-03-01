package com.sefryek.brokerpro.tadbir.dto.response.mobile.alert;

import com.fasterxml.jackson.annotation.*;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 03, May, 2017
 */
@JsonPropertyOrder({
        "Id",
        "IsSuccessful",
        "ErrorCode",
        "ErrorDescription"
})
public class DeleteConditionalAlertTadbir extends TadbirResponse {

    @JsonProperty("Id")
    private Long id;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The id
     */
    @JsonProperty("Id")
    public Long getId() {
        return id;
    }

    /**
     * @param id The Id
     */
    @JsonProperty("Id")
    public void setId(Long id) {
        this.id = id;
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
        return "AddConditionalAlertTadbir{" +
                "id=" + id +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
