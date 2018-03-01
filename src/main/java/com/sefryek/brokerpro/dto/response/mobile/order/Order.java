package com.sefryek.brokerpro.dto.response.mobile.order;

import com.sefryek.brokerpro.dto.response.mobile.order.enumeration.OrderForm;
import com.sefryek.brokerpro.dto.response.mobile.order.enumeration.OrderMarketType;
import com.sefryek.brokerpro.dto.response.mobile.portfolio.OrderSide;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 28, Jan, 2017
 */
public class Order {
    private Integer financialId;
    private String financialName;
    private Long parentId;
    private String customerISIN;
    private String symbolISIN ;
    private String symbolShortName;
    private Integer executedAmount;
    private Long orderId;
    private Date orderEntryDate;
    private BigDecimal orderPrice;
    private Integer minimumQuantity;
    private OrderSide orderSide;
    private OrderState orderState;
    private Integer orderTotalQuantity;
    private OrderValidity orderValidity;
    private Date orderValidityDate;
    private String userName;
    private Integer maxShown;
    private Long hostOrderId;
    private OrderMarketType marketType;
    private OrderForm orderForm;
    private String errorCode;

    public Integer getFinancialId() {
        return financialId;
    }

    public void setFinancialId(Integer financialId) {
        this.financialId = financialId;
    }

    public String getFinancialName() {
        return financialName;
    }

    public void setFinancialName(String financialName) {
        this.financialName = financialName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getCustomerISIN() {
        return customerISIN;
    }

    public void setCustomerISIN(String customerISIN) {
        this.customerISIN = customerISIN;
    }

    public String getSymbolISIN() {
        return symbolISIN;
    }

    public void setSymbolISIN(String symbolISIN) {
        this.symbolISIN = symbolISIN;
    }

    public String getSymbolShortName() {
        return symbolShortName;
    }

    public void setSymbolShortName(String symbolShortName) {
        this.symbolShortName = symbolShortName;
    }

    public Integer getExecutedAmount() {
        return executedAmount;
    }

    public void setExecutedAmount(Integer executedAmount) {
        this.executedAmount = executedAmount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderEntryDate() {
        return orderEntryDate;
    }

    public void setOrderEntryDate(Date orderEntryDate) {
        this.orderEntryDate = orderEntryDate;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(Integer minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public OrderSide getOrderSide() {
        return orderSide;
    }

    public void setOrderSide(OrderSide orderSide) {
        this.orderSide = orderSide;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public Integer getOrderTotalQuantity() {
        return orderTotalQuantity;
    }

    public void setOrderTotalQuantity(Integer orderTotalQuantity) {
        this.orderTotalQuantity = orderTotalQuantity;
    }

    public OrderValidity getOrderValidity() {
        return orderValidity;
    }

    public void setOrderValidity(OrderValidity orderValidity) {
        this.orderValidity = orderValidity;
    }

    public Date getOrderValidityDate() {
        return orderValidityDate;
    }

    public void setOrderValidityDate(Date orderValidityDate) {
        this.orderValidityDate = orderValidityDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getMaxShown() {
        return maxShown;
    }

    public void setMaxShown(Integer maxShown) {
        this.maxShown = maxShown;
    }

    public Long getHostOrderId() {
        return hostOrderId;
    }

    public void setHostOrderId(Long hostOrderId) {
        this.hostOrderId = hostOrderId;
    }

    public OrderMarketType getMarketType() {
        return marketType;
    }

    public void setMarketType(OrderMarketType marketType) {
        this.marketType = marketType;
    }

    public OrderForm getOrderForm() {
        return orderForm;
    }

    public void setOrderForm(OrderForm orderForm) {
        this.orderForm = orderForm;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "Order{" +
                "financialId=" + financialId +
                ", financialName='" + financialName + '\'' +
                ", parentId=" + parentId +
                ", customerISIN='" + customerISIN + '\'' +
                ", symbolISIN='" + symbolISIN + '\'' +
                ", symbolShortName='" + symbolShortName + '\'' +
                ", executedAmount=" + executedAmount +
                ", orderId=" + orderId +
                ", orderEntryDate=" + orderEntryDate +
                ", orderPrice=" + orderPrice +
                ", minimumQuantity=" + minimumQuantity +
                ", orderSide=" + orderSide +
                ", orderState=" + orderState +
                ", orderTotalQuantity=" + orderTotalQuantity +
                ", orderValidity=" + orderValidity +
                ", orderValidityDate=" + orderValidityDate +
                ", userName='" + userName + '\'' +
                ", maxShown=" + maxShown +
                ", hostOrderId=" + hostOrderId +
                ", marketType=" + marketType +
                ", orderForm=" + orderForm +
                ", errorCode='" + errorCode + '\'' +
                '}';
    }
}
