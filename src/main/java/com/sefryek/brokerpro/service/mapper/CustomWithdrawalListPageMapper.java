package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.mobile.peyment.WithdrawalList;
import org.springframework.stereotype.Component;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, May, 2017
 */
@Component
public class CustomWithdrawalListPageMapper extends CustomPageMapper<WithdrawalList> {

    @Override
    public com.sefryek.brokerpro.dto.response.Page<WithdrawalList> as(org.springframework.data.domain.Page<WithdrawalList> in) {
        return super.as(in);
    }

}
