package com.sefryek.brokerpro.dto.response.market.time;

import java.util.Date;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 11, Feb, 2017
 */
public class MarketTime {
    private Date marketTime;

    public Date getMarketTime() {
        return marketTime;
    }

    public void setMarketTime(Date marketTime) {
        this.marketTime = marketTime;
    }

    @Override
    public String toString() {
        return "MarketTime{" +
                "marketTime=" + marketTime +
                '}';
    }
}
