package com.sefryek.brokerpro.tadbir.dto.response.market.watch;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirResponse;

import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 30, May, 2017
 */
public class MarketWatchResponseTadbir extends TadbirResponse {
    @JsonProperty("MarketWatches")
    private List<MarketWatchTadbir> marketWatchList;

    public List<MarketWatchTadbir> getMarketWatchList() {
        return marketWatchList;
    }

    public void setMarketWatchList(List<MarketWatchTadbir> marketWatchList) {
        this.marketWatchList = marketWatchList;
    }

    @Override
    public String toString() {
        return "MarketWatchResponseTadbir{" +
                "marketWatchList=" + marketWatchList +
                "} " + super.toString();
    }
}
