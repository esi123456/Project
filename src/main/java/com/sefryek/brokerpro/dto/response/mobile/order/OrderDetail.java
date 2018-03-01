package com.sefryek.brokerpro.dto.response.mobile.order;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 24, Sep, 2017
 */
public class OrderDetail {
    private Long orderId;
    private Long tradedQuantity;
    private BigDecimal tradedPrice;
    private Date tradeDate;
    private String tradeTime;
    private Long bourseCompanyCommission;
    private Long brokerCommission;
    private Long supervisionCommission;
    private Long depositoryCommission;
    private Long technologyCommission;
    private Long commissionDifference;
    private Long tax;
    private Long totalValue;

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

    @Override
    public String toString() {
        return "OrderDetail{" +
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
                '}';
    }
}
