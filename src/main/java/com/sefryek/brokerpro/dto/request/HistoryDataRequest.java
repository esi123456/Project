package com.sefryek.brokerpro.dto.request;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 26, Dec, 2016
 */
public class HistoryDataRequest extends Request {

    private String symbolISIN;
    private Integer timePart;

    public String getSymbolISIN() {
        return symbolISIN;
    }

    public void setSymbolISIN(String symbolISIN) {
        this.symbolISIN = symbolISIN;
    }

    public Integer getTimePart() {
        return timePart;
    }

    public void setTimePart(Integer timePart) {
        this.timePart = timePart;
    }

    @Override
    public String toString() {
        return "HistoryDataRequest{" +
                "symbolISIN='" + symbolISIN + '\'' +
                ", timePart=" + timePart +
                '}';
    }
}
