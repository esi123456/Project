package com.sefryek.brokerpro.tadbir.dto.response.market.index;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sefryek.brokerpro.config.jackson.DateFilterTadbir;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 28, May, 2017
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndexDetailTadbir {
    @JsonProperty("SymbolISIN")
    private String indexISIN;
    @JsonProperty("SymbolTitle")
    private String indexName;
    @JsonProperty("LastIndexValue")
    private BigDecimal lastValue;
    @JsonProperty("IndexChanges")
    private BigDecimal changeReal;
    @JsonProperty("PercentVariation")
    private BigDecimal changePercent;
    @JsonDeserialize(using = DateFilterTadbir.class)
    @JsonProperty("DayOfEvent")
    private Date dateTime;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    public String getIndexISIN() {
        return indexISIN;
    }

    public void setIndexISIN(String indexISIN) {
        this.indexISIN = indexISIN;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public BigDecimal getLastValue() {
        return lastValue;
    }

    public void setLastValue(BigDecimal lastValue) {
        this.lastValue = lastValue;
    }

    public BigDecimal getChangeReal() {
        return changeReal;
    }

    public void setChangeReal(BigDecimal changeReal) {
        this.changeReal = changeReal;
    }

    public BigDecimal getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(BigDecimal changePercent) {
        this.changePercent = changePercent;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
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
        return "IndexDetailTadbir{" +
                "indexISIN='" + indexISIN + '\'' +
                ", indexName='" + indexName + '\'' +
                ", lastValue=" + lastValue +
                ", changeReal=" + changeReal +
                ", changePercent=" + changePercent +
                ", dateTime=" + dateTime +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
