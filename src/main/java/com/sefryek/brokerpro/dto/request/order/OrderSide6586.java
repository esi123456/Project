package com.sefryek.brokerpro.dto.request.order;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sefryek.util.StringUtils;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum OrderSide6586 {
    NONE("None"),
    BUY("65"),
    SELL("86");

    private String value;

    OrderSide6586(String value) {
        this.value = value;
    }

    @JsonCreator
    public static OrderSide6586 fromString(String key) {
        if (StringUtils.isEmpty(key)) {
            return NONE;
        }
        for (OrderSide6586 orderSide6586 : OrderSide6586.values()) {
            //for response from Tadbir
            if (orderSide6586.value.equalsIgnoreCase(key)) {
                return orderSide6586;
            }
            //for request to Tadbir
            if (orderSide6586.name().equalsIgnoreCase(key)) {
                return orderSide6586;
            }
        }
        return NONE;
    }

    public String getValue() {
        return value;
    }
}
