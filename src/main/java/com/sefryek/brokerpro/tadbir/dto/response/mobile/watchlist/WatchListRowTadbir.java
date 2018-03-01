package com.sefryek.brokerpro.tadbir.dto.response.mobile.watchlist;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 26, Feb, 2017
 */
public class WatchListRowTadbir {
    @JsonProperty("SymbolISIN")
    private String symbolISIN;
    @JsonProperty("SymbolFa")
    private String symbolFa;
    @JsonProperty("Note")
    private String note;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "WatchListRowTadbir{" +
                "symbolISIN='" + symbolISIN + '\'' +
                ", symbolFa='" + symbolFa + '\'' +
                ", note='" + note + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
