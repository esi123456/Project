package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.gateway.LoginGateway;
import com.sefryek.brokerpro.tadbir.dto.response.LoginGatewayTadbir;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 10, Jul, 2017
 */
@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL, withCustom = CustomLoginGatewayMapper.class)
public interface LoginGatewayMapper extends SelmaObjectMapper<LoginGatewayTadbir, LoginGateway> {
}
