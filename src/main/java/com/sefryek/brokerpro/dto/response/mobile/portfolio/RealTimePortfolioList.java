package com.sefryek.brokerpro.dto.response.mobile.portfolio;

import com.sefryek.brokerpro.domain.Commission;
import com.sefryek.brokerpro.dto.response.market.price.first.PriceWithFirstQueue;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 15, Apr, 2017
 */
public class RealTimePortfolioList {

    private PriceWithFirstQueue priceWithFirstQueue;
    private Commission commissionDetail;
    private Date dateTime;
    private String symbolISIN;
    private Long remainQuantity;
    private BigDecimal totalBuyAverage;
    private BigDecimal totalCostBuy;
    private Long soldCount;
    private BigDecimal totalSold;
    private BigDecimal soldValueOfIncome;

    public PriceWithFirstQueue getPriceWithFirstQueue() {
        return priceWithFirstQueue;
    }

    public void setPriceWithFirstQueue(PriceWithFirstQueue priceWithFirstQueue) {
        this.priceWithFirstQueue = priceWithFirstQueue;
    }

    public Commission getCommissionDetail() {
        return commissionDetail;
    }

    public void setCommissionDetail(Commission commissionDetail) {
        this.commissionDetail = commissionDetail;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getSymbolISIN() {
        return symbolISIN;
    }

    public void setSymbolISIN(String symbolISIN) {
        this.symbolISIN = symbolISIN;
    }

    public Long getRemainQuantity() {
        return remainQuantity;
    }

    public void setRemainQuantity(Long remainQuantity) {
        this.remainQuantity = remainQuantity;
    }

    public BigDecimal getTotalBuyAverage() {
        return totalBuyAverage;
    }

    public void setTotalBuyAverage(BigDecimal totalBuyAverage) {
        this.totalBuyAverage = totalBuyAverage;
    }

    public BigDecimal getTotalCostBuy() {
        return totalCostBuy;
    }

    public void setTotalCostBuy(BigDecimal totalCostBuy) {
        this.totalCostBuy = totalCostBuy;
    }

    public Long getSoldCount() {
        return soldCount;
    }

    public void setSoldCount(Long soldCount) {
        this.soldCount = soldCount;
    }

    public BigDecimal getTotalSold() {
        return totalSold;
    }

    public void setTotalSold(BigDecimal totalSold) {
        this.totalSold = totalSold;
    }

    public BigDecimal getSoldValueOfIncome() {
        return soldValueOfIncome;
    }

    public void setSoldValueOfIncome(BigDecimal soldValueOfIncome) {
        this.soldValueOfIncome = soldValueOfIncome;
    }

    @Override
    public String toString() {
        return "RealTimePortfolioList{" +
                "priceWithFirstQueue=" + priceWithFirstQueue +
                ", commissionDetail=" + commissionDetail +
                ", dateTime=" + dateTime +
                ", symbolISIN='" + symbolISIN + '\'' +
                ", remainQuantity=" + remainQuantity +
                ", totalBuyAverage=" + totalBuyAverage +
                ", totalCostBuy=" + totalCostBuy +
                ", soldCount=" + soldCount +
                ", totalSold=" + totalSold +
                ", soldValueOfIncome=" + soldValueOfIncome +
                '}';
    }
}

