package com.sefryek.brokerpro.service.mapper;
/*
 * Copyright 2016 (C) syspod.co
 * 
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */

import com.sefryek.brokerpro.dto.response.mobile.order.Order;
import org.springframework.stereotype.Component;

@Component
public class CustomOrderPageMapper extends CustomPageMapper<Order> {

    @Override
    public com.sefryek.brokerpro.dto.response.Page<Order> as(org.springframework.data.domain.Page<Order> in) {
        return super.as(in);
    }

}