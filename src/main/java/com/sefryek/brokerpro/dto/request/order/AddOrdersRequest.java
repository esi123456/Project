package com.sefryek.brokerpro.dto.request.order;

import com.sefryek.brokerpro.dto.request.Request;

import javax.validation.constraints.NotNull;
import java.util.List;

/*
 * Copyright 2016 (C) syspod.co
 *
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */
public class AddOrdersRequest extends Request {

    @NotNull
    private List<AddOrderRequest> addOrders;

    public List<AddOrderRequest> getAddOrders() {
        return addOrders;
    }

    public void setAddOrders(List<AddOrderRequest> addOrders) {
        this.addOrders = addOrders;
    }

    @Override
    public String toString() {
        return "AddOrdersRequest{" +
                "addOrders=" + addOrders +
                "} ";
    }
}
