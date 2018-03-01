package com.sefryek.brokerpro.tadbir.dto.response.market.price.first;

import com.fasterxml.jackson.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 31, Dec, 2016
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QueueFirstRowTadbir {
    @JsonProperty("BestBuyPrice")
    private BigDecimal bestBuyPrice;
    @JsonProperty("BestSellPrice")
    private BigDecimal bestSellPrice;
    @JsonProperty("BestSellQuantity")
    private BigDecimal bestSellQuantity;
    @JsonProperty("BestBuyQuantity")
    private BigDecimal bestBuyQuantity;
    @JsonProperty("NoBestBuy")
    private Long noBestBuy;
    @JsonProperty("NoBestSell")
    private Long noBestSell;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public BigDecimal getBestBuyPrice() {
        return bestBuyPrice;
    }

    public void setBestBuyPrice(BigDecimal bestBuyPrice) {
        this.bestBuyPrice = bestBuyPrice;
    }

    public BigDecimal getBestSellPrice() {
        return bestSellPrice;
    }

    public void setBestSellPrice(BigDecimal bestSellPrice) {
        this.bestSellPrice = bestSellPrice;
    }

    public BigDecimal getBestSellQuantity() {
        return bestSellQuantity;
    }

    public void setBestSellQuantity(BigDecimal bestSellQuantity) {
        this.bestSellQuantity = bestSellQuantity;
    }

    public BigDecimal getBestBuyQuantity() {
        return bestBuyQuantity;
    }

    public void setBestBuyQuantity(BigDecimal bestBuyQuantity) {
        this.bestBuyQuantity = bestBuyQuantity;
    }

    public Long getNoBestBuy() {
        return noBestBuy;
    }

    public void setNoBestBuy(Long noBestBuy) {
        this.noBestBuy = noBestBuy;
    }

    public Long getNoBestSell() {
        return noBestSell;
    }

    public void setNoBestSell(Long noBestSell) {
        this.noBestSell = noBestSell;
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
        return "QueueFirstRowTadbir{" +
                "bestBuyPrice=" + bestBuyPrice +
                ", bestSellPrice=" + bestSellPrice +
                ", bestSellQuantity=" + bestSellQuantity +
                ", bestBuyQuantity=" + bestBuyQuantity +
                ", noBestBuy=" + noBestBuy +
                ", noBestSell=" + noBestSell +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
