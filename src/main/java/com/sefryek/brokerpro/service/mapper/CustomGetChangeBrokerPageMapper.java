package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.mobile.broker.ChangeBroker;
import org.springframework.stereotype.Component;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 29, May, 2017
 */
@Component
public class CustomGetChangeBrokerPageMapper extends CustomPageMapper<ChangeBroker> {

    @Override
    public com.sefryek.brokerpro.dto.response.Page<ChangeBroker> as(org.springframework.data.domain.Page<ChangeBroker> in) {
        return super.as(in);
    }

}
