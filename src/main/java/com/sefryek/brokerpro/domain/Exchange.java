package com.sefryek.brokerpro.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sefryek.brokerpro.domain.enumeration.MarketCode;
import com.sefryek.brokerpro.domain.enumeration.MarketUnit;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @auther: Ashkan Haghighi Kia
 * @email: kia@syspod.co
 */
@KeySpace("exchange_symbol")
@Document(collection = "exchange_symbol")
public class Exchange extends Entity implements Comparable<Exchange> {
    @JsonIgnore
    @Id
    private String id;
    @JsonIgnore
    @Field("language")
    private String language;
    @Field("symbol_isin")
    private String symbolISIN;
    @Field("symbol_short_name")
    private String symbolShortName;
    @Field("symbol_complete_name")
    private String symbolCompleteName;
    @Field("market_unit")
    private MarketUnit marketUnit;
    @Field("market_code")
    private MarketCode marketCode;
    @JsonIgnore
    @Field("text_for_search")
    private String textForSearch;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSymbolISIN() {
        return symbolISIN;
    }

    public void setSymbolISIN(String symbolISIN) {
        this.symbolISIN = symbolISIN;
    }

    public String getSymbolShortName() {
        return symbolShortName;
    }

    public void setSymbolShortName(String symbolShortName) {
        this.symbolShortName = symbolShortName;
    }

    public String getSymbolCompleteName() {
        return symbolCompleteName;
    }

    public void setSymbolCompleteName(String symbolCompleteName) {
        this.symbolCompleteName = symbolCompleteName;
    }

    public MarketUnit getMarketUnit() {
        return marketUnit;
    }

    public void setMarketUnit(MarketUnit marketUnit) {
        this.marketUnit = marketUnit;
    }

    public MarketCode getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(MarketCode marketCode) {
        this.marketCode = marketCode;
    }

    public String getTextForSearch() {
        return textForSearch;
    }

    public void setTextForSearch(String textForSearch) {
        this.textForSearch = textForSearch;
    }

    @Override
    public String toString() {
        return "Exchange{" +
                "id='" + id + '\'' +
                ", language='" + language + '\'' +
                ", symbolISIN='" + symbolISIN + '\'' +
                ", symbolShortName='" + symbolShortName + '\'' +
                ", symbolCompleteName='" + symbolCompleteName + '\'' +
                ", marketUnit=" + marketUnit +
                ", marketCode=" + marketCode +
                ", textForSearch='" + textForSearch + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Exchange exchange = (Exchange) o;

        return id.equals(exchange.id);
    }

    @Override
    public int compareTo(Exchange exchange) {
        String exchangeId = exchange.getId();
        //ascending order
        return this.id.compareTo(exchangeId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}