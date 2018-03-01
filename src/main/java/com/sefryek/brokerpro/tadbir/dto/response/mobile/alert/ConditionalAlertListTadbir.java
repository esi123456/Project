package com.sefryek.brokerpro.tadbir.dto.response.mobile.alert;

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
 * @date: 29, Apr, 2017
 */
@JsonPropertyOrder({
        "ConditionalAlerts",
        "TotalRecord",
        "IsSuccessful",
        "ErrorCode",
        "ErrorDescription"
})
public class ConditionalAlertListTadbir extends TadbirResponse {

    @JsonProperty("ConditionalAlerts")
    private List<ConditionalAlertTadbir> conditionalAlertTadbirList = new ArrayList<>();
    @JsonProperty("TotalRecord")
    private Integer totalRecord;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The conditionalAlertTadbirList
     */
    @JsonProperty("ConditionalAlerts")
    public List<ConditionalAlertTadbir> getConditionalAlertTadbirList() {
        return conditionalAlertTadbirList;
    }

    /**
     * @param conditionalAlertTadbirList The ConditionalAlertsList
     */
    @JsonProperty("ConditionalAlerts")
    public void setConditionalAlertTadbirList(List<ConditionalAlertTadbir> conditionalAlertTadbirList) {
        this.conditionalAlertTadbirList = conditionalAlertTadbirList;
    }

    @JsonProperty("TotalRecord")
    public Integer getTotalRecord() {
        return totalRecord;
    }

    @JsonProperty("TotalRecord")
    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
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
        return "ConditionalAlertListTadbir{" +
                "conditionalAlertTadbirList=" + conditionalAlertTadbirList +
                ", totalRecord=" + totalRecord +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
