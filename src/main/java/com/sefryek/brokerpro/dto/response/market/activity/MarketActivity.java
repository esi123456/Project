package com.sefryek.brokerpro.dto.response.market.activity;

import com.sefryek.brokerpro.dto.request.market.activity.MarketActivityCode;

import java.math.BigDecimal;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 24, Dec, 2016
 */
public class MarketActivity {

    private MarketActivityCode marketCode;
    private String marketName;
    private Long totalNoTrade;
    private BigDecimal totalTradeValue;
    private Long totalNoSharesTraded;

    public MarketActivityCode getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(MarketActivityCode marketCode) {
        this.marketCode = marketCode;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public Long getTotalNoTrade() {
        return totalNoTrade;
    }

    public void setTotalNoTrade(Long totalNoTrade) {
        this.totalNoTrade = totalNoTrade;
    }

    public BigDecimal getTotalTradeValue() {
        return totalTradeValue;
    }

    public void setTotalTradeValue(BigDecimal totalTradeValue) {
        this.totalTradeValue = totalTradeValue;
    }

    public Long getTotalNoSharesTraded() {
        return totalNoSharesTraded;
    }

    public void setTotalNoSharesTraded(Long totalNoSharesTraded) {
        this.totalNoSharesTraded = totalNoSharesTraded;
    }

    @Override
    public String toString() {
        return "MarketActivity{" +
                "marketCode=" + marketCode +
                ", marketName='" + marketName + '\'' +
                ", totalNoTrade=" + totalNoTrade +
                ", totalTradeValue=" + totalTradeValue +
                ", totalNoSharesTraded=" + totalNoSharesTraded +
                '}';
    }
}
