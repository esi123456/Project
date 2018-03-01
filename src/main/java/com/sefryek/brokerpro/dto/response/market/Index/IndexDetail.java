package com.sefryek.brokerpro.dto.response.market.Index;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 28, May, 2017
 */
public class IndexDetail {
    private String indexISIN;
    private String indexName;
    private BigDecimal lastValue;
    private BigDecimal changeReal;
    private BigDecimal changePercent;
    private Date dateTime;

    public String getIndexISIN() {
        return indexISIN;
    }

    public void setIndexISIN(String indexISIN) {
        this.indexISIN = indexISIN;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public BigDecimal getLastValue() {
        return lastValue;
    }

    public void setLastValue(BigDecimal lastValue) {
        this.lastValue = lastValue;
    }

    public BigDecimal getChangeReal() {
        return changeReal;
    }

    public void setChangeReal(BigDecimal changeReal) {
        this.changeReal = changeReal;
    }

    public BigDecimal getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(BigDecimal changePercent) {
        this.changePercent = changePercent;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "IndexDetail{" +
                "indexISIN='" + indexISIN + '\'' +
                ", indexName='" + indexName + '\'' +
                ", lastValue=" + lastValue +
                ", changeReal=" + changeReal +
                ", changePercent=" + changePercent +
                ", dateTime=" + dateTime +
                '}';
    }
}
