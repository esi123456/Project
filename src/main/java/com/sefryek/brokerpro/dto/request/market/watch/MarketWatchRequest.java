package com.sefryek.brokerpro.dto.request.market.watch;

import com.sefryek.brokerpro.dto.request.Request;
import com.sefryek.brokerpro.dto.response.market.watch.MarketType;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 12, Jun, 2017
 */
public class MarketWatchRequest extends Request {
    private MarketType marketType;

    public MarketType getMarketType() {
        return marketType;
    }

    public void setMarketType(MarketType marketType) {
        this.marketType = marketType;
    }

    @Override
    public String toString() {
        return "MarketWatchRequest{" +
                "marketType=" + marketType +
                '}';
    }
}