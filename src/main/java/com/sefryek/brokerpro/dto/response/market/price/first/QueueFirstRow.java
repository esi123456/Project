package com.sefryek.brokerpro.dto.response.market.price.first;

import java.math.BigDecimal;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 31, Dec, 2016
 */
public class QueueFirstRow {

    private BigDecimal bestBuyPrice;
    private BigDecimal bestSellPrice;
    private BigDecimal bestSellQuantity;
    private BigDecimal bestBuyQuantity;
    private Long noBestBuy;
    private Long noBestSell;
    private String nscCode;

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

    public BigDecimal getBestSellQuantity() {
        return bestSellQuantity;
    }

    public void setBestSellQuantity(BigDecimal bestSellQuantity) {
        this.bestSellQuantity = bestSellQuantity;
    }

    public BigDecimal getBestBuyQuantity() {
        return bestBuyQuantity;
    }

    public void setBestBuyQuantity(BigDecimal bestBuyQuantity) {
        this.bestBuyQuantity = bestBuyQuantity;
    }

    public Long getNoBestBuy() {
        return noBestBuy;
    }

    public void setNoBestBuy(Long noBestBuy) {
        this.noBestBuy = noBestBuy;
    }

    public Long getNoBestSell() {
        return noBestSell;
    }

    public void setNoBestSell(Long noBestSell) {
        this.noBestSell = noBestSell;
    }

    public String getNscCode() {
        return nscCode;
    }

    public void setNscCode(String nscCode) {
        this.nscCode = nscCode;
    }

    @Override
    public String toString() {
        return "QueueFirstRow{" +
                "bestBuyPrice=" + bestBuyPrice +
                ", bestSellPrice=" + bestSellPrice +
                ", bestSellQuantity=" + bestSellQuantity +
                ", bestBuyQuantity=" + bestBuyQuantity +
                ", noBestBuy=" + noBestBuy +
                ", noBestSell=" + noBestSell +
                ", nscCode='" + nscCode + '\'' +
                '}';
    }
}
