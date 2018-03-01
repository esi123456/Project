package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.mobile.portfolio.stock.DailyCustomerStockPortfolio;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 07, Aug, 2017
 */
@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL, withCustom = CustomDailyCustomerStockPortfolioPageMapper.class)
public interface DailyCustomerStockPortfolioPageMapper extends SelmaObjectMapper<org.springframework.data.domain.Page<DailyCustomerStockPortfolio>, com.sefryek.brokerpro.dto.response.Page<DailyCustomerStockPortfolio>> {
}