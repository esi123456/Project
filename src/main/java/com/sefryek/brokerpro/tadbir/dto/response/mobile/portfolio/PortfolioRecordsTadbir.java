package com.sefryek.brokerpro.tadbir.dto.response.mobile.portfolio;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sefryek.brokerpro.config.jackson.DateFilterTadbir;
import com.sefryek.brokerpro.dto.request.order.OrderSide6586;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 22, Apr, 2017
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PortfolioRecordsTadbir {
    @JsonProperty("ID")
    private Long rowId;
    @JsonProperty("Count")
    private Long count;
    @JsonProperty("OrderSide")
    private OrderSide6586 orderSide;
    @JsonProperty("TotalCost")
    private BigDecimal totalCost;
    @JsonDeserialize(using = DateFilterTadbir.class)
    @JsonProperty("DateTime")
    private Date dateTime;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("SymbolISIN")
    private String symbolISIN;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    public OrderSide6586 getOrderSide() {
        return orderSide;
    }

    public void setOrderSide(OrderSide6586 orderSide) {
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

    public String getSymbolISIN() {
        return symbolISIN;
    }

    public void setSymbolISIN(String symbolISIN) {
        this.symbolISIN = symbolISIN;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public String toString() {
        return "PortfolioRecordsTadbir{" +
                "rowId=" + rowId +
                ", count=" + count +
                ", orderSide=" + orderSide +
                ", totalCost=" + totalCost +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", symbolISIN='" + symbolISIN + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
