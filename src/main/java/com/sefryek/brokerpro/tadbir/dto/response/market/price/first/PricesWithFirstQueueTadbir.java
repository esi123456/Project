package com.sefryek.brokerpro.tadbir.dto.response.market.price.first;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirPageableResponse;

import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 07, Mar, 2017
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PricesWithFirstQueueTadbir extends TadbirPageableResponse {

    @JsonProperty("List")
    private List<PriceWithFirstQueueTadbir> priceListWithFirstQueueTadbir;

    public List<PriceWithFirstQueueTadbir> getPriceListWithFirstQueueTadbir() {
        return priceListWithFirstQueueTadbir;
    }

    public void setPriceListWithFirstQueueTadbir(List<PriceWithFirstQueueTadbir> priceListWithFirstQueueTadbir) {
        this.priceListWithFirstQueueTadbir = priceListWithFirstQueueTadbir;
    }

    @Override
    public String toString() {
        return "PricesWithFirstQueueTadbir{" +
                "priceListWithFirstQueueTadbir=" + priceListWithFirstQueueTadbir +
                "} " + super.toString();
    }
}
