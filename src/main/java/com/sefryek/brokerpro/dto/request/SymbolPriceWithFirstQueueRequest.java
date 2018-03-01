package com.sefryek.brokerpro.dto.request;

import javax.validation.constraints.NotNull;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 31, Dec, 2016
 */
public class SymbolPriceWithFirstQueueRequest extends Request {

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
        return "QueueRequest{" +
                "symbolISIN='" + symbolISIN + '\'' +
                '}';
    }
}
