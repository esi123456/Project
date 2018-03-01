package com.sefryek.brokerpro.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, Jul, 2017
 */
@KeySpace("commission")
@Document(collection = "commission")
public class Commission extends Entity implements Comparable<Commission> {

    @Id
    @Field("id")
    @JsonIgnore
    private String code;
    @Field("broker_code")
    @JsonIgnore
    private String brokerCode;
    @Field("symbol_isin")
    @JsonIgnore
    private String symbolISIN;
    @Field("min_buy")
    private BigDecimal minBuyBrokerCommissionPrice;
    @Field("min_sell")
    private BigDecimal minSellBrokerCommissionPrice;
    @Field("buy_other")
    private BigDecimal buyCommissionOther;
    @Field("buy_broker")
    private BigDecimal buyCommissionBroker;
    @Field("sell_other")
    private BigDecimal sellCommissionOther;
    @Field("sell_broker")
    private BigDecimal sellCommissionBroker;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrokerCode() {
        return brokerCode;
    }

    public void setBrokerCode(String brokerCode) {
        this.brokerCode = brokerCode;
    }

    public String getSymbolISIN() {
        return symbolISIN;
    }

    public void setSymbolISIN(String symbolISIN) {
        this.symbolISIN = symbolISIN;
    }

    public BigDecimal getMinBuyBrokerCommissionPrice() {
        return minBuyBrokerCommissionPrice;
    }

    public void setMinBuyBrokerCommissionPrice(BigDecimal minBuyBrokerCommissionPrice) {
        this.minBuyBrokerCommissionPrice = minBuyBrokerCommissionPrice;
    }

    public BigDecimal getMinSellBrokerCommissionPrice() {
        return minSellBrokerCommissionPrice;
    }

    public void setMinSellBrokerCommissionPrice(BigDecimal minSellBrokerCommissionPrice) {
        this.minSellBrokerCommissionPrice = minSellBrokerCommissionPrice;
    }

    public BigDecimal getBuyCommissionOther() {
        return buyCommissionOther;
    }

    public void setBuyCommissionOther(BigDecimal buyCommissionOther) {
        this.buyCommissionOther = buyCommissionOther;
    }

    public BigDecimal getBuyCommissionBroker() {
        return buyCommissionBroker;
    }

    public void setBuyCommissionBroker(BigDecimal buyCommissionBroker) {
        this.buyCommissionBroker = buyCommissionBroker;
    }

    public BigDecimal getSellCommissionOther() {
        return sellCommissionOther;
    }

    public void setSellCommissionOther(BigDecimal sellCommissionOther) {
        this.sellCommissionOther = sellCommissionOther;
    }

    public BigDecimal getSellCommissionBroker() {
        return sellCommissionBroker;
    }

    public void setSellCommissionBroker(BigDecimal sellCommissionBroker) {
        this.sellCommissionBroker = sellCommissionBroker;
    }

    @Override
    public String toString() {
        return "Commission{" +
                "code='" + code + '\'' +
                ", brokerCode='" + brokerCode + '\'' +
                ", symbolISIN='" + symbolISIN + '\'' +
                ", minBuyBrokerCommissionPrice=" + minBuyBrokerCommissionPrice +
                ", minSellBrokerCommissionPrice=" + minSellBrokerCommissionPrice +
                ", buyCommissionOther=" + buyCommissionOther +
                ", buyCommissionBroker=" + buyCommissionBroker +
                ", sellCommissionOther=" + sellCommissionOther +
                ", sellCommissionBroker=" + sellCommissionBroker +
                '}';
    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Commission commission = (Commission) o;

        return code != null ? code.equals(commission.code) : commission.code == null;
    }

    @Override
    public int compareTo(Commission commission) {
        String code = commission.getCode();
        //ascending order
        return this.code.compareTo(code);
    }
}