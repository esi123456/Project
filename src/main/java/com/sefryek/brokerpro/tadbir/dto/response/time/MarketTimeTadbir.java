package com.sefryek.brokerpro.tadbir.dto.response.time;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sefryek.brokerpro.config.jackson.JavaDateDeserializer;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirResponse;

import java.util.Date;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 08, Feb, 2017
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MarketTimeTadbir extends TadbirResponse {

    @JsonProperty("TotalSeconds")
    private Long totalSeconds;
    @JsonDeserialize(using = JavaDateDeserializer.class)
    @JsonProperty("Date")
    private Date marketTime;

    public Long getTotalSeconds() {
        return totalSeconds;
    }

    public void setTotalSeconds(Long totalSeconds) {
        this.totalSeconds = totalSeconds;
    }

    public Date getMarketTime() {
        return marketTime;
    }

    public void setMarketTime(Date marketTime) {
        this.marketTime = marketTime;
    }

    @Override
    public String toString() {
        return "MarketTimeTadbir{" +
                "totalSeconds=" + totalSeconds +
                ", marketTime=" + marketTime +
                "} " + super.toString();
    }
}
