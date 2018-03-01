package com.sefryek.brokerpro.dto.response.market.price;

import java.math.BigDecimal;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 18, Dec, 2016
 */
public class Price {

    private String date;
    private String time;
    private Boolean negative;
    private Boolean right;
    private Boolean faraBourse;
    private String nscCode;
    private Long lastTradedPrice;
    private Integer realChangePrice;
    private Integer mantissa;
    private BigDecimal closingPrice;
    private Long highAllowedPrice;
    private Long lowAllowedPrice;
    private Double priceVar;
    private Long priceChange;
    private Long totalNumberOfSharesTraded;
    private String symbolCompleteName;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getNegative() {
        return negative;
    }

    public void setNegative(Boolean negative) {
        this.negative = negative;
    }

    public Boolean getRight() {
        return right;
    }

    public void setRight(Boolean right) {
        this.right = right;
    }

    public Boolean getFaraBourse() {
        return faraBourse;
    }

    public void setFaraBourse(Boolean faraBourse) {
        this.faraBourse = faraBourse;
    }

    public String getNscCode() {
        return nscCode;
    }

    public void setNscCode(String nscCode) {
        this.nscCode = nscCode;
    }

    public Long getLastTradedPrice() {
        return lastTradedPrice;
    }

    public void setLastTradedPrice(Long lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
    }

    public Integer getRealChangePrice() {
        return realChangePrice;
    }

    public void setRealChangePrice(Integer realChangePrice) {
        this.realChangePrice = realChangePrice;
    }

    public Integer getMantissa() {
        return mantissa;
    }

    public void setMantissa(Integer mantissa) {
        this.mantissa = mantissa;
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

    public String getSymbolCompleteName() {
        return symbolCompleteName;
    }

    public void setSymbolCompleteName(String symbolCompleteName) {
        this.symbolCompleteName = symbolCompleteName;
    }

    @Override
    public String toString() {
        return "Price{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", negative=" + negative +
                ", right=" + right +
                ", faraBourse=" + faraBourse +
                ", nscCode='" + nscCode + '\'' +
                ", lastTradedPrice=" + lastTradedPrice +
                ", realChangePrice=" + realChangePrice +
                ", mantissa=" + mantissa +
                ", closingPrice=" + closingPrice +
                ", highAllowedPrice=" + highAllowedPrice +
                ", lowAllowedPrice=" + lowAllowedPrice +
                ", priceVar=" + priceVar +
                ", priceChange=" + priceChange +
                ", totalNumberOfSharesTraded=" + totalNumberOfSharesTraded +
                ", symbolCompleteName='" + symbolCompleteName + '\'' +
                '}';
    }
}
