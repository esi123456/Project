package com.sefryek.brokerpro.dto.request.order;

import com.sefryek.brokerpro.dto.request.Request;

import javax.validation.constraints.NotNull;

/*
 * Copyright 2016 (C) syspod.co
 *
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */
public class CancelOrderRequest extends Request {

    @NotNull
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "CancelOrderRequest{" +
                "orderId=" + orderId +
                '}';
    }
}
