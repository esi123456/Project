package com.sefryek.brokerpro.dto.request.alert;

import com.sefryek.brokerpro.tadbir.dto.response.mobile.order.OrderValidity;

import java.util.Date;
import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 30, Apr, 2017
 */
public class ConditionalOrder {
    private Date orderValidityDateTime;
    private OrderValidity orderValidityValue;
    private List<OrderContract> orderContract;

    public Date getOrderValidityDateTime() {
        return orderValidityDateTime;
    }

    public void setOrderValidityDateTime(Date orderValidityDateTime) {
        this.orderValidityDateTime = orderValidityDateTime;
    }

    public OrderValidity getOrderValidityValue() {
        return orderValidityValue;
    }

    public void setOrderValidityValue(OrderValidity orderValidityValue) {
        this.orderValidityValue = orderValidityValue;
    }

    public List<OrderContract> getOrderContract() {
        return orderContract;
    }

    public void setOrderContract(List<OrderContract> orderContract) {
        this.orderContract = orderContract;
    }

    @Override
    public String toString() {
        return "ConditionalOrder{" +
                "orderValidityDateTime=" + orderValidityDateTime +
                ", orderValidityValue=" + orderValidityValue +
                ", orderContract=" + orderContract +
                '}';
    }
}
