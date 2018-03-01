package com.sefryek.brokerpro.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sefryek.brokerpro.domain.enumeration.MarketUnit;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 11, Nov, 2017
 */
@KeySpace("exchange_symbol_broker")
@Document(collection = "exchange_symbol_broker")
public class ExchangeBroker extends Entity implements Comparable<ExchangeBroker> {
    @JsonIgnore
    @Id
    private String id;
    @JsonIgnore
    @Field("language")
    private String language;
    @Field("symbol_isin")
    private String symbolISIN;
    @JsonIgnore
    @Field("broker-code")
    private String brokerCode;
    @Field("symbol_short_name")
    private String symbolShortName;
    @Field("symbol_complete_name")
    private String symbolCompleteName;
    @JsonIgnore
    @Field("market_unit")
    private MarketUnit marketUnit;
    @JsonIgnore
    @Field("is_approved")
    private Boolean approved;
    @JsonIgnore
    @Field("is_tradable")
    private Boolean tradeAble;

    /**
     * Tadbir wants to sort symbols in search by this sequence:
     * 1- symbolShortName starts with.
     * 2- symbolShortName contains.
     * 3- symbolCompleteName starts with.
     * 4- symbolCompleteName contains.
     * So we added these to filed without first character for search for contains (2, 4)
     * textForSearchShort = symbolShortName without first character.
     * textForSearchComplete = symbolCompleteName without first character
     */
    @JsonIgnore
    @Field("text_for_search_short")
    private String textForSearchShort;
    @JsonIgnore
    @Field("text_for_search_complete")
    private String textForSearchComplete;

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

    public String getBrokerCode() {
        return brokerCode;
    }

    public void setBrokerCode(String brokerCode) {
        this.brokerCode = brokerCode;
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

    public String getTextForSearchShort() {
        return textForSearchShort;
    }

    public void setTextForSearchShort(String textForSearchShort) {
        this.textForSearchShort = textForSearchShort;
    }

    public String getTextForSearchComplete() {
        return textForSearchComplete;
    }

    public void setTextForSearchComplete(String textForSearchComplete) {
        this.textForSearchComplete = textForSearchComplete;
    }

    @Override
    public String toString() {
        return "ExchangeBroker{" +
                "id='" + id + '\'' +
                ", language='" + language + '\'' +
                ", symbolISIN='" + symbolISIN + '\'' +
                ", brokerCode='" + brokerCode + '\'' +
                ", symbolShortName='" + symbolShortName + '\'' +
                ", symbolCompleteName='" + symbolCompleteName + '\'' +
                ", marketUnit=" + marketUnit +
                ", approved=" + approved +
                ", tradeAble=" + tradeAble +
                ", textForSearchShort='" + textForSearchShort + '\'' +
                ", textForSearchComplete='" + textForSearchComplete + '\'' +
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

        ExchangeBroker exchange = (ExchangeBroker) o;

        return id.equals(exchange.id);
    }

    @Override
    public int compareTo(ExchangeBroker exchange) {
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
