package com.sefryek.brokerpro.tadbir.dto.response.mobile.commission;

/**
 * Copyright 2016 (C) syspod.co
 *
 * @auther: Ashkan Haghighi Kia
 * @email: kia@syspod.co
 */

import com.fasterxml.jackson.annotation.*;
import com.sefryek.brokerpro.dto.request.order.OrderSide6586;
import com.sefryek.brokerpro.tadbir.dto.response.market.exchange.enumeration.MarketUnitTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.commission.enumeration.CommissionTypeTadbir;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommissionDetailTadbir {
    /** this parameter will be set manually **/
    private String brokerCode;
    @JsonProperty("MaxAvarezPrice")
    private BigDecimal maxAvarezPrice;
    @JsonProperty("MaxFanavariPrice")
    private BigDecimal maxFanavariPrice;
    @JsonProperty("MaxKarmozdPrice")
    private BigDecimal maxKarmozdPrice;
    @JsonProperty("MaxSazmanPrice")
    private BigDecimal maxSazmanPrice;
    @JsonProperty("MaxSepodegozariPrice")
    private BigDecimal maxSepodegozariPrice;
    @JsonProperty("MinKarmozdPrice")
    private BigDecimal minKarmozdPrice;
    @JsonProperty("AvarezPercent")
    private BigDecimal avarezPercent;
    @JsonProperty("FanavariPercent")
    private BigDecimal fanavariPercent;
    @JsonProperty("KarmozdPercent")
    private BigDecimal karmozdPercent;
    @JsonProperty("SazmanPercent")
    private BigDecimal sazmanPercent;
    @JsonProperty("SepodegozariPercent")
    private BigDecimal sepodegozariPercent;
    @JsonProperty("TAXPercent")
    private BigDecimal taxPercent;
    @JsonProperty("MarketUnit")
    private MarketUnitTadbir marketUnit;
    @JsonProperty("Side")
    private OrderSide6586 orderSide;
    @JsonProperty("CommisionType")
    private CommissionTypeTadbir commissionType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    public MarketUnitTadbir getMarketUnit() {
        return marketUnit;
    }

    public void setMarketUnit(MarketUnitTadbir marketUnit) {
        this.marketUnit = marketUnit;
    }

    public OrderSide6586 getOrderSide() {
        return orderSide;
    }

    public void setOrderSide(OrderSide6586 orderSide) {
        this.orderSide = orderSide;
    }

    public CommissionTypeTadbir getCommissionType() {
        return commissionType;
    }

    public void setCommissionType(CommissionTypeTadbir commissionType) {
        this.commissionType = commissionType;
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
        return "CommissionDetailTadbir{" +
                "brokerCode='" + brokerCode + '\'' +
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
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}