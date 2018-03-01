package com.sefryek.brokerpro.dto.response.mobile.portfolio.stock;

import com.sefryek.brokerpro.domain.Commission;
import com.sefryek.brokerpro.dto.response.market.price.first.PriceWithFirstQueue;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, Apr, 2017
 */
public class DailyCustomerStockPortfolio {
    private PriceWithFirstQueue priceWithFirstQueue;
    private Commission commissionDetail;
    private String symbolShortName;
    private String symbolISIN; //old = nscCode
    private Long totalQuantityBuy;  //old = totalQBuy
    private Long totalQuantitySell;  //old = totalQSell
    private Long newBuy;  //old = neBuy
    private Long newSell;  //old = neSell
    private Long averagePriceBuy;
    private Long averagePriceSell;
    private Long currentCount;
    private Long csdCount; // new

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

    public String getSymbolShortName() {
        return symbolShortName;
    }

    public void setSymbolShortName(String symbolShortName) {
        this.symbolShortName = symbolShortName;
    }

    public String getSymbolISIN() {
        return symbolISIN;
    }

    public void setSymbolISIN(String symbolISIN) {
        this.symbolISIN = symbolISIN;
    }

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

    public Long getCsdCount() {
        return csdCount;
    }

    public void setCsdCount(Long csdCount) {
        this.csdCount = csdCount;
    }

    @Override
    public String toString() {
        return "DailyCustomerStockPortfolio{" +
                "priceWithFirstQueue=" + priceWithFirstQueue +
                ", commission=" + commissionDetail +
                ", symbolShortName='" + symbolShortName + '\'' +
                ", symbolISIN='" + symbolISIN + '\'' +
                ", totalQuantityBuy=" + totalQuantityBuy +
                ", totalQuantitySell=" + totalQuantitySell +
                ", newBuy=" + newBuy +
                ", newSell=" + newSell +
                ", averagePriceBuy=" + averagePriceBuy +
                ", averagePriceSell=" + averagePriceSell +
                ", currentCount=" + currentCount +
                ", csdCount=" + csdCount +
                '}';
    }
}
