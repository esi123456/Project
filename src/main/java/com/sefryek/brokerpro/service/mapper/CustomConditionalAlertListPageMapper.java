package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.mobile.alert.ConditionalAlertList;
import org.springframework.stereotype.Component;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 29, Apr, 2017
 */
@Component
public class CustomConditionalAlertListPageMapper extends CustomPageMapper<ConditionalAlertList> {

    @Override
    public com.sefryek.brokerpro.dto.response.Page<ConditionalAlertList> as(org.springframework.data.domain.Page<ConditionalAlertList> in) {
        return super.as(in);
    }

}
