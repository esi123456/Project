package com.sefryek.brokerpro.dto.response.market.queue;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 14, Dec, 2016
 */

public class Queue {

    private Long bestBuyPrice;
    private Long bestSellPrice;
    private Long bestSellQuantity;
    private Long bestBuyQuantity;
    private Long noBestBuy;
    private Long noBestSell;

    public Long getBestBuyPrice() {
        return bestBuyPrice;
    }

    public void setBestBuyPrice(Long bestBuyPrice) {
        this.bestBuyPrice = bestBuyPrice;
    }

    public Long getBestSellPrice() {
        return bestSellPrice;
    }

    public void setBestSellPrice(Long bestSellPrice) {
        this.bestSellPrice = bestSellPrice;
    }

    public Long getBestSellQuantity() {
        return bestSellQuantity;
    }

    public void setBestSellQuantity(Long bestSellQuantity) {
        this.bestSellQuantity = bestSellQuantity;
    }

    public Long getBestBuyQuantity() {
        return bestBuyQuantity;
    }

    public void setBestBuyQuantity(Long bestBuyQuantity) {
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

    @Override
    public String toString() {
        return "Queue{" +
                "bestBuyPrice=" + bestBuyPrice +
                ", bestSellPrice=" + bestSellPrice +
                ", bestSellQuantity=" + bestSellQuantity +
                ", bestBuyQuantity=" + bestBuyQuantity +
                ", noBestBuy=" + noBestBuy +
                ", noBestSell=" + noBestSell +
                '}';
    }
}
