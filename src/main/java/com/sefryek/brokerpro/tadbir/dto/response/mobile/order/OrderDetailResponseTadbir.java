package com.sefryek.brokerpro.tadbir.dto.response.mobile.order;

import com.fasterxml.jackson.annotation.*;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 24, Sep, 2017
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDetailResponseTadbir extends TadbirResponse {

    @JsonProperty("List")
    private List<OrderDetailTadbir> orderDetail;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<OrderDetailTadbir> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetailTadbir> orderDetail) {
        this.orderDetail = orderDetail;
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
        return "OrderDetailResponseTadbir{" +
                "orderDetail=" + orderDetail +
                ", additionalProperties=" + additionalProperties +
                "} " + super.toString();
    }
}
