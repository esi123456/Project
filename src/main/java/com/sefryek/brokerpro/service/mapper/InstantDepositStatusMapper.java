package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.mobile.peyment.InstantDepositStatus;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.payment.MoneyTransferStatusTadbir;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 16, May, 2017
 */
@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL)
public interface InstantDepositStatusMapper extends SelmaObjectMapper<MoneyTransferStatusTadbir, InstantDepositStatus> {
}
