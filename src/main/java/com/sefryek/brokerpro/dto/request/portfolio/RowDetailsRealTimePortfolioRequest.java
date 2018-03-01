package com.sefryek.brokerpro.dto.request.portfolio;

import com.sefryek.brokerpro.dto.request.Request;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 22, Apr, 2017
 */
public class RowDetailsRealTimePortfolioRequest extends Request{

    private String symbolISIN;

    public String getSymbolISIN() {
        return symbolISIN;
    }

    public void setSymbolISIN(String symbolISIN) {
        this.symbolISIN = symbolISIN;
    }

    @Override
    public String toString() {
        return "RowDetailsRealTimePortfolioRequest{" +
                "symbolISIN='" + symbolISIN + '\'' +
                '}';
    }
}
