package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.domain.ExchangeBroker;
import org.springframework.stereotype.Component;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 11, Nov, 2017
 */
@Component
public class CustomExchangeBrokerPageMapper extends CustomPageMapper<ExchangeBroker> {

    @Override
    public com.sefryek.brokerpro.dto.response.Page<ExchangeBroker> as(org.springframework.data.domain.Page<ExchangeBroker> in) {
        return super.as(in);
    }

}
