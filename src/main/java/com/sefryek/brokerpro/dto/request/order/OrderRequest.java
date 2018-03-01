package com.sefryek.brokerpro.dto.request.order;

import com.sefryek.brokerpro.dto.request.Request;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/*
 * Copyright 2016 (C) syspod.co
 *
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */
public abstract class OrderRequest extends Request {

    @NotNull
    private String symbolISIN ;  // old= isinCode
    private Integer maxShown;
    private Integer minimumQuantity;
    @NotNull
    private BigDecimal price;
    @NotNull
    private OrderSide6586 orderSide;
    @NotNull
    private Integer totalQuantity;
    @NotNull
    private OrderValidityRequest validity;
    private Date validityDate;
    private Integer financialId;

    public String getSymbolISIN() {
        return symbolISIN;
    }

    public void setSymbolISIN(String symbolISIN) {
        this.symbolISIN = symbolISIN;
    }

    public Integer getMaxShown() {
        return maxShown;
    }

    public void setMaxShown(Integer maxShown) {
        this.maxShown = maxShown;
    }

    public Integer getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(Integer minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public OrderSide6586 getOrderSide() {
        return orderSide;
    }

    public void setOrderSide(OrderSide6586 orderSide) {
        this.orderSide = orderSide;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public OrderValidityRequest getValidity() {
        return validity;
    }

    public void setValidity(OrderValidityRequest validity) {
        this.validity = validity;
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }

    public Integer getFinancialId() {
        return financialId;
    }

    public void setFinancialId(Integer financialId) {
        this.financialId = financialId;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "symbolISIN='" + symbolISIN + '\'' +
                ", maxShown=" + maxShown +
                ", minimumQuantity=" + minimumQuantity +
                ", price=" + price +
                ", orderSide=" + orderSide +
                ", totalQuantity=" + totalQuantity +
                ", validity=" + validity +
                ", validityDate=" + validityDate +
                ", financialId=" + financialId +
                "} ";
    }
}
