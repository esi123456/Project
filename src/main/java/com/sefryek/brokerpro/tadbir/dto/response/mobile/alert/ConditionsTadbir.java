package com.sefryek.brokerpro.tadbir.dto.response.mobile.alert;

import com.fasterxml.jackson.annotation.*;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.alert.enumeration.EqualityTypeTadbir;

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
        "ValueInSearch",
        "ConditionDescription",
        "EqualityType",
        "Isin"
})
public class ConditionsTadbir {
    @JsonProperty("ValueInSearch")
    private String valueInSearch;
    @JsonProperty("ConditionDescription")
    private String conditionDescription;
    @JsonProperty("EqualityType")
    private EqualityTypeTadbir equalityType;
    @JsonProperty("Isin")
    private String nscCode;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The valueInSearch
     */
    @JsonProperty("ValueInSearch")
    public String getValueInSearch() {
        return valueInSearch;
    }

    /**
     * @param valueInSearch The ValueInSearch
     */
    @JsonProperty("ValueInSearch")
    public void setValueInSearch(String valueInSearch) {
        this.valueInSearch = valueInSearch;
    }

    /**
     * @return The conditionDescription
     */
    @JsonProperty("ConditionDescription")
    public String getConditionDescription() {
        return conditionDescription;
    }

    /**
     * @param conditionDescription The ConditionDescription
     */
    @JsonProperty("ConditionDescription")
    public void setConditionDescription(String conditionDescription) {
        this.conditionDescription = conditionDescription;
    }

    /**
     * @return The equalityType
     */
    @JsonProperty("EqualityType")
    public EqualityTypeTadbir getEqualityType() {
        return equalityType;
    }

    /**
     * @param equalityType The EqualityType
     */
    @JsonProperty("EqualityType")
    public void setEqualityType(EqualityTypeTadbir equalityType) {
        this.equalityType = equalityType;
    }

    /**
     * @return The nscCode
     */
    @JsonProperty("Isin")
    public String getNscCode() {
        return nscCode;
    }

    /**
     * @param nscCode The nscCode
     */
    @JsonProperty("Isin")
    public void setNscCode(String nscCode) {
        this.nscCode = nscCode;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
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
