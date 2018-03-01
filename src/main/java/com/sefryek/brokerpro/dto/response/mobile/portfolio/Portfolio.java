package com.sefryek.brokerpro.dto.response.mobile.portfolio;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 02, Jan, 2017
 */
public class Portfolio {
    private Long count;
    private String symbolISIN;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getSymbolISIN() {
        return symbolISIN;
    }

    public void setSymbolISIN(String symbolISIN) {
        this.symbolISIN = symbolISIN;
    }

    @Override
    public String toString() {
        return "PortfolioMapper{" +
                "count=" + count +
                ", symbolISIN='" + symbolISIN + '\'' +
                '}';
    }
}
