package com.sefryek.brokerpro.service.mapper;
/*
 * Copyright 2016 (C) syspod.co
 * 
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */

import com.sefryek.brokerpro.domain.Broker;
import org.springframework.stereotype.Component;

@Component
public class CustomBrokerPageMapper extends CustomPageMapper<Broker> {

    @Override
    public com.sefryek.brokerpro.dto.response.Page<Broker> as(org.springframework.data.domain.Page<Broker> in) {
        return super.as(in);
    }

}