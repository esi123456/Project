package com.sefryek.brokerpro.dto.response.mobile.watchlist;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 26, Feb, 2017
 */
public class WatchListRow {
    private String symbolISIN;
    private String symbolFa;
    private String note;

    public String getSymbolISIN() {
        return symbolISIN;
    }

    public void setSymbolISIN(String symbolISIN) {
        this.symbolISIN = symbolISIN;
    }

    public String getSymbolFa() {
        return symbolFa;
    }

    public void setSymbolFa(String symbolFa) {
        this.symbolFa = symbolFa;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "WatchListRow{" +
                "symbolISIN='" + symbolISIN + '\'' +
                ", symbolFa='" + symbolFa + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
