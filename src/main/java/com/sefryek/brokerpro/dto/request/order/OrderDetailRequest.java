package com.sefryek.brokerpro.dto.request.order;

import com.sefryek.brokerpro.dto.request.Request;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 24, Sep, 2017
 */
public class OrderDetailRequest extends Request{
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderDetailRequest{" +
                "orderId=" + orderId +
                '}';
    }
}
