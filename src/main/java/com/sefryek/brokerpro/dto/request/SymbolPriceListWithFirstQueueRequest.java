package com.sefryek.brokerpro.dto.request;

import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 06, Mar, 2017
 */
public class SymbolPriceListWithFirstQueueRequest extends Request{
    private List<String> symbolsISIN;

    public List<String> getSymbolsISIN() {
        return symbolsISIN;
    }

    public void setSymbolsISIN(List<String> symbolsISIN) {
        this.symbolsISIN = symbolsISIN;
    }

    @Override
    public String toString() {
        return "SymbolPriceListWithFirstQueueRequest{" +
                "symbolsISIN=" + symbolsISIN +
                '}';
    }

}
