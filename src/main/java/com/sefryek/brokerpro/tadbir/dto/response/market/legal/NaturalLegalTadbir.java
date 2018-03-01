package com.sefryek.brokerpro.tadbir.dto.response.market.legal;

import com.fasterxml.jackson.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 12, Feb, 2017
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NaturalLegalTadbir {
    @JsonProperty("SymbolISIN")
    private String symbolISIN;
    @JsonProperty("SymbolFa")
    private String symbolShortNameFa;
    @JsonProperty("IndBuyVolume")
    private BigDecimal indBuyVolume;
    @JsonProperty("IndBuyNumber")
    private BigDecimal indBuyNumber;
    @JsonProperty("IndBuyValue")
    private BigDecimal indBuyValue;
    @JsonProperty("IndSellVolume")
    private BigDecimal indSellVolume;
    @JsonProperty("IndSellNumber")
    private BigDecimal indSellNumber;
    @JsonProperty("IndSellValue")
    private BigDecimal indSellValue;
    @JsonProperty("InsBuyVolume")
    private BigDecimal insBuyVolume;
    @JsonProperty("InsBuyNumber")
    private BigDecimal insBuyNumber;
    @JsonProperty("InsBuyValue")
    private BigDecimal insBuyValue;
    @JsonProperty("InsSellVolume")
    private BigDecimal insSellVolume;
    @JsonProperty("InsSellNumber")
    private BigDecimal insSellNumber;
    @JsonProperty("InsSellValue")
    private BigDecimal insSellValue;
    @JsonProperty("Date")
    private String dateTime; //todo change it to Date after Tadbir change.

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getSymbolISIN() {
        return symbolISIN;
    }

    public void setSymbolISIN(String symbolISIN) {
        this.symbolISIN = symbolISIN;
    }

    public String getSymbolShortNameFa() {
        return symbolShortNameFa;
    }

    public void setSymbolShortNameFa(String symbolShortNameFa) {
        this.symbolShortNameFa = symbolShortNameFa;
    }

    public BigDecimal getIndBuyVolume() {
        return indBuyVolume;
    }

    public void setIndBuyVolume(BigDecimal indBuyVolume) {
        this.indBuyVolume = indBuyVolume;
    }

    public BigDecimal getIndBuyNumber() {
        return indBuyNumber;
    }

    public void setIndBuyNumber(BigDecimal indBuyNumber) {
        this.indBuyNumber = indBuyNumber;
    }

    public BigDecimal getIndBuyValue() {
        return indBuyValue;
    }

    public void setIndBuyValue(BigDecimal indBuyValue) {
        this.indBuyValue = indBuyValue;
    }

    public BigDecimal getIndSellVolume() {
        return indSellVolume;
    }

    public void setIndSellVolume(BigDecimal indSellVolume) {
        this.indSellVolume = indSellVolume;
    }

    public BigDecimal getIndSellNumber() {
        return indSellNumber;
    }

    public void setIndSellNumber(BigDecimal indSellNumber) {
        this.indSellNumber = indSellNumber;
    }

    public BigDecimal getIndSellValue() {
        return indSellValue;
    }

    public void setIndSellValue(BigDecimal indSellValue) {
        this.indSellValue = indSellValue;
    }

    public BigDecimal getInsBuyVolume() {
        return insBuyVolume;
    }

    public void setInsBuyVolume(BigDecimal insBuyVolume) {
        this.insBuyVolume = insBuyVolume;
    }

    public BigDecimal getInsBuyNumber() {
        return insBuyNumber;
    }

    public void setInsBuyNumber(BigDecimal insBuyNumber) {
        this.insBuyNumber = insBuyNumber;
    }

    public BigDecimal getInsBuyValue() {
        return insBuyValue;
    }

    public void setInsBuyValue(BigDecimal insBuyValue) {
        this.insBuyValue = insBuyValue;
    }

    public BigDecimal getInsSellVolume() {
        return insSellVolume;
    }

    public void setInsSellVolume(BigDecimal insSellVolume) {
        this.insSellVolume = insSellVolume;
    }

    public BigDecimal getInsSellNumber() {
        return insSellNumber;
    }

    public void setInsSellNumber(BigDecimal insSellNumber) {
        this.insSellNumber = insSellNumber;
    }

    public BigDecimal getInsSellValue() {
        return insSellValue;
    }

    public void setInsSellValue(BigDecimal insSellValue) {
        this.insSellValue = insSellValue;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
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
        return "NaturalLegalTadbir{" +
                "symbolISIN='" + symbolISIN + '\'' +
                ", symbolShortNameFa='" + symbolShortNameFa + '\'' +
                ", indBuyVolume=" + indBuyVolume +
                ", indBuyNumber=" + indBuyNumber +
                ", indBuyValue=" + indBuyValue +
                ", indSellVolume=" + indSellVolume +
                ", indSellNumber=" + indSellNumber +
                ", indSellValue=" + indSellValue +
                ", insBuyVolume=" + insBuyVolume +
                ", insBuyNumber=" + insBuyNumber +
                ", insBuyValue=" + insBuyValue +
                ", insSellVolume=" + insSellVolume +
                ", insSellNumber=" + insSellNumber +
                ", insSellValue=" + insSellValue +
                ", dateTime='" + dateTime + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
