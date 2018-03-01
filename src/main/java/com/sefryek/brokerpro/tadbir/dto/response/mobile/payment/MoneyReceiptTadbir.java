package com.sefryek.brokerpro.tadbir.dto.response.mobile.payment;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sefryek.brokerpro.config.jackson.DateFilterTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.payment.enumeration.DepositStateTadbir;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 20, May, 2017
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MoneyReceiptTadbir {
    @JsonProperty("ID")
    private Long depositId;
    @JsonProperty("Amount")
    private BigDecimal amount;
    @JsonProperty("BankAccountDescription")
    private String bankAccountDescription;
    @JsonProperty("BankDocumentNumber")
    private String bankDocumentNumber;
    @JsonProperty("BrokerDescription")
    private String brokerDescription;
    @JsonProperty("IsDeletable")
    private Boolean deletable;
    @JsonProperty("StateTitle")
    private DepositStateTadbir depositState;
    @JsonDeserialize(using = DateFilterTadbir.class)
    @JsonProperty("PerformDate")
    private Date performDate;
    @JsonProperty("RegisteredAmount")
    private BigDecimal registeredAmount;
    @JsonDeserialize(using = DateFilterTadbir.class)
    @JsonProperty("RequestDate")
    private Date requestDate;
    @JsonDeserialize(using = DateFilterTadbir.class)
    @JsonProperty("BankDocumentDate")
    private Date bankDocumentDate;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    public DepositStateTadbir getDepositState() {
        return depositState;
    }

    public void setDepositState(DepositStateTadbir depositState) {
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
        return "MoneyReceiptTadbir{" +
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
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
