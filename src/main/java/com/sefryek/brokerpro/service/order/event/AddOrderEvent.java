package com.sefryek.brokerpro.service.order.event;

import com.sefryek.brokerpro.dto.request.order.AddOrderRequest;

/**
 * Copyright 2016 (C) syspod.co
 *
 * @auther: Ashkan Haghighi Kia
 * @email: kia@syspod.co
 */

public class AddOrderEvent {
    private AddOrderRequest addOrder;
    private String token;

    public AddOrderEvent(AddOrderRequest addOrder, String token) {
        this.addOrder = addOrder;
        this.token = token;
    }

    public AddOrderRequest getAddOrder() {
        return addOrder;
    }

    public String getToken() {
        return token;
    }
}
