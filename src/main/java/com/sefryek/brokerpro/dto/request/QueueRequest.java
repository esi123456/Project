package com.sefryek.brokerpro.dto.request;

import javax.validation.constraints.NotNull;

/**
 * Created by amin.malekpour on 2016-12-13.
 */
public class QueueRequest extends Request {

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
