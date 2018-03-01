package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.mobile.peyment.WithdrawalList;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, May, 2017
 */
@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL, withCustom = CustomWithdrawalListPageMapper.class)
public interface WithdrawalListPageMapper extends SelmaObjectMapper<org.springframework.data.domain.Page<WithdrawalList>, com.sefryek.brokerpro.dto.response.Page<WithdrawalList>> {
}
