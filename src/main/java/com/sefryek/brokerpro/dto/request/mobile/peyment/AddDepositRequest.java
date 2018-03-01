package com.sefryek.brokerpro.dto.request.mobile.peyment;

import com.sefryek.brokerpro.dto.request.Request;

import java.util.Date;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 10, May, 2017
 */
public class AddDepositRequest extends Request{
    private String amount;
    private String bankDocumentNumber;
    private String accountNumber;
    private Date performDate;
    private String emergencyPhone;
    private String depositReason;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBankDocumentNumber() {
        return bankDocumentNumber;
    }

    public void setBankDocumentNumber(String bankDocumentNumber) {
        this.bankDocumentNumber = bankDocumentNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getPerformDate() {
        return performDate;
    }

    public void setPerformDate(Date performDate) {
        this.performDate = performDate;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    public String getDepositReason() {
        return depositReason;
    }

    public void setDepositReason(String depositReason) {
        this.depositReason = depositReason;
    }

    @Override
    public String toString() {
        return "AddDepositRequest{" +
                "amount='" + amount + '\'' +
                ", bankDocumentNumber='" + bankDocumentNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", performDate=" + performDate +
                ", emergencyPhone='" + emergencyPhone + '\'' +
                ", depositReason='" + depositReason + '\'' +
                '}';
    }
}
