package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.mobile.portfolio.RealTimePortfolioList;
import org.springframework.stereotype.Component;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 07, Aug, 2017
 */
@Component
public class CustomRealTimePortfolioListPageMapper extends CustomPageMapper<RealTimePortfolioList> {

    @Override
    public com.sefryek.brokerpro.dto.response.Page<RealTimePortfolioList> as(org.springframework.data.domain.Page<RealTimePortfolioList> in) {
        return super.as(in);
    }

}