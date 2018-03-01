package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.market.activity.MarketActivity;
import com.sefryek.brokerpro.tadbir.dto.response.market.activity.MarketActivityTAdbir;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 25, Dec, 2016
 */
@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL)
public interface MarketActivityMapper extends SelmaObjectMapper<MarketActivityTAdbir, MarketActivity> {
}
