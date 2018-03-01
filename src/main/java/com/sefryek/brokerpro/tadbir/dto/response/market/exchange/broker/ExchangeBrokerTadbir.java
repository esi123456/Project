package com.sefryek.brokerpro.tadbir.dto.response.market.exchange.broker;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirPageableResponse;

import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 11, Nov, 2017
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExchangeBrokerTadbir extends TadbirPageableResponse {

    @JsonProperty("List")
    private List<ExchangeBrokerDataTadbir> exchangeBrokerData = null;

    public List<ExchangeBrokerDataTadbir> getExchangeBrokerData() {
        return exchangeBrokerData;
    }

    public void setExchangeBrokerData(List<ExchangeBrokerDataTadbir> exchangeBrokerData) {
        this.exchangeBrokerData = exchangeBrokerData;
    }

    @Override
    public String toString() {
        return "ExchangeBrokerTadbir{" +
                "exchangeBrokerData=" + exchangeBrokerData +
                '}';
    }
}
