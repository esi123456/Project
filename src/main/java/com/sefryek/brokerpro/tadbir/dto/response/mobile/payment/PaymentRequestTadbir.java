package com.sefryek.brokerpro.tadbir.dto.response.mobile.payment;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sefryek.brokerpro.config.jackson.DateFilterTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.payment.enumeration.PaymentStateTadbir;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, May, 2017
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentRequestTadbir {
    @JsonProperty("RequestedId")
    private Long requestedId;
    @JsonProperty("RequestedAmount")
    private BigDecimal requestedAmount;
    @JsonProperty("RequestDate")
    @JsonDeserialize(using = DateFilterTadbir.class)
    private Date requestDate;
    @JsonProperty("RequestForDate")
    @JsonDeserialize(using = DateFilterTadbir.class)
    private Date requestForDate;
    @JsonProperty("AccountNumber")
    private String accountNumber;
    @JsonProperty("DuedAmount")
    private BigDecimal dueAmount;
    @JsonProperty("StateId")
    private Long stateId;
    @JsonProperty("State")
    private PaymentStateTadbir state;
    @JsonProperty("BrokerMessage")
    private String brokerMessage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Long getRequestedId() {
        return requestedId;
    }

    public void setRequestedId(Long requestedId) {
        this.requestedId = requestedId;
    }

    public BigDecimal getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(BigDecimal requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getRequestForDate() {
        return requestForDate;
    }

    public void setRequestForDate(Date requestForDate) {
        this.requestForDate = requestForDate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(BigDecimal dueAmount) {
        this.dueAmount = dueAmount;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public PaymentStateTadbir getState() {
        return state;
    }

    public void setState(PaymentStateTadbir state) {
        this.state = state;
    }

    public String getBrokerMessage() {
        return brokerMessage;
    }

    public void setBrokerMessage(String brokerMessage) {
        this.brokerMessage = brokerMessage;
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
        return "PaymentRequestTadbir{" +
                "requestedId=" + requestedId +
                ", requestedAmount=" + requestedAmount +
                ", requestDate=" + requestDate +
                ", requestForDate=" + requestForDate +
                ", accountNumber='" + accountNumber + '\'' +
                ", dueAmount=" + dueAmount +
                ", stateId=" + stateId +
                ", state=" + state +
                ", brokerMessage='" + brokerMessage + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
