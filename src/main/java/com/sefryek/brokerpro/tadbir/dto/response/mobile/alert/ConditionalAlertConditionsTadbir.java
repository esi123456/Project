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
 * @date: 06, May, 2017
 */
@JsonPropertyOrder({
        "Conditions",
        "IsSuccessful",
        "ErrorCode",
        "ErrorDescription"
})
public class ConditionalAlertConditionsTadbir extends TadbirResponse {

    @JsonProperty("Conditions")
    private List<ConditionsTadbir> conditionsTadbirList = new ArrayList<>();
    @JsonProperty("TotalRecord")
    private Integer totalRecord;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The conditionsTadbirList
     */
    @JsonProperty("Conditions")
    public List<ConditionsTadbir> getConditionsTadbirList() {
        return conditionsTadbirList;
    }

    /**
     * @param conditionsTadbirList The ConditionsTadbirList
     */
    @JsonProperty("Conditions")
    public void setConditionsTadbirList(List<ConditionsTadbir> conditionsTadbirList) {
        this.conditionsTadbirList = conditionsTadbirList;
    }

    /**
     * @return The totalRecord
     */
    @JsonProperty("TotalRecord")
    public Integer getTotalRecord() {
        return totalRecord;
    }


    /**
     * @param totalRecord The TotalRecord
     */
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
        return "ConditionalAlertConditionsTadbir{" +
                "conditionsTadbirList=" + conditionsTadbirList +
                ", totalRecord=" + totalRecord +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
