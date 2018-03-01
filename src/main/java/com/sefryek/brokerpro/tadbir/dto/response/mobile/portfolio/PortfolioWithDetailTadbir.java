package com.sefryek.brokerpro.tadbir.dto.response.mobile.portfolio;

import com.fasterxml.jackson.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 07, Jan, 2017
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "BestBuyPrice",
        "BestSellPrice",
        "LastTradedPrice",
        "LastTradedPricePercent",
        "ClosingPrice",
        "ClosingPricePercent",
        "RefPrice"

})
public class PortfolioWithDetailTadbir extends PortfolioTadbir{
    @JsonProperty("BestBuyPrice")
    private BigDecimal bestBuyPrice;
    @JsonProperty("BestSellPrice")
    private BigDecimal bestSellPrice;
    @JsonProperty("LastTradedPrice")
    private BigDecimal lastTradedPrice;
    @JsonProperty("LastTradedPricePercent")
    private BigDecimal lastTradedPricePercent;
    @JsonProperty("ClosingPrice")
    private BigDecimal closingPrice;
    @JsonProperty("ClosingPricePercent")
    private BigDecimal closingPricePercent;
    @JsonProperty("RefPrice")
    private BigDecimal refPrice;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The bestBuyPrice
     */
    @JsonProperty("BestBuyPrice")
    public BigDecimal getBestBuyPrice() {
        return bestBuyPrice;
    }

    /**
     * @param bestBuyPrice The BestBuyPrice
     */
    @JsonProperty("BestBuyPrice")
    public void setBestBuyPrice(BigDecimal bestBuyPrice) {
        this.bestBuyPrice = bestBuyPrice;
    }

    /**
     * @return The bestSellPrice
     */
    @JsonProperty("BestSellPrice")
    public BigDecimal getBestSellPrice() {
        return bestSellPrice;
    }

    /**
     * @param bestSellPrice The BestSellPrice
     */
    @JsonProperty("BestSellPrice")
    public void setBestSellPrice(BigDecimal bestSellPrice) {
        this.bestSellPrice = bestSellPrice;
    }

    /**
     * @return The lastTradedPrice
     */
    @JsonProperty("LastTradedPrice")
    public BigDecimal getLastTradedPrice() {
        return lastTradedPrice;
    }

    /**
     * @param lastTradedPrice The LastTradedPrice
     */
    @JsonProperty("LastTradedPrice")
    public void setLastTradedPrice(BigDecimal lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
    }

    /**
     * @return The lastTradedPricePercent
     */
    @JsonProperty("LastTradedPricePercent")
    public BigDecimal getLastTradedPricePercent() {
        return lastTradedPricePercent;
    }

    /**
     * @param lastTradedPricePercent The LastTradedPricePercent
     */
    @JsonProperty("LastTradedPricePercent")
    public void setLastTradedPricePercent(BigDecimal lastTradedPricePercent) {
        this.lastTradedPricePercent = lastTradedPricePercent;
    }

    /**
     * @return The closingPrice
     */
    @JsonProperty("ClosingPrice")
    public BigDecimal getClosingPrice() {
        return closingPrice;
    }

    /**
     * @param closingPrice The ClosingPrice
     */
    @JsonProperty("ClosingPrice")
    public void setClosingPrice(BigDecimal closingPrice) {
        this.closingPrice = closingPrice;
    }

    /**
     * @return The closingPricePercent
     */
    @JsonProperty("ClosingPricePercent")
    public BigDecimal getClosingPricePercent() {
        return closingPricePercent;
    }

    /**
     * @param closingPricePercent The ClosingPricePercent
     */
    @JsonProperty("ClosingPricePercent")
    public void setClosingPricePercent(BigDecimal closingPricePercent) {
        this.closingPricePercent = closingPricePercent;
    }

    /**
     * @return The refPrice
     */
    @JsonProperty("RefPrice")
    public BigDecimal getRefPrice() {
        return refPrice;
    }

    /**
     * @param refPrice The RefPrice
     */
    @JsonProperty("RefPrice")
    public void setRefPrice(BigDecimal refPrice) {
        this.refPrice = refPrice;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
