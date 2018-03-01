package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.mobile.alert.ConditionalAlertList;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 29, Apr, 2017
 */
@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL, withCustom = CustomConditionalAlertListPageMapper.class)
public interface ConditionalAlertListPageMapper extends SelmaObjectMapper<org.springframework.data.domain.Page<ConditionalAlertList>, com.sefryek.brokerpro.dto.response.Page<ConditionalAlertList>> {
}
