package com.sefryek.brokerpro.tadbir.dto.response.market.activity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sefryek.brokerpro.dto.request.market.activity.MarketActivityCode;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 25, Dec, 2016
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MarketActivityTAdbir {
    @JsonProperty("SecuritiesExchangeId")
    private MarketActivityCode marketCode;
    @JsonProperty("SecuritiesExchangeName")
    private String marketName;
    @JsonProperty("TotalNumerbOfTrades")
    private Long totalNoTrade;
    @JsonProperty("TotalTradeValue")
    private BigDecimal totalTradeValue;
    @JsonProperty("TotalNumberOfShareTrade")
    private Long totalNoSharesTraded;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public MarketActivityCode getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(MarketActivityCode marketCode) {
        this.marketCode = marketCode;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public Long getTotalNoTrade() {
        return totalNoTrade;
    }

    public void setTotalNoTrade(Long totalNoTrade) {
        this.totalNoTrade = totalNoTrade;
    }

    public BigDecimal getTotalTradeValue() {
        return totalTradeValue;
    }

    public void setTotalTradeValue(BigDecimal totalTradeValue) {
        this.totalTradeValue = totalTradeValue;
    }

    public Long getTotalNoSharesTraded() {
        return totalNoSharesTraded;
    }

    public void setTotalNoSharesTraded(Long totalNoSharesTraded) {
        this.totalNoSharesTraded = totalNoSharesTraded;
    }

    @Override
    public String toString() {
        return "MarketActivityTAdbir{" +
                "marketCode=" + marketCode +
                ", marketName='" + marketName + '\'' +
                ", totalNoTrade=" + totalNoTrade +
                ", totalTradeValue=" + totalTradeValue +
                ", totalNoSharesTraded=" + totalNoSharesTraded +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
