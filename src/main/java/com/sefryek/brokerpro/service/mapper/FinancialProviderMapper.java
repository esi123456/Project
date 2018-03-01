package com.sefryek.brokerpro.service.mapper;
/*
 * Copyright 2016 (C) syspod.co
 * 
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */

import com.sefryek.brokerpro.domain.FinancialProvider;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.financial.FinancialProviderTadbir;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

import java.util.List;

@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL, withCustom = CustomFinancialProviderMapper.class)
public interface FinancialProviderMapper extends SelmaObjectMapper<List<FinancialProviderTadbir>, List<FinancialProvider>> {

}