package com.sefryek.brokerpro.service.mapper;
/*
 * Copyright 2016 (C) syspod.co
 * 
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */

import com.sefryek.brokerpro.domain.Exchange;
import org.springframework.stereotype.Component;

@Component
public class CustomExchangePageMapper extends CustomPageMapper<Exchange> {

    @Override
    public com.sefryek.brokerpro.dto.response.Page<Exchange> as(org.springframework.data.domain.Page<Exchange> in) {
        return super.as(in);
    }

}