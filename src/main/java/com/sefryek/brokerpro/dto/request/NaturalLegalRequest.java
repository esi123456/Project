package com.sefryek.brokerpro.dto.request;

import javax.validation.constraints.NotNull;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 12, Feb, 2017
 */
public class NaturalLegalRequest extends Request {
    
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
        return "PriceRequest{" +
                "symbolISIN='" + symbolISIN + '\'' +
                '}';
    }
}
