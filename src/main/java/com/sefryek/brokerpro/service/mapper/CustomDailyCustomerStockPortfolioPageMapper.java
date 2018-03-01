package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.mobile.portfolio.stock.DailyCustomerStockPortfolio;
import org.springframework.stereotype.Component;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 07, Aug, 2017
 */
@Component
public class CustomDailyCustomerStockPortfolioPageMapper extends CustomPageMapper<DailyCustomerStockPortfolio> {
    @Override
    public com.sefryek.brokerpro.dto.response.Page<DailyCustomerStockPortfolio> as(org.springframework.data.domain.Page<DailyCustomerStockPortfolio> in) {
        return super.as(in);
    }

}