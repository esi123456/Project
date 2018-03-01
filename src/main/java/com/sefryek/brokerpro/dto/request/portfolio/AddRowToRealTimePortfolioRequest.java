package com.sefryek.brokerpro.dto.request.portfolio;

import com.sefryek.brokerpro.dto.request.Request;
import com.sefryek.brokerpro.dto.request.order.OrderSide6586;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 23, Apr, 2017
 */
public class AddRowToRealTimePortfolioRequest extends Request{

    private String symbolISIN;
    private OrderSide6586 orderSide;
    private Date dateTime;
    private BigDecimal totalCost;
    private Long count;
    private String description;

    public String getSymbolISIN() {
        return symbolISIN;
    }

    public void setSymbolISIN(String symbolISIN) {
        this.symbolISIN = symbolISIN;
    }

    public OrderSide6586 getOrderSide() {
        return orderSide;
    }

    public void setOrderSide(OrderSide6586 orderSide) {
        this.orderSide = orderSide;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AddRowToRealTimePortfolioRequest{" +
                "symbolISIN='" + symbolISIN + '\'' +
                ", orderSide=" + orderSide +
                ", dateTime=" + dateTime +
                ", totalCost=" + totalCost +
                ", count=" + count +
                ", description='" + description + '\'' +
                '}';
    }

}
