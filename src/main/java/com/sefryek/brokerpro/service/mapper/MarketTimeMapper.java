package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.market.time.MarketTime;
import com.sefryek.brokerpro.tadbir.dto.response.time.MarketTimeTadbir;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 11, Feb, 2017
 */
@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL)
public interface MarketTimeMapper extends SelmaObjectMapper<MarketTimeTadbir, MarketTime> {
}
