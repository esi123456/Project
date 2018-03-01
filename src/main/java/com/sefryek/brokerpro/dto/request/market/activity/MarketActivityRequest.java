package com.sefryek.brokerpro.dto.request.market.activity;

import com.sefryek.brokerpro.dto.request.Request;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 21, Oct, 2017
 */
public class MarketActivityRequest extends Request{
    private MarketActivityCode marketCode;

    public MarketActivityCode getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(MarketActivityCode marketCode) {
        this.marketCode = marketCode;
    }

    @Override
    public String toString() {
        return "MarketActivityRequest{" +
                "marketCode=" + marketCode +
                '}';
    }
}
