package com.sefryek.brokerpro.tadbir.dto.response.mobile.portfolio.stock;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sefryek.brokerpro.config.jackson.DateFilterTadbir;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 19, Apr, 2017
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PortfoliosTadbir {
    @JsonDeserialize(using = DateFilterTadbir.class)
    @JsonProperty("DateTime")
    private Date dateTime;
    @JsonProperty("SymbolISIN")
    private String symbolISIN;
    @JsonProperty("RemainQuantity")
    private Long remainQuantity;
    @JsonProperty("TotalBuyAverage")
    private BigDecimal totalBuyAverage;
    @JsonProperty("TotalCostBuy")
    private BigDecimal totalCostBuy;
    @JsonProperty("SoldCount")
    private Long soldCount;
    @JsonProperty("TotalSold")
    private BigDecimal totalSold;
    @JsonProperty("SoldValueofIncome")
    private BigDecimal soldValueOfIncome;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("DateTime")
    public Date getDateTime() {
        return dateTime;
    }

    @JsonProperty("DateTime")
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @JsonProperty("NSCCode")
    public String getSymbolISIN() {
        return symbolISIN;
    }

    @JsonProperty("NSCCode")
    public void setSymbolISIN(String symbolISIN) {
        this.symbolISIN = symbolISIN;
    }

    @JsonProperty("RemainQuantity")
    public Long getRemainQuantity() {
        return remainQuantity;
    }

    @JsonProperty("RemainQuantity")
    public void setRemainQuantity(Long remainQuantity) {
        this.remainQuantity = remainQuantity;
    }

    @JsonProperty("TotalBuyAverage")
    public BigDecimal getTotalBuyAverage() {
        return totalBuyAverage;
    }

    @JsonProperty("TotalBuyAverage")
    public void setTotalBuyAverage(BigDecimal totalBuyAverage) {
        this.totalBuyAverage = totalBuyAverage;
    }

    @JsonProperty("TotalCostBuy")
    public BigDecimal getTotalCostBuy() {
        return totalCostBuy;
    }

    @JsonProperty("TotalCostBuy")
    public void setTotalCostBuy(BigDecimal totalCostBuy) {
        this.totalCostBuy = totalCostBuy;
    }

    @JsonProperty("SoldCount")
    public Long getSoldCount() {
        return soldCount;
    }

    @JsonProperty("SoldCount")
    public void setSoldCount(Long soldCount) {
        this.soldCount = soldCount;
    }

    @JsonProperty("TotalSold")
    public BigDecimal getTotalSold() {
        return totalSold;
    }

    @JsonProperty("TotalSold")
    public void setTotalSold(BigDecimal totalSold) {
        this.totalSold = totalSold;
    }

    @JsonProperty("SoldValueofIncome")
    public BigDecimal getSoldValueOfIncome() {
        return soldValueOfIncome;
    }

    @JsonProperty("SoldValueofIncome")
    public void setSoldValueOfIncome(BigDecimal soldValueOfIncome) {
        this.soldValueOfIncome = soldValueOfIncome;
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
        return "PortfoliosTadbir{" +
                "dateTime=" + dateTime +
                ", symbolISIN='" + symbolISIN + '\'' +
                ", remainQuantity=" + remainQuantity +
                ", totalBuyAverage=" + totalBuyAverage +
                ", totalCostBuy=" + totalCostBuy +
                ", soldCount=" + soldCount +
                ", totalSold=" + totalSold +
                ", soldValueOfIncome=" + soldValueOfIncome +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
