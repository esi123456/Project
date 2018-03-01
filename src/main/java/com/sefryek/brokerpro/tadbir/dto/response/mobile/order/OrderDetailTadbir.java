package com.sefryek.brokerpro.tadbir.dto.response.mobile.order;

import com.fasterxml.jackson.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 24, Sep, 2017
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDetailTadbir {
    @JsonProperty("OrderId")
    private Long orderId;
    @JsonProperty("TradedQuantity")
    private Long tradedQuantity;
    @JsonProperty("TradedPrice")
    private BigDecimal tradedPrice;
    @JsonProperty("TradeDate")
    private Date tradeDate;
    @JsonProperty("TradeTime")
    private String tradeTime;
    @JsonProperty("BourseCompanyCommission")
    private Long bourseCompanyCommission;
    @JsonProperty("BrokerCommission")
    private Long brokerCommission;
    @JsonProperty("SupervisionCommission")
    private Long supervisionCommission;
    @JsonProperty("DepositoryCommission")
    private Long depositoryCommission;
    @JsonProperty("TechnologyCommission")
    private Long technologyCommission;
    @JsonProperty("CommissionDifference")
    private Long commissionDifference;
    @JsonProperty("Tax")
    private Long tax;
    @JsonProperty("TotalValue")
    private Long totalValue;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getTradedQuantity() {
        return tradedQuantity;
    }

    public void setTradedQuantity(Long tradedQuantity) {
        this.tradedQuantity = tradedQuantity;
    }

    public BigDecimal getTradedPrice() {
        return tradedPrice;
    }

    public void setTradedPrice(BigDecimal tradedPrice) {
        this.tradedPrice = tradedPrice;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public Long getBourseCompanyCommission() {
        return bourseCompanyCommission;
    }

    public void setBourseCompanyCommission(Long bourseCompanyCommission) {
        this.bourseCompanyCommission = bourseCompanyCommission;
    }

    public Long getBrokerCommission() {
        return brokerCommission;
    }

    public void setBrokerCommission(Long brokerCommission) {
        this.brokerCommission = brokerCommission;
    }

    public Long getSupervisionCommission() {
        return supervisionCommission;
    }

    public void setSupervisionCommission(Long supervisionCommission) {
        this.supervisionCommission = supervisionCommission;
    }

    public Long getDepositoryCommission() {
        return depositoryCommission;
    }

    public void setDepositoryCommission(Long depositoryCommission) {
        this.depositoryCommission = depositoryCommission;
    }

    public Long getTechnologyCommission() {
        return technologyCommission;
    }

    public void setTechnologyCommission(Long technologyCommission) {
        this.technologyCommission = technologyCommission;
    }

    public Long getCommissionDifference() {
        return commissionDifference;
    }

    public void setCommissionDifference(Long commissionDifference) {
        this.commissionDifference = commissionDifference;
    }

    public Long getTax() {
        return tax;
    }

    public void setTax(Long tax) {
        this.tax = tax;
    }

    public Long getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Long totalValue) {
        this.totalValue = totalValue;
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
        return "OrderDetailTadbir{" +
                "orderId=" + orderId +
                ", tradedQuantity=" + tradedQuantity +
                ", tradedPrice=" + tradedPrice +
                ", tradeDate=" + tradeDate +
                ", tradeTime='" + tradeTime + '\'' +
                ", bourseCompanyCommission=" + bourseCompanyCommission +
                ", brokerCommission=" + brokerCommission +
                ", supervisionCommission=" + supervisionCommission +
                ", depositoryCommission=" + depositoryCommission +
                ", technologyCommission=" + technologyCommission +
                ", commissionDifference=" + commissionDifference +
                ", tax=" + tax +
                ", totalValue=" + totalValue +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
