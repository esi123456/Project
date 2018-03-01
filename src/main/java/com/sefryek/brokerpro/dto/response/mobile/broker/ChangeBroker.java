package com.sefryek.brokerpro.dto.response.mobile.broker;

import com.sefryek.brokerpro.dto.response.mobile.broker.enumeration.BrokerState;
import com.sefryek.brokerpro.dto.response.mobile.broker.enumeration.CreatedFrom;

import java.util.Date;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 29, May, 2017
 */
public class ChangeBroker {
    private Long requestedId;
    private String symbolISIN;
    private String symbolCompleteName;
    private Date requestDate;
    private CreatedFrom createdFrom;
    private String Description;
    private BrokerState state;

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

    public String getSymbolCompleteName() {
        return symbolCompleteName;
    }

    public void setSymbolCompleteName(String symbolCompleteName) {
        this.symbolCompleteName = symbolCompleteName;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public CreatedFrom getCreatedFrom() {
        return createdFrom;
    }

    public void setCreatedFrom(CreatedFrom createdFrom) {
        this.createdFrom = createdFrom;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public BrokerState getState() {
        return state;
    }

    public void setState(BrokerState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ChangeBroker{" +
                "requestedId=" + requestedId +
                ", symbolISIN='" + symbolISIN + '\'' +
                ", symbolCompleteName='" + symbolCompleteName + '\'' +
                ", requestDate=" + requestDate +
                ", createdFrom=" + createdFrom +
                ", Description='" + Description + '\'' +
                ", state=" + state +
                '}';
    }
}
