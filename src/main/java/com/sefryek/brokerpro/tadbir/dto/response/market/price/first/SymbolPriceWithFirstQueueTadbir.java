package com.sefryek.brokerpro.tadbir.dto.response.market.price.first;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirPageableResponse;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 31, Dec, 2016
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SymbolPriceWithFirstQueueTadbir extends TadbirPageableResponse {

    @JsonProperty("List")
    private PriceWithFirstQueueTadbir priceWithFirstQueueTadbir;

    public PriceWithFirstQueueTadbir getPriceWithFirstQueueTadbir() {
        return priceWithFirstQueueTadbir;
    }

    public void setPriceWithFirstQueueTadbir(PriceWithFirstQueueTadbir priceWithFirstQueueTadbir) {
        this.priceWithFirstQueueTadbir = priceWithFirstQueueTadbir;
    }

    @Override
    public String toString() {
        return "SymbolPriceWithFirstQueueTadbir{" +
                "priceWithFirstQueueTadbir=" + priceWithFirstQueueTadbir +
                "} " + super.toString();
    }
}
