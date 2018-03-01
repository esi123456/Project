package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.mobile.portfolio.stock.DailyCustomerStockPortfolio;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.portfolio.stock.CustomerStockPortfolioTadbir;
import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, Apr, 2017
 */
@Mapper(withIoC = IoC.SPRING, withCustomFields = @Field({"enSymbol", "symbolShortName"}), withIgnoreMissing = IgnoreMissing.ALL)
public interface DailyCustomerStockPortfolioEnglishMapper extends SelmaObjectMapper<List<CustomerStockPortfolioTadbir>, List<DailyCustomerStockPortfolio>> {
}
