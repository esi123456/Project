package com.sefryek.brokerpro.tadbir.dto.response.mobile.order;

import com.fasterxml.jackson.annotation.*;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirPageableResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 06, Feb, 2017
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdersListTadbir extends TadbirPageableResponse {

    @JsonProperty("List")
    private List<OrderTadbir> orderList;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<OrderTadbir> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderTadbir> orderList) {
        this.orderList = orderList;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "OrdersListTadbir{" +
                "orderList=" + orderList +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}