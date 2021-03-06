package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.mobile.alert.ConditionsData;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.alert.ConditionsDataTadbir;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 30, Apr, 2017
 */
@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL)
public interface ConditionsDataMapper extends SelmaObjectMapper<List<ConditionsDataTadbir>, List<ConditionsData>> {
}
