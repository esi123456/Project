package com.sefryek.brokerpro.service.mapper;
/*
 * Copyright 2016 (C) syspod.co
 * 
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */

import com.sefryek.brokerpro.dto.response.market.time.MarketTime;
import com.sefryek.brokerpro.tadbir.dto.response.time.MarketTimeTadbir;
import com.sefryek.brokerpro.utils.DateUtils;
import com.sefryek.util.ObjectUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CustomMarketTimeMapper implements SelmaObjectMapper<MarketTimeTadbir, MarketTime> {

    @Override
    public MarketTime as(MarketTimeTadbir in) {
        if (ObjectUtils.isNotNull(in)) {
            MarketTime marketTime = new MarketTime();
            marketTime.setMarketTime(convertToDate(in.getTotalSeconds()));
            return marketTime;
        }
        return null;
    }

    private Date convertToDate(Long totalSeconds) {
        Date date = DateUtils.startOfToday();
        Date result = new Date();
        result.setTime(date.getTime() + (totalSeconds * 1000));
        return result;
    }


}