package com.sefryek.brokerpro.tadbir.dto.response.market.exchange.broker;

import com.fasterxml.jackson.annotation.*;
import com.sefryek.brokerpro.tadbir.dto.response.market.exchange.enumeration.MarketUnitTadbir;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 11, Nov, 2017
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExchangeBrokerDataTadbir {
    @JsonProperty("SymbolISIN")
    private String symbolISIN;
    @JsonProperty("Symbol")
    private String symbolShortNameFa;
    @JsonProperty("EnSymbol")
    private String symbolShortNameEn;
    @JsonProperty("Title")
    private String symbolCompleteNameFa;
    @JsonProperty("EnTitle")
    private String symbolCompleteNameEn;
    @JsonProperty("MarketUnit")
    private MarketUnitTadbir marketUnit;
    @JsonProperty("IsApproved")
    private Boolean approved;
    @JsonProperty("IsTradable")
    private Boolean tradeAble;
    @JsonIgnore
    private String brokerCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    public String getSymbolISIN() {
        return symbolISIN;
    }

    public void setSymbolISIN(String symbolISIN) {
        this.symbolISIN = symbolISIN;
    }

    public String getSymbolShortNameFa() {
        return symbolShortNameFa;
    }

    public void setSymbolShortNameFa(String symbolShortNameFa) {
        this.symbolShortNameFa = symbolShortNameFa;
    }

    public String getSymbolShortNameEn() {
        return symbolShortNameEn;
    }

    public void setSymbolShortNameEn(String symbolShortNameEn) {
        this.symbolShortNameEn = symbolShortNameEn;
    }

    public String getSymbolCompleteNameFa() {
        return symbolCompleteNameFa;
    }

    public void setSymbolCompleteNameFa(String symbolCompleteNameFa) {
        this.symbolCompleteNameFa = symbolCompleteNameFa;
    }

    public String getSymbolCompleteNameEn() {
        return symbolCompleteNameEn;
    }

    public void setSymbolCompleteNameEn(String symbolCompleteNameEn) {
        this.symbolCompleteNameEn = symbolCompleteNameEn;
    }

    public MarketUnitTadbir getMarketUnit() {
        return marketUnit;
    }

    public void setMarketUnit(MarketUnitTadbir marketUnit) {
        this.marketUnit = marketUnit;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Boolean getTradeAble() {
        return tradeAble;
    }

    public void setTradeAble(Boolean tradeAble) {
        this.tradeAble = tradeAble;
    }

    public String getBrokerCode() {
        return brokerCode;
    }

    public void setBrokerCode(String brokerCode) {
        this.brokerCode = brokerCode;
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
        return "ExchangeBrokerDataTadbir{" +
                "symbolISIN='" + symbolISIN + '\'' +
                ", symbolShortNameFa='" + symbolShortNameFa + '\'' +
                ", symbolShortNameEn='" + symbolShortNameEn + '\'' +
                ", symbolCompleteNameFa='" + symbolCompleteNameFa + '\'' +
                ", symbolCompleteNameEn='" + symbolCompleteNameEn + '\'' +
                ", marketUnit=" + marketUnit +
                ", approved=" + approved +
                ", tradeAble=" + tradeAble +
                ", brokerCode='" + brokerCode + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
