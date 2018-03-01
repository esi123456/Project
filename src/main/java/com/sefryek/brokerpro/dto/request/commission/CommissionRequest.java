package com.sefryek.brokerpro.dto.request.commission;

import com.sefryek.brokerpro.dto.request.Request;

import javax.validation.constraints.NotNull;

/*
 * Copyright 2016 (C) syspod.co
 *
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */
public class CommissionRequest extends Request {

    @NotNull
    private String symbolISIN;

    public String getSymbolISIN() {
        return symbolISIN;
    }

    public void setSymbolISIN(String symbolISIN) {
        this.symbolISIN = symbolISIN;
    }

    @Override
    public String toString() {
        return "CommissionRequest{" +
                "symbolISIN='" + symbolISIN + '\'' +
                "} ";
    }
}
