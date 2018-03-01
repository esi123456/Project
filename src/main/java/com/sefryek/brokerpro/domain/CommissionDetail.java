package com.sefryek.brokerpro.domain;

import com.sefryek.brokerpro.domain.enumeration.CommissionType;
import com.sefryek.brokerpro.domain.enumeration.MarketUnit;
import com.sefryek.brokerpro.dto.response.mobile.portfolio.OrderSide;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

/**
 * Copyright 2016 (C) syspod.co
 *
 * @auther: Ashkan Haghighi Kia
 * @email: kia@syspod.co
 */
@KeySpace("commission_detail")
@Document(collection = "commission_detail")
public class CommissionDetail extends Entity implements Comparable<CommissionDetail> {
    @Id
    @Field("id")
    private String code;
    @Field("broker_code")
    private String brokerCode;
    @Field("max_avarez_price")
    private BigDecimal maxAvarezPrice;
    @Field("max_fanavari_price")
    private BigDecimal maxFanavariPrice;
    @Field("max_karmozd_price")
    private BigDecimal maxKarmozdPrice;
    @Field("max_sazman_price")
    private BigDecimal maxSazmanPrice;
    @Field("max_sepodegozari_price")
    private BigDecimal maxSepodegozariPrice;
    @Field("min_karmozd_price")
    private BigDecimal minKarmozdPrice;
    @Field("avarez_percent")
    private BigDecimal avarezPercent;
    @Field("fanavari_percent")
    private BigDecimal fanavariPercent;
    @Field("karmozd_percent")
    private BigDecimal karmozdPercent;
    @Field("sazman_percent")
    private BigDecimal sazmanPercent;
    @Field("sepodegozari_percent")
    private BigDecimal sepodegozariPercent;
    @Field("tax_percent")
    private BigDecimal taxPercent;
    @Field("market_unit")
    private MarketUnit marketUnit;
    @Field("order_side")
    private OrderSide orderSide;
    @Field("commission_type")
    private CommissionType commissionType;

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

    public BigDecimal getMaxAvarezPrice() {
        return maxAvarezPrice;
    }

    public void setMaxAvarezPrice(BigDecimal maxAvarezPrice) {
        this.maxAvarezPrice = maxAvarezPrice;
    }

    public BigDecimal getMaxFanavariPrice() {
        return maxFanavariPrice;
    }

    public void setMaxFanavariPrice(BigDecimal maxFanavariPrice) {
        this.maxFanavariPrice = maxFanavariPrice;
    }

    public BigDecimal getMaxKarmozdPrice() {
        return maxKarmozdPrice;
    }

    public void setMaxKarmozdPrice(BigDecimal maxKarmozdPrice) {
        this.maxKarmozdPrice = maxKarmozdPrice;
    }

    public BigDecimal getMaxSazmanPrice() {
        return maxSazmanPrice;
    }

    public void setMaxSazmanPrice(BigDecimal maxSazmanPrice) {
        this.maxSazmanPrice = maxSazmanPrice;
    }

    public BigDecimal getMaxSepodegozariPrice() {
        return maxSepodegozariPrice;
    }

    public void setMaxSepodegozariPrice(BigDecimal maxSepodegozariPrice) {
        this.maxSepodegozariPrice = maxSepodegozariPrice;
    }

    public BigDecimal getMinKarmozdPrice() {
        return minKarmozdPrice;
    }

    public void setMinKarmozdPrice(BigDecimal minKarmozdPrice) {
        this.minKarmozdPrice = minKarmozdPrice;
    }

    public BigDecimal getAvarezPercent() {
        return avarezPercent;
    }

    public void setAvarezPercent(BigDecimal avarezPercent) {
        this.avarezPercent = avarezPercent;
    }

    public BigDecimal getFanavariPercent() {
        return fanavariPercent;
    }

    public void setFanavariPercent(BigDecimal fanavariPercent) {
        this.fanavariPercent = fanavariPercent;
    }

    public BigDecimal getKarmozdPercent() {
        return karmozdPercent;
    }

    public void setKarmozdPercent(BigDecimal karmozdPercent) {
        this.karmozdPercent = karmozdPercent;
    }

    public BigDecimal getSazmanPercent() {
        return sazmanPercent;
    }

    public void setSazmanPercent(BigDecimal sazmanPercent) {
        this.sazmanPercent = sazmanPercent;
    }

    public BigDecimal getSepodegozariPercent() {
        return sepodegozariPercent;
    }

    public void setSepodegozariPercent(BigDecimal sepodegozariPercent) {
        this.sepodegozariPercent = sepodegozariPercent;
    }

    public BigDecimal getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(BigDecimal taxPercent) {
        this.taxPercent = taxPercent;
    }

    public MarketUnit getMarketUnit() {
        return marketUnit;
    }

    public void setMarketUnit(MarketUnit marketUnit) {
        this.marketUnit = marketUnit;
    }

    public OrderSide getOrderSide() {
        return orderSide;
    }

    public void setOrderSide(OrderSide orderSide) {
        this.orderSide = orderSide;
    }

    public CommissionType getCommissionType() {
        return commissionType;
    }

    public void setCommissionType(CommissionType commissionType) {
        this.commissionType = commissionType;
    }

    @Override
    public String toString() {
        return "CommissionDetail{" +
                "code='" + code + '\'' +
                ", brokerCode='" + brokerCode + '\'' +
                ", maxAvarezPrice=" + maxAvarezPrice +
                ", maxFanavariPrice=" + maxFanavariPrice +
                ", maxKarmozdPrice=" + maxKarmozdPrice +
                ", maxSazmanPrice=" + maxSazmanPrice +
                ", maxSepodegozariPrice=" + maxSepodegozariPrice +
                ", minKarmozdPrice=" + minKarmozdPrice +
                ", avarezPercent=" + avarezPercent +
                ", fanavariPercent=" + fanavariPercent +
                ", karmozdPercent=" + karmozdPercent +
                ", sazmanPercent=" + sazmanPercent +
                ", sepodegozariPercent=" + sepodegozariPercent +
                ", taxPercent=" + taxPercent +
                ", marketUnit=" + marketUnit +
                ", orderSide=" + orderSide +
                ", commissionType=" + commissionType +
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

        CommissionDetail commissionDetail = (CommissionDetail) o;

        return code != null ? code.equals(commissionDetail.code) : commissionDetail.code == null;
    }

    @Override
    public int compareTo(CommissionDetail commissionDetail) {
        String code = commissionDetail.getCode();
        //ascending order
        return this.code.compareTo(code);
    }
}