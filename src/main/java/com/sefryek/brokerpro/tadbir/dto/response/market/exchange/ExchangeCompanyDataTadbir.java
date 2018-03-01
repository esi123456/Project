package com.sefryek.brokerpro.tadbir.dto.response.market.exchange;

import com.fasterxml.jackson.annotation.*;
import com.sefryek.brokerpro.domain.enumeration.MarketCode;
import com.sefryek.brokerpro.tadbir.dto.response.market.exchange.enumeration.MarketUnitTadbir;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExchangeCompanyDataTadbir {
    @JsonProperty("SymbolISIN")
    private String symbolISIN;
    @JsonProperty("SymbolFa")
    private String symbolShortNameFa;
    @JsonProperty("SymbolEn")
    private String symbolShortNameEn;
    @JsonProperty("CompanyName")
    private String symbolCompleteNameFa;
    @JsonProperty("EnCompanyName")
    private String symbolCompleteNameEn;
    @JsonProperty("MarketUnit")
    private MarketUnitTadbir marketUnit;
    @JsonProperty("MarketCode")
    private MarketCode marketCode;
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

    public MarketCode getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(MarketCode marketCode) {
        this.marketCode = marketCode;
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
        return "ExchangeCompanyDataTadbir{" +
                "symbolISIN='" + symbolISIN + '\'' +
                ", symbolShortNameFa='" + symbolShortNameFa + '\'' +
                ", symbolShortNameEn='" + symbolShortNameEn + '\'' +
                ", symbolCompleteNameFa='" + symbolCompleteNameFa + '\'' +
                ", symbolCompleteNameEn='" + symbolCompleteNameEn + '\'' +
                ", marketUnit=" + marketUnit +
                ", marketCode=" + marketCode +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}