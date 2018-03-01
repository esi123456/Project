package com.sefryek.brokerpro.tadbir.dto.response.mobile.payment;

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
 * @date: 30, May, 2017
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionTadbir {
    @JsonProperty("Creditor")
    private BigDecimal creditor;
    @JsonProperty("Debtor")
    private BigDecimal debtor;
    @JsonProperty("Balance")
    private BigDecimal balance;
    @JsonProperty("Description")
    private String description;
    @JsonDeserialize(using = DateFilterTadbir.class)
    @JsonProperty("Date")
    private Date date;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Creditor")
    public BigDecimal getCreditor() {
        return creditor;
    }

    @JsonProperty("Creditor")
    public void setCreditor(BigDecimal creditor) {
        this.creditor = creditor;
    }

    @JsonProperty("Debtor")
    public BigDecimal getDebtor() {
        return debtor;
    }

    @JsonProperty("Debtor")
    public void setDebtor(BigDecimal debtor) {
        this.debtor = debtor;
    }

    @JsonProperty("Balance")
    public BigDecimal getBalance() {
        return balance;
    }

    @JsonProperty("Balance")
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("Date")
    public Date getDate() {
        return date;
    }

    @JsonProperty("Date")
    public void setDate(Date date) {
        this.date = date;
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
        return "TransactionTadbir{" +
                "creditor=" + creditor +
                ", debtor=" + debtor +
                ", balance=" + balance +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
