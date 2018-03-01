package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.domain.ExchangeBroker;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 11, Nov, 2017
 */
@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL, withCustom = CustomExchangeBrokerPageMapper.class)
public interface ExchangeBrokerPageMapper extends SelmaObjectMapper<org.springframework.data.domain.Page<ExchangeBroker>, com.sefryek.brokerpro.dto.response.Page<ExchangeBroker>> {

}
