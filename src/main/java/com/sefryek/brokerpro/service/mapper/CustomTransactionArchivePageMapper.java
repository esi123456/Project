package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.mobile.peyment.TransactionArchive;
import org.springframework.stereotype.Component;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 30, May, 2017
 */
@Component
public class CustomTransactionArchivePageMapper extends CustomPageMapper<TransactionArchive> {

    @Override
    public com.sefryek.brokerpro.dto.response.Page<TransactionArchive> as(org.springframework.data.domain.Page<TransactionArchive> in) {
        return super.as(in);
    }

}
