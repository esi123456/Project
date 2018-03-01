package com.sefryek.brokerpro.tadbir.dto.response.market.price;

import com.fasterxml.jackson.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by amin.malekpour on 2016-12-12.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Price {
    @JsonProperty("Date")
    private String date;
    @JsonProperty("Time")
    private String time;
    @JsonProperty("IsNegative")
    private Boolean negative;
    @JsonProperty("IsRight")
    private Boolean right;
    @JsonProperty("IsFaraBourse")
    private Boolean faraBourse;
    @JsonProperty("SymbolISIN")
    private String symbolISIN;
    @JsonProperty("LastTradedPrice")
    private Long lastTradedPrice;
    @JsonProperty("RealChangePrice")
    private Integer realChangePrice;
    @JsonProperty("Mantissa")
    private Integer mantissa;
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

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

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
        return "Price{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", negative=" + negative +
                ", right=" + right +
                ", faraBourse=" + faraBourse +
                ", symbolISIN='" + symbolISIN + '\'' +
                ", lastTradedPrice=" + lastTradedPrice +
                ", realChangePrice=" + realChangePrice +
                ", mantissa=" + mantissa +
                ", closingPrice=" + closingPrice +
                ", highAllowedPrice=" + highAllowedPrice +
                ", lowAllowedPrice=" + lowAllowedPrice +
                ", priceVar=" + priceVar +
                ", priceChange=" + priceChange +
                ", totalNumberOfSharesTraded=" + totalNumberOfSharesTraded +
                ", symbolCompleteNameFa='" + symbolCompleteNameFa + '\'' +
                ", symbolCompleteNameEn='" + symbolCompleteNameEn + '\'' +
                '}';
    }
}
