package com.sefryek.brokerpro.dto.response.mobile.order;

/**
 * Copyright 2016 (C) syspod.co
 * <p>
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */
public class AddOrModifyOrder {

    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "AddOrModifyOrder{" +
                "orderId=" + orderId +
                '}';
    }
}
