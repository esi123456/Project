package com.sefryek.brokerpro.dto.response.mobile.portfolio;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 22, Apr, 2017
 */
public class PortfolioRecords {

    private Long rowId;
    private Long count;
    private OrderSide orderSide;
    private BigDecimal totalCost;
    private Date dateTime;
    private String description;

    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public OrderSide getOrderSide() {
        return orderSide;
    }

    public void setOrderSide(OrderSide orderSide) {
        this.orderSide = orderSide;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PortfolioRecords{" +
                "rowId=" + rowId +
                ", count=" + count +
                ", orderSide=" + orderSide +
                ", totalCost=" + totalCost +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                '}';
    }
}
