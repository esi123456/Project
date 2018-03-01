package com.sefryek.brokerpro.dto.request.alert;


import com.sefryek.brokerpro.dto.request.order.OrderSide6586;

import java.math.BigDecimal;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 30, Apr, 2017
 */
public class OrderContract {
    private Long financialId;
    private Long maxShown;
    private Long minimumQuantity;
    private BigDecimal orderPrice;
    private OrderSide6586 orderSide;
    private Long orderTotalQuantity;
    private String nSCCode;

    public Long getFinancialId() {
        return financialId;
    }

    public void setFinancialId(Long financialId) {
        this.financialId = financialId;
    }

    public Long getMaxShown() {
        return maxShown;
    }

    public void setMaxShown(Long maxShown) {
        this.maxShown = maxShown;
    }

    public Long getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(Long minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public OrderSide6586 getOrderSide() {
        return orderSide;
    }

    public void setOrderSide(OrderSide6586 orderSide) {
        this.orderSide = orderSide;
    }

    public Long getOrderTotalQuantity() {
        return orderTotalQuantity;
    }

    public void setOrderTotalQuantity(Long orderTotalQuantity) {
        this.orderTotalQuantity = orderTotalQuantity;
    }

    public String getnSCCode() {
        return nSCCode;
    }

    public void setnSCCode(String nSCCode) {
        this.nSCCode = nSCCode;
    }

    @Override
    public String toString() {
        return "OrderContract{" +
                "financialId=" + financialId +
                ", maxShown=" + maxShown +
                ", minimumQuantity=" + minimumQuantity +
                ", orderPrice=" + orderPrice +
                ", orderSide=" + orderSide +
                ", orderTotalQuantity=" + orderTotalQuantity +
                ", nSCCode='" + nSCCode + '\'' +
                '}';
    }
}
