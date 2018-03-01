package com.sefryek.brokerpro.dto.response.market.history;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 26, Dec, 2016
 */
public class HistoryData {

    private Date dateTime;
    private BigDecimal value;

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "HistoryData{" +
                "dateTime=" + dateTime +
                ", value=" + value +
                '}';
    }
}
