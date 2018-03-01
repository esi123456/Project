package com.sefryek.brokerpro.tadbir.dto.response.market.queue;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amin.malekpour on 2016-12-13.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QueueTadbir {
    @JsonProperty("BestBuyPrice")
    private Long bestBuyPrice;
    @JsonProperty("BestSellPrice")
    private Long bestSellPrice;
    @JsonProperty("BestSellQuantity")
    private Long bestSellQuantity;
    @JsonProperty("BestBuyQuantity")
    private Long bestBuyQuantity;
    @JsonProperty("NoBestBuy")
    private Long noBestBuy;
    @JsonProperty("NoBestSell")
    private Long noBestSell;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Long getBestBuyPrice() {
        return bestBuyPrice;
    }

    public void setBestBuyPrice(Long bestBuyPrice) {
        this.bestBuyPrice = bestBuyPrice;
    }

    public Long getBestSellPrice() {
        return bestSellPrice;
    }

    public void setBestSellPrice(Long bestSellPrice) {
        this.bestSellPrice = bestSellPrice;
    }

    public Long getBestSellQuantity() {
        return bestSellQuantity;
    }

    public void setBestSellQuantity(Long bestSellQuantity) {
        this.bestSellQuantity = bestSellQuantity;
    }

    public Long getBestBuyQuantity() {
        return bestBuyQuantity;
    }

    public void setBestBuyQuantity(Long bestBuyQuantity) {
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
        return "QueueTadbir{" +
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
