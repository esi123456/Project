package com.sefryek.brokerpro.dto.response.mobile.portfolio;

import java.math.BigDecimal;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 07, Jan, 2017
 */
public class PortfolioWithDetail extends Portfolio{
    private BigDecimal bestBuyPrice;
    private BigDecimal bestSellPrice;
    private BigDecimal lastTradedPrice;
    private BigDecimal lastTradedPricePercent;
    private BigDecimal closingPrice;
    private BigDecimal closingPricePercent;
    private BigDecimal refPrice;

    public BigDecimal getBestBuyPrice() {
        return bestBuyPrice;
    }

    public void setBestBuyPrice(BigDecimal bestBuyPrice) {
        this.bestBuyPrice = bestBuyPrice;
    }

    public BigDecimal getBestSellPrice() {
        return bestSellPrice;
    }

    public void setBestSellPrice(BigDecimal bestSellPrice) {
        this.bestSellPrice = bestSellPrice;
    }

    public BigDecimal getLastTradedPrice() {
        return lastTradedPrice;
    }

    public void setLastTradedPrice(BigDecimal lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
    }

    public BigDecimal getLastTradedPricePercent() {
        return lastTradedPricePercent;
    }

    public void setLastTradedPricePercent(BigDecimal lastTradedPricePercent) {
        this.lastTradedPricePercent = lastTradedPricePercent;
    }

    public BigDecimal getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(BigDecimal closingPrice) {
        this.closingPrice = closingPrice;
    }

    public BigDecimal getClosingPricePercent() {
        return closingPricePercent;
    }

    public void setClosingPricePercent(BigDecimal closingPricePercent) {
        this.closingPricePercent = closingPricePercent;
    }

    public BigDecimal getRefPrice() {
        return refPrice;
    }

    public void setRefPrice(BigDecimal refPrice) {
        this.refPrice = refPrice;
    }

    @Override
    public String toString() {
        return "PortfolioWithDetail{" +
                "bestBuyPrice=" + bestBuyPrice +
                ", bestSellPrice=" + bestSellPrice +
                ", lastTradedPrice=" + lastTradedPrice +
                ", lastTradedPricePercent=" + lastTradedPricePercent +
                ", closingPrice=" + closingPrice +
                ", closingPricePercent=" + closingPricePercent +
                ", refPrice=" + refPrice +
                '}';
    }
}
