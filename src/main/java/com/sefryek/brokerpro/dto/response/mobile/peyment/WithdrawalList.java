package com.sefryek.brokerpro.dto.response.mobile.peyment;

import com.sefryek.brokerpro.dto.response.mobile.peyment.enumeration.WithdrawalState;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, May, 2017
 */
public class WithdrawalList {
    private Long requestedId;
    private BigDecimal requestedAmount;
    private Date requestDate;
    private Date requestForDate;
    private String accountNumber;
    private BigDecimal dueAmount;
    private WithdrawalState state;
    private String brokerMessage;

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

    public WithdrawalState getState() {
        return state;
    }

    public void setState(WithdrawalState state) {
        this.state = state;
    }

    public String getBrokerMessage() {
        return brokerMessage;
    }

    public void setBrokerMessage(String brokerMessage) {
        this.brokerMessage = brokerMessage;
    }

    @Override
    public String toString() {
        return "WithdrawalList{" +
                "requestedId=" + requestedId +
                ", requestedAmount=" + requestedAmount +
                ", requestDate=" + requestDate +
                ", requestForDate=" + requestForDate +
                ", accountNumber='" + accountNumber + '\'' +
                ", dueAmount=" + dueAmount +
                ", state=" + state +
                ", brokerMessage='" + brokerMessage + '\'' +
                '}';
    }
}
