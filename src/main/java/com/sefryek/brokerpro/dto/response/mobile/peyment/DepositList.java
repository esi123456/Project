package com.sefryek.brokerpro.dto.response.mobile.peyment;

import com.sefryek.brokerpro.dto.response.mobile.peyment.enumeration.DepositState;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 20, May, 2017
 */
public class DepositList {
    private Long depositId;
    private BigDecimal amount;
    private String bankAccountDescription;
    private String bankDocumentNumber;
    private String brokerDescription;
    private Boolean deletable;
    private DepositState depositState;
    private Date performDate;
    private BigDecimal registeredAmount;
    private Date requestDate;
    private Date bankDocumentDate;

    public Long getDepositId() {
        return depositId;
    }

    public void setDepositId(Long depositId) {
        this.depositId = depositId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBankAccountDescription() {
        return bankAccountDescription;
    }

    public void setBankAccountDescription(String bankAccountDescription) {
        this.bankAccountDescription = bankAccountDescription;
    }

    public String getBankDocumentNumber() {
        return bankDocumentNumber;
    }

    public void setBankDocumentNumber(String bankDocumentNumber) {
        this.bankDocumentNumber = bankDocumentNumber;
    }

    public String getBrokerDescription() {
        return brokerDescription;
    }

    public void setBrokerDescription(String brokerDescription) {
        this.brokerDescription = brokerDescription;
    }

    public Boolean getDeletable() {
        return deletable;
    }

    public void setDeletable(Boolean deletable) {
        this.deletable = deletable;
    }

    public DepositState getDepositState() {
        return depositState;
    }

    public void setDepositState(DepositState depositState) {
        this.depositState = depositState;
    }

    public Date getPerformDate() {
        return performDate;
    }

    public void setPerformDate(Date performDate) {
        this.performDate = performDate;
    }

    public BigDecimal getRegisteredAmount() {
        return registeredAmount;
    }

    public void setRegisteredAmount(BigDecimal registeredAmount) {
        this.registeredAmount = registeredAmount;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getBankDocumentDate() {
        return bankDocumentDate;
    }

    public void setBankDocumentDate(Date bankDocumentDate) {
        this.bankDocumentDate = bankDocumentDate;
    }

    @Override
    public String toString() {
        return "DepositList{" +
                "depositId=" + depositId +
                ", amount=" + amount +
                ", bankAccountDescription='" + bankAccountDescription + '\'' +
                ", bankDocumentNumber='" + bankDocumentNumber + '\'' +
                ", brokerDescription='" + brokerDescription + '\'' +
                ", deletable=" + deletable +
                ", depositState=" + depositState +
                ", performDate=" + performDate +
                ", registeredAmount=" + registeredAmount +
                ", requestDate=" + requestDate +
                ", bankDocumentDate=" + bankDocumentDate +
                '}';
    }
}
