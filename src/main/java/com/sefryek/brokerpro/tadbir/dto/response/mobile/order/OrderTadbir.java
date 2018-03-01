package com.sefryek.brokerpro.tadbir.dto.response.mobile.order;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sefryek.brokerpro.config.jackson.DateFilterTadbir;
import com.sefryek.brokerpro.dto.request.order.OrderSide6586;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.order.enumeration.OrderFormTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.order.enumeration.OrderMarketTypeTadbir;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 06, Feb, 2017
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderTadbir {
    @JsonProperty("FinancialProvider")
    private Integer financialId;
    @JsonProperty("ParentId")
    private Long parentId;
    @JsonProperty("UserName")
    private String userName;
    @JsonProperty("SymbolISIN")
    private String symbolISIN;
    @JsonProperty("Symbol")
    private String symbol;
    @JsonProperty("EnSymbol")
    private String enSymbol;
    @JsonProperty("CustomerISIN")
    private String customerISIN;
    @JsonProperty("ExcutedAmount")
    private Integer executedAmount;
    @JsonProperty("OrderId")
    private Long orderId;
    @JsonProperty("MaximumQuantity")
    private Integer maximumQuantity;
    @JsonProperty("HiddenOrder")
    private Integer maxShown;
    @JsonProperty("OrderState")
    private OrderState orderState;
    @JsonProperty("MinimumQuantity")
    private Integer minimumQuantity;
    @JsonDeserialize(using = DateFilterTadbir.class)
    @JsonProperty("OrderEntryDate")
    private Date orderEntryDate;
    @JsonProperty("OrderPrice")
    private BigDecimal orderPrice;
    @JsonProperty("OrderSide")
    private OrderSide6586 orderSide;
    @JsonProperty("OrderTotalQuantity")
    private Integer orderTotalQuantity;
    @JsonProperty("OrderValidity")
    private OrderValidity orderValidity;
    @JsonDeserialize(using = DateFilterTadbir.class)
    @JsonProperty("OrderValidityDate")
    private Date orderValidityDate;
    @JsonProperty("HostOrderId")
    private Long hostOrderId;
    @JsonProperty("MarketType")
    private OrderMarketTypeTadbir marketType;
    @JsonProperty("OrderFrom")
    private OrderFormTadbir orderForm;
    @JsonProperty("ErrorCode")
    private String errorCode;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getFinancialId() {
        return financialId;
    }

    public void setFinancialId(Integer financialId) {
        this.financialId = financialId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSymbolISIN() {
        return symbolISIN;
    }

    public void setSymbolISIN(String symbolISIN) {
        this.symbolISIN = symbolISIN;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getEnSymbol() {
        return enSymbol;
    }

    public void setEnSymbol(String enSymbol) {
        this.enSymbol = enSymbol;
    }

    public String getCustomerISIN() {
        return customerISIN;
    }

    public void setCustomerISIN(String customerISIN) {
        this.customerISIN = customerISIN;
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

    public Integer getMaximumQuantity() {
        return maximumQuantity;
    }

    public void setMaximumQuantity(Integer maximumQuantity) {
        this.maximumQuantity = maximumQuantity;
    }

    public Integer getMaxShown() {
        return maxShown;
    }

    public void setMaxShown(Integer maxShown) {
        this.maxShown = maxShown;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public Integer getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(Integer minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
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

    public OrderSide6586 getOrderSide() {
        return orderSide;
    }

    public void setOrderSide(OrderSide6586 orderSide) {
        this.orderSide = orderSide;
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

    public Long getHostOrderId() {
        return hostOrderId;
    }

    public void setHostOrderId(Long hostOrderId) {
        this.hostOrderId = hostOrderId;
    }

    public OrderMarketTypeTadbir getMarketType() {
        return marketType;
    }

    public void setMarketType(OrderMarketTypeTadbir marketType) {
        this.marketType = marketType;
    }

    public OrderFormTadbir getOrderForm() {
        return orderForm;
    }

    public void setOrderForm(OrderFormTadbir orderForm) {
        this.orderForm = orderForm;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "OrderTadbir{" +
                "financialId=" + financialId +
                ", parentId=" + parentId +
                ", userName='" + userName + '\'' +
                ", symbolISIN='" + symbolISIN + '\'' +
                ", symbol='" + symbol + '\'' +
                ", enSymbol='" + enSymbol + '\'' +
                ", customerISIN='" + customerISIN + '\'' +
                ", executedAmount=" + executedAmount +
                ", orderId=" + orderId +
                ", maximumQuantity=" + maximumQuantity +
                ", maxShown=" + maxShown +
                ", orderState=" + orderState +
                ", minimumQuantity=" + minimumQuantity +
                ", orderEntryDate=" + orderEntryDate +
                ", orderPrice=" + orderPrice +
                ", orderSide=" + orderSide +
                ", orderTotalQuantity=" + orderTotalQuantity +
                ", orderValidity=" + orderValidity +
                ", orderValidityDate=" + orderValidityDate +
                ", hostOrderId=" + hostOrderId +
                ", marketType=" + marketType +
                ", orderForm=" + orderForm +
                ", errorCode='" + errorCode + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}