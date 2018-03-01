package com.sefryek.brokerpro.dto.response.market.price.first;


import com.sefryek.brokerpro.domain.enumeration.MarketCode;
import com.sefryek.brokerpro.domain.enumeration.MarketUnit;
import com.sefryek.brokerpro.dto.response.market.queue.Queue;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 31, Dec, 2016
 */
public class PriceWithFirstQueue {

    private Queue queueFirstRow;
    private String symbolISIN;
    private String symbolShortName;
    private String symbolCompleteName;
    private SymbolState symbolState;
    private Date tradeDate;
    private Long lastTradedPrice;
    private BigDecimal closingPrice;
    private Long highAllowedPrice;
    private Long lowAllowedPrice;
    private Double priceVar;
    private Long priceChange;
    private Long totalNumberOfSharesTraded;
    private BigDecimal closingPriceVar;
    private BigDecimal closingPriceChange;
    private BigDecimal maxQuantityOrder;
    private BigDecimal minQuantityOrder;
    private Long totalNumberOfTrades;
    private BigDecimal totalTradeValue;
    private BigDecimal highPrice;
    private BigDecimal lowPrice;
    private BigDecimal referencePrice;
    private Double basisVolume;
    private BigDecimal percentOfBasisVolume;
    private BigDecimal firstTradedPrice;
    private MarketUnit marketUnit;
    private MarketCode marketCode;
    private GroupState groupState;
    private String groupCode;

    public Queue getQueueFirstRow() {
        return queueFirstRow;
    }

    public void setQueueFirstRow(Queue queueFirstRow) {
        this.queueFirstRow = queueFirstRow;
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

    public SymbolState getSymbolState() {
        return symbolState;
    }

    public void     setSymbolState(SymbolState symbolState) {
        this.symbolState = symbolState;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
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

    public BigDecimal getFirstTradedPrice() {
        return firstTradedPrice;
    }

    public void setFirstTradedPrice(BigDecimal firstTradedPrice) {
        this.firstTradedPrice = firstTradedPrice;
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

    public GroupState getGroupState() {
        return groupState;
    }

    public void setGroupState(GroupState groupState) {
        this.groupState = groupState;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    @Override
    public String toString() {
        return "PriceWithFirstQueue{" +
                "queueFirstRow=" + queueFirstRow +
                ", symbolISIN='" + symbolISIN + '\'' +
                ", symbolShortName='" + symbolShortName + '\'' +
                ", symbolCompleteName='" + symbolCompleteName + '\'' +
                ", symbolState=" + symbolState +
                ", tradeDate=" + tradeDate +
                ", lastTradedPrice=" + lastTradedPrice +
                ", closingPrice=" + closingPrice +
                ", highAllowedPrice=" + highAllowedPrice +
                ", lowAllowedPrice=" + lowAllowedPrice +
                ", priceVar=" + priceVar +
                ", priceChange=" + priceChange +
                ", totalNumberOfSharesTraded=" + totalNumberOfSharesTraded +
                ", closingPriceVar=" + closingPriceVar +
                ", closingPriceChange=" + closingPriceChange +
                ", maxQuantityOrder=" + maxQuantityOrder +
                ", minQuantityOrder=" + minQuantityOrder +
                ", totalNumberOfTrades=" + totalNumberOfTrades +
                ", totalTradeValue=" + totalTradeValue +
                ", highPrice=" + highPrice +
                ", lowPrice=" + lowPrice +
                ", referencePrice=" + referencePrice +
                ", basisVolume=" + basisVolume +
                ", percentOfBasisVolume=" + percentOfBasisVolume +
                ", firstTradedPrice=" + firstTradedPrice +
                ", marketUnit=" + marketUnit +
                ", marketCode=" + marketCode +
                ", groupState=" + groupState +
                ", groupCode='" + groupCode + '\'' +
                '}';
    }
}
