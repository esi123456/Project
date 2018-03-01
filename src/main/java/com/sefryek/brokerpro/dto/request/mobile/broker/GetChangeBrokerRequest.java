package com.sefryek.brokerpro.dto.request.mobile.broker;

import com.sefryek.brokerpro.dto.request.Request;

import java.util.Date;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 29, May, 2017
 */
public class GetChangeBrokerRequest extends Request{
    private String symbolISIN;
    private Date fromDate;
    private Date toDate;

    public String getSymbolISIN() {
        return symbolISIN;
    }

    public void setSymbolISIN(String symbolISIN) {
        this.symbolISIN = symbolISIN;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return "GetChangeBrokerRequest{" +
                "symbolISIN='" + symbolISIN + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }
}
