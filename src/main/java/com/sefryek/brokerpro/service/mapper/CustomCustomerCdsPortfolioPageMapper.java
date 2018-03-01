package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.mobile.portfolio.Portfolio;
import org.springframework.stereotype.Component;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 07, Aug, 2017
 */
@Component
public class CustomCustomerCdsPortfolioPageMapper extends CustomPageMapper<Portfolio> {

    @Override
    public com.sefryek.brokerpro.dto.response.Page<Portfolio> as(org.springframework.data.domain.Page<Portfolio> in) {
        return super.as(in);
    }

}