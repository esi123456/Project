package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.domain.CommissionDetail;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.commission.CommissionDetailTadbir;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, Jul, 2017
 */
@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL, withCustom = CustomCommissionDetailMapper.class)
public interface CommissionDetailMapper extends SelmaObjectMapper<List<CommissionDetailTadbir>, List<CommissionDetail>> {
}
