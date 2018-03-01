package com.sefryek.brokerpro.dto.response.mobile.peyment;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 30, May, 2017
 */
public class TransactionArchive {
    private BigDecimal creditor;
    private BigDecimal debtor;
    private BigDecimal balance;
    private String description;
    private Date date;

    public BigDecimal getCreditor() {
        return creditor;
    }

    public void setCreditor(BigDecimal creditor) {
        this.creditor = creditor;
    }

    public BigDecimal getDebtor() {
        return debtor;
    }

    public void setDebtor(BigDecimal debtor) {
        this.debtor = debtor;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TransactionArchive{" +
                "creditor=" + creditor +
                ", debtor=" + debtor +
                ", balance=" + balance +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
