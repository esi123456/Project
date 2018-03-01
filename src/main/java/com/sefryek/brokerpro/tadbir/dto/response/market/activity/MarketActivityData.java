package com.sefryek.brokerpro.tadbir.dto.response.market.activity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirResponse;

import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 25, Dec, 2016
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MarketActivityData extends TadbirResponse {

    @JsonProperty("Activity")
    private List<MarketActivityTAdbir> marketActivity;

    public List<MarketActivityTAdbir> getMarketActivity() {
        return marketActivity;
    }

    public void setMarketActivity(List<MarketActivityTAdbir> marketActivity) {
        this.marketActivity = marketActivity;
    }

    @Override
    public String toString() {
        return "MarketActivityData{" +
                "marketActivity=" + marketActivity +
                '}';
    }
}