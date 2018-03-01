package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.mobile.broker.ChangeBroker;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.broker.GetChangeBrokerTadbir;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 29, May, 2017
 */
@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL)
public interface ChangeBrokerMapper extends SelmaObjectMapper<List<GetChangeBrokerTadbir>, List<ChangeBroker>> {
}
