package com.sefryek.brokerpro.tadbir.dto.response.mobile.alert;

import com.fasterxml.jackson.annotation.*;
import com.sefryek.brokerpro.dto.response.mobile.alert.enumeration.ConditionEngine;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.alert.enumeration.ConditionCategoryTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.alert.enumeration.ConditionTypeTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.alert.enumeration.EqualityTypeTadbir;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 30, Apr, 2017
 */
@JsonPropertyOrder({
        "symbol",
        "symbolTitle",
        "referenceId",
        "category",
        "type",
        "typeTitle",
        "equality",
        "value",
        "engine"
})
public class ConditionsDataTadbir {

    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("symbolTitle")
    private String symbolTitle;
    @JsonProperty("referenceId")
    private String nscCode;
    @JsonProperty("category")
    private ConditionCategoryTadbir category;
    @JsonProperty("type")
    private ConditionTypeTadbir type;
    @JsonProperty("typeTitle")
    private String typeTitle;
    @JsonProperty("equality")
    private EqualityTypeTadbir equality;
    @JsonProperty("value")
    private String value;
    @JsonProperty("engine")
    private ConditionEngine engine;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The symbol
     */
    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    /**
     * @param symbol The symbol
     */
    @JsonProperty("symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * @return The symbolTitle
     */
    @JsonProperty("symbolTitle")
    public String getSymbolTitle() {
        return symbolTitle;
    }

    /**
     * @param symbolTitle The symbolTitle
     */
    @JsonProperty("symbolTitle")
    public void setSymbolTitle(String symbolTitle) {
        this.symbolTitle = symbolTitle;
    }

    /**
     * @return The nscCode
     */
    @JsonProperty("referenceId")
    public String getNscCode() {
        return nscCode;
    }

    /**
     * @param nscCode The nscCode
     */
    @JsonProperty("referenceId")
    public void setNscCode(String nscCode) {
        this.nscCode = nscCode;
    }

    /**
     * @return The category
     */
    @JsonProperty("category")
    public ConditionCategoryTadbir getCategory() {
        return category;
    }

    /**
     * @param category The category
     */
    @JsonProperty("category")
    public void setCategory(ConditionCategoryTadbir category) {
        this.category = category;
    }

    /**
     * @return The type
     */
    @JsonProperty("type")
    public ConditionTypeTadbir getType() {
        return type;
    }

    /**
     * @param type The type
     */
    @JsonProperty("type")
    public void setType(ConditionTypeTadbir type) {
        this.type = type;
    }

    /**
     * @return The typeTitle
     */
    @JsonProperty("typeTitle")
    public String getTypeTitle() {
        return typeTitle;
    }

    /**
     * @param typeTitle The typeTitle
     */
    @JsonProperty("typeTitle")
    public void setTypeTitle(String typeTitle) {
        this.typeTitle = typeTitle;
    }

    /**
     * @return The equality
     */
    @JsonProperty("equality")
    public EqualityTypeTadbir getEquality() {
        return equality;
    }

    /**
     * @param equality The equality
     */
    @JsonProperty("equality")
    public void setEquality(EqualityTypeTadbir equality) {
        this.equality = equality;
    }

    /**
     * @return The value
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * @param value The value
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return The engine
     */
    @JsonProperty("engine")
    public ConditionEngine getEngine() {
        return engine;
    }

    /**
     * @param engine The engine
     */
    @JsonProperty("engine")
    public void setEngine(ConditionEngine engine) {
        this.engine = engine;
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
        return "ConditionsDataTadbir{" +
                "symbol='" + symbol + '\'' +
                ", symbolTitle='" + symbolTitle + '\'' +
                ", nscCode='" + nscCode + '\'' +
                ", category=" + category +
                ", type=" + type +
                ", typeTitle='" + typeTitle + '\'' +
                ", equality=" + equality +
                ", value='" + value + '\'' +
                ", engine=" + engine +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
