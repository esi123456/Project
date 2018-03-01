package com.sefryek.brokerpro.tadbir.dto.response.mobile.broker;

import com.fasterxml.jackson.annotation.*;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.broker.enumeration.BrokerStateTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.broker.enumeration.CreatedFromTadbir;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 29, May, 2017
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetChangeBrokerTadbir {
    @JsonProperty("RequestedId")
    private Long requestedId;
    @JsonProperty("SymbolISIN")
    private String symbolISIN;
    @JsonProperty("RequestDate")
    private Date requestDate;
    @JsonProperty("CreatedFrom")
    private CreatedFromTadbir createdFrom;
    @JsonProperty("Description")
    private String Description;
    @JsonProperty("State")
    private BrokerStateTadbir state;
    @JsonProperty("Symbol")
    private String symbolCompleteName;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Long getRequestedId() {
        return requestedId;
    }

    public void setRequestedId(Long requestedId) {
        this.requestedId = requestedId;
    }

    public String getSymbolISIN() {
        return symbolISIN;
    }

    public void setSymbolISIN(String symbolISIN) {
        this.symbolISIN = symbolISIN;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public CreatedFromTadbir getCreatedFrom() {
        return createdFrom;
    }

    public void setCreatedFrom(CreatedFromTadbir createdFrom) {
        this.createdFrom = createdFrom;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public BrokerStateTadbir getState() {
        return state;
    }

    public void setState(BrokerStateTadbir state) {
        this.state = state;
    }

    public String getSymbolCompleteName() {
        return symbolCompleteName;
    }

    public void setSymbolCompleteName(String symbolCompleteName) {
        this.symbolCompleteName = symbolCompleteName;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public String toString() {
        return "GetChangeBrokerTadbir{" +
                "requestedId=" + requestedId +
                ", symbolISIN='" + symbolISIN + '\'' +
                ", requestDate=" + requestDate +
                ", createdFrom=" + createdFrom +
                ", Description='" + Description + '\'' +
                ", state=" + state +
                ", symbolCompleteName='" + symbolCompleteName + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
