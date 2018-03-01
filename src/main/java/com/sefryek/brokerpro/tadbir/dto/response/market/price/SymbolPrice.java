package com.sefryek.brokerpro.tadbir.dto.response.market.price;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirResponse;

/**
 * Created by amin.malekpour on 2016-12-13.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Price",
        "IsSuccessful",
        "ErrorCode",
        "ErrorDescription"
})
public class SymbolPrice extends TadbirResponse {

    @JsonProperty("Price")
    private Price price;

    /**
     * @return The price
     */
    @JsonProperty("Price")
    public Price getPrice() {
        return price;
    }

    /**
     * @param price The Price
     */
    @JsonProperty("Price")
    public void setPrice(Price price) {
        this.price = price;
    }

}
