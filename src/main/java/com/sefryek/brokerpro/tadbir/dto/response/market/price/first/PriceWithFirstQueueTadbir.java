package com.sefryek.brokerpro.tadbir.dto.response.market.price.first;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sefryek.brokerpro.config.jackson.DateFilterTadbir;
import com.sefryek.brokerpro.domain.enumeration.MarketCode;
import com.sefryek.brokerpro.tadbir.dto.response.market.exchange.enumeration.MarketUnitTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.market.price.enumeration.FirstSymbolStateTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.market.price.enumeration.GroupStateTdbir;
import com.sefryek.brokerpro.tadbir.dto.response.market.price.enumeration.SecondSymbolStateTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.market.queue.QueueTadbir;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PriceWithFirstQueueTadbir{
    @JsonProperty("BidAskFirstRow")
    private QueueTadbir queueFirstRow;
    @JsonProperty("FirstSymbolState")
    private FirstSymbolStateTadbir firstSymbolState;   //todo ask tadbir
    @JsonProperty("SecondSymbolState")
    private SecondSymbolStateTadbir secondSymbolState; //todo ask tadbir
    @JsonProperty("SymbolISIN")
    private String symbolISIN;
    @JsonProperty("LastTradedPrice")
    private Long lastTradedPrice;
    @JsonProperty("ClosingPrice")
    private BigDecimal closingPrice;
    @JsonProperty("HighAllowedPrice")
    private Long highAllowedPrice;
    @JsonProperty("LowAllowedPrice")
    private Long lowAllowedPrice;
    @JsonProperty("PriceVar")
    private Double priceVar;
    @JsonProperty("PriceChange")
    private Long priceChange;
    @JsonProperty("TotalNumberOfSharesTraded")
    private Long totalNumberOfSharesTraded;
    @JsonProperty("CompanyName")
    private String symbolCompleteNameFa;
    @JsonProperty("EnCompanyName")
    private String symbolCompleteNameEn;
    @JsonProperty("ClosingPriceVar")
    private BigDecimal closingPriceVar;
    @JsonProperty("ClosingPriceChange")
    private BigDecimal closingPriceChange;
    @JsonProperty("MaxQuantityOrder")
    private BigDecimal maxQuantityOrder;
    @JsonProperty("MinQuantityOrder")
    private BigDecimal minQuantityOrder;
    @JsonProperty("TotalNumberOfTrades")
    private Long totalNumberOfTrades;
    @JsonProperty("TotalTradeValue")
    private BigDecimal totalTradeValue;
    @JsonProperty("HighPrice")
    private BigDecimal highPrice;
    @JsonProperty("LowPrice")
    private BigDecimal lowPrice;
    @JsonDeserialize(using = DateFilterTadbir.class)
    @JsonProperty("TradeDate")
    private Date tradeDate;
    @JsonProperty("SymbolFa")
    private String symbolShortNameFa;
    @JsonProperty("SymbolEn")
    private String symbolShortNameEn;
    @JsonProperty("FirstTradedPrice")
    private BigDecimal firstTradedPrice;
    @JsonProperty("ReferencePrice")
    private BigDecimal referencePrice;
    @JsonProperty("BasisVolume")
    private Double basisVolume;
    @JsonProperty("PercentOfBasisVolume")
    private BigDecimal percentOfBasisVolume;
    @JsonProperty("MarketUnit")
    private MarketUnitTadbir marketUnit; //todo ask tadbir
    @JsonProperty("MarketCode")
    private MarketCode marketCode; //todo ask tadbir
    @JsonProperty("SymbolGroupState")
    private GroupStateTdbir groupState;
    @JsonProperty("SymbolGroupCode")
    private String groupCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    public QueueTadbir getQueueFirstRow() {
        return queueFirstRow;
    }

    public void setQueueFirstRow(QueueTadbir queueFirstRow) {
        this.queueFirstRow = queueFirstRow;
    }

    public FirstSymbolStateTadbir getFirstSymbolState() {
        return firstSymbolState;
    }

    public void setFirstSymbolState(FirstSymbolStateTadbir firstSymbolState) {
        this.firstSymbolState = firstSymbolState;
    }

    public SecondSymbolStateTadbir getSecondSymbolState() {
        return secondSymbolState;
    }

    public void setSecondSymbolState(SecondSymbolStateTadbir secondSymbolState) {
        this.secondSymbolState = secondSymbolState;
    }

    public String getSymbolISIN() {
        return symbolISIN;
    }

    public void setSymbolISIN(String symbolISIN) {
        this.symbolISIN = symbolISIN;
    }

    public Long getLastTradedPrice() {
        return lastTradedPrice;
    }

    public void setLastTradedPrice(Long lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
    }

    public BigDecimal getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(BigDecimal closingPrice) {
        this.closingPrice = closingPrice;
    }

    public Long getHighAllowedPrice() {
        return highAllowedPrice;
    }

    public void setHighAllowedPrice(Long highAllowedPrice) {
        this.highAllowedPrice = highAllowedPrice;
    }

    public Long getLowAllowedPrice() {
        return lowAllowedPrice;
    }

    public void setLowAllowedPrice(Long lowAllowedPrice) {
        this.lowAllowedPrice = lowAllowedPrice;
    }

    public Double getPriceVar() {
        return priceVar;
    }

    public void setPriceVar(Double priceVar) {
        this.priceVar = priceVar;
    }

    public Long getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(Long priceChange) {
        this.priceChange = priceChange;
    }

    public Long getTotalNumberOfSharesTraded() {
        return totalNumberOfSharesTraded;
    }

    public void setTotalNumberOfSharesTraded(Long totalNumberOfSharesTraded) {
        this.totalNumberOfSharesTraded = totalNumberOfSharesTraded;
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

    public BigDecimal getClosingPriceVar() {
        return closingPriceVar;
    }

    public void setClosingPriceVar(BigDecimal closingPriceVar) {
        this.closingPriceVar = closingPriceVar;
    }

    public BigDecimal getClosingPriceChange() {
        return closingPriceChange;
    }

    public void setClosingPriceChange(BigDecimal closingPriceChange) {
        this.closingPriceChange = closingPriceChange;
    }

    public BigDecimal getMaxQuantityOrder() {
        return maxQuantityOrder;
    }

    public void setMaxQuantityOrder(BigDecimal maxQuantityOrder) {
        this.maxQuantityOrder = maxQuantityOrder;
    }

    public BigDecimal getMinQuantityOrder() {
        return minQuantityOrder;
    }

    public void setMinQuantityOrder(BigDecimal minQuantityOrder) {
        this.minQuantityOrder = minQuantityOrder;
    }

    public Long getTotalNumberOfTrades() {
        return totalNumberOfTrades;
    }

    public void setTotalNumberOfTrades(Long totalNumberOfTrades) {
        this.totalNumberOfTrades = totalNumberOfTrades;
    }

    public BigDecimal getTotalTradeValue() {
        return totalTradeValue;
    }

    public void setTotalTradeValue(BigDecimal totalTradeValue) {
        this.totalTradeValue = totalTradeValue;
    }

    public BigDecimal getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(BigDecimal highPrice) {
        this.highPrice = highPrice;
    }

    public BigDecimal getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(BigDecimal lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
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

    public BigDecimal getFirstTradedPrice() {
        return firstTradedPrice;
    }

    public void setFirstTradedPrice(BigDecimal firstTradedPrice) {
        this.firstTradedPrice = firstTradedPrice;
    }

    public BigDecimal getReferencePrice() {
        return referencePrice;
    }

    public void setReferencePrice(BigDecimal referencePrice) {
        this.referencePrice = referencePrice;
    }

    public Double getBasisVolume() {
        return basisVolume;
    }

    public void setBasisVolume(Double basisVolume) {
        this.basisVolume = basisVolume;
    }

    public BigDecimal getPercentOfBasisVolume() {
        return percentOfBasisVolume;
    }

    public void setPercentOfBasisVolume(BigDecimal percentOfBasisVolume) {
        this.percentOfBasisVolume = percentOfBasisVolume;
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

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public GroupStateTdbir getGroupState() {
        return groupState;
    }

    public void setGroupState(GroupStateTdbir groupState) {
        this.groupState = groupState;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
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
        return "PriceWithFirstQueueTadbir{" +
                "queueFirstRow=" + queueFirstRow +
                ", firstSymbolState=" + firstSymbolState +
                ", secondSymbolState=" + secondSymbolState +
                ", symbolISIN='" + symbolISIN + '\'' +
                ", lastTradedPrice=" + lastTradedPrice +
                ", closingPrice=" + closingPrice +
                ", highAllowedPrice=" + highAllowedPrice +
                ", lowAllowedPrice=" + lowAllowedPrice +
                ", priceVar=" + priceVar +
                ", priceChange=" + priceChange +
                ", totalNumberOfSharesTraded=" + totalNumberOfSharesTraded +
                ", symbolCompleteNameFa='" + symbolCompleteNameFa + '\'' +
                ", symbolCompleteNameEn='" + symbolCompleteNameEn + '\'' +
                ", closingPriceVar=" + closingPriceVar +
                ", closingPriceChange=" + closingPriceChange +
                ", maxQuantityOrder=" + maxQuantityOrder +
                ", minQuantityOrder=" + minQuantityOrder +
                ", totalNumberOfTrades=" + totalNumberOfTrades +
                ", totalTradeValue=" + totalTradeValue +
                ", highPrice=" + highPrice +
                ", lowPrice=" + lowPrice +
                ", tradeDate=" + tradeDate +
                ", symbolShortNameFa='" + symbolShortNameFa + '\'' +
                ", symbolShortNameEn='" + symbolShortNameEn + '\'' +
                ", firstTradedPrice=" + firstTradedPrice +
                ", referencePrice=" + referencePrice +
                ", basisVolume=" + basisVolume +
                ", percentOfBasisVolume=" + percentOfBasisVolume +
                ", marketUnit=" + marketUnit +
                ", marketCode=" + marketCode +
                ", groupState=" + groupState +
                ", groupCode='" + groupCode + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}

