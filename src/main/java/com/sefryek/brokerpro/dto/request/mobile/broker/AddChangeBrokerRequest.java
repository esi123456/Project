package com.sefryek.brokerpro.dto.request.mobile.broker;

import com.sefryek.brokerpro.dto.request.Request;
import com.sefryek.brokerpro.dto.request.mobile.broker.enumeration.ChangeBrokerType;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 30, May, 2017
 */
public class AddChangeBrokerRequest extends Request{
    private ChangeBrokerType changeBrokerType;
    private String certificateNumber;
    private String symbolISIN;
    private String description;

    public ChangeBrokerType getChangeBrokerType() {
        return changeBrokerType;
    }

    public void setChangeBrokerType(ChangeBrokerType changeBrokerType) {
        this.changeBrokerType = changeBrokerType;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getSymbolISIN() {
        return symbolISIN;
    }

    public void setSymbolISIN(String symbolISIN) {
        this.symbolISIN = symbolISIN;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AddChangeBrokerRequest{" +
                "changeBrokerType=" + changeBrokerType +
                ", certificateNumber='" + certificateNumber + '\'' +
                ", symbolISIN='" + symbolISIN + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
