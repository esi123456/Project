package com.sefryek.brokerpro.tadbir.dto.response.mobile.portfolio.stock;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, Apr, 2017
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerStockPortfolioTadbir {
    @JsonProperty("TotalQuantityBuy")
    private Long totalQuantityBuy;
    @JsonProperty("TotalQuantitySell")
    private Long totalQuantitySell;
    @JsonProperty("NewBuy")
    private Long newBuy;
    @JsonProperty("NewSell")
    private Long newSell;
    @JsonProperty("AverageBuyPrice")
    private Long averagePriceBuy;
    @JsonProperty("AverageSellPrice")
    private Long averagePriceSell;
    @JsonProperty("CurrentCount")
    private Long currentCount;
    @JsonProperty("EnSymbol")
    private String enSymbol;
    @JsonProperty("Symbol")
    private String symbol;
    @JsonProperty("CSDCount")
    private Long csdCount;
    @JsonProperty("SymbolISIN")
    private String symbolISIN;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Long getTotalQuantityBuy() {
        return totalQuantityBuy;
    }

    public void setTotalQuantityBuy(Long totalQuantityBuy) {
        this.totalQuantityBuy = totalQuantityBuy;
    }

    public Long getTotalQuantitySell() {
        return totalQuantitySell;
    }

    public void setTotalQuantitySell(Long totalQuantitySell) {
        this.totalQuantitySell = totalQuantitySell;
    }

    public Long getNewBuy() {
        return newBuy;
    }

    public void setNewBuy(Long newBuy) {
        this.newBuy = newBuy;
    }

    public Long getNewSell() {
        return newSell;
    }

    public void setNewSell(Long newSell) {
        this.newSell = newSell;
    }

    public Long getAveragePriceBuy() {
        return averagePriceBuy;
    }

    public void setAveragePriceBuy(Long averagePriceBuy) {
        this.averagePriceBuy = averagePriceBuy;
    }

    public Long getAveragePriceSell() {
        return averagePriceSell;
    }

    public void setAveragePriceSell(Long averagePriceSell) {
        this.averagePriceSell = averagePriceSell;
    }

    public Long getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(Long currentCount) {
        this.currentCount = currentCount;
    }

    public String getEnSymbol() {
        return enSymbol;
    }

    public void setEnSymbol(String enSymbol) {
        this.enSymbol = enSymbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Long getCsdCount() {
        return csdCount;
    }

    public void setCsdCount(Long csdCount) {
        this.csdCount = csdCount;
    }

    public String getSymbolISIN() {
        return symbolISIN;
    }

    public void setSymbolISIN(String symbolISIN) {
        this.symbolISIN = symbolISIN;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public String toString() {
        return "CustomerStockPortfolioTadbir{" +
                "totalQuantityBuy=" + totalQuantityBuy +
                ", totalQuantitySell=" + totalQuantitySell +
                ", newBuy=" + newBuy +
                ", newSell=" + newSell +
                ", averagePriceBuy=" + averagePriceBuy +
                ", averagePriceSell=" + averagePriceSell +
                ", currentCount=" + currentCount +
                ", enSymbol='" + enSymbol + '\'' +
                ", symbol='" + symbol + '\'' +
                ", csdCount=" + csdCount +
                ", symbolISIN='" + symbolISIN + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
