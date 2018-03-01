package com.sefryek.brokerpro.dto.response.market.watch;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 30, May, 2017
 */
public class MarketWatch {
    private Long positiveCount;
    private Long negativeCount;
    private Long unchangedCount;
    private MarketType marketType;

    public Long getPositiveCount() {
        return positiveCount;
    }

    public void setPositiveCount(Long positiveCount) {
        this.positiveCount = positiveCount;
    }

    public Long getNegativeCount() {
        return negativeCount;
    }

    public void setNegativeCount(Long negativeCount) {
        this.negativeCount = negativeCount;
    }

    public Long getUnchangedCount() {
        return unchangedCount;
    }

    public void setUnchangedCount(Long unchangedCount) {
        this.unchangedCount = unchangedCount;
    }

    public MarketType getMarketType() {
        return marketType;
    }

    public void setMarketType(MarketType marketType) {
        this.marketType = marketType;
    }

    @Override
    public String toString() {
        return "MarketWatch{" +
                "positiveCount=" + positiveCount +
                ", negativeCount=" + negativeCount +
                ", unchangedCount=" + unchangedCount +
                ", marketType=" + marketType +
                '}';
    }
}
