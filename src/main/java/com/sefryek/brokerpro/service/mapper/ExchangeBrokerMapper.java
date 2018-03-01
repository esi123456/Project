package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.domain.ExchangeBroker;
import com.sefryek.brokerpro.tadbir.dto.response.market.exchange.broker.ExchangeBrokerDataTadbir;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 11, Nov, 2017
 */
@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL, withCustom = CustomExchangeBrokerMapper.class)
public interface ExchangeBrokerMapper extends SelmaObjectMapper<List<ExchangeBrokerDataTadbir>, List<ExchangeBroker>> {
}
