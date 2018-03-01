package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.mobile.peyment.DepositList;
import org.springframework.stereotype.Component;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 20, May, 2017
 */
@Component
public class CustomDepositListPageMapper extends CustomPageMapper<DepositList> {

    @Override
    public com.sefryek.brokerpro.dto.response.Page<DepositList> as(org.springframework.data.domain.Page<DepositList> in) {
        return super.as(in);
    }

}
