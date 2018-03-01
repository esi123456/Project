package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.mobile.order.AddOrModifyOrder;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.order.AddOrModifyOrderTadbir;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

/**
 * Copyright 2016 (C) syspod.co
 * <p>
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */
@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL)
public interface AddOrModifyOrderMapper extends SelmaObjectMapper<AddOrModifyOrderTadbir, AddOrModifyOrder> {
}

