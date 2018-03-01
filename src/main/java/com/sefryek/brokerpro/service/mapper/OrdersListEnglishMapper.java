package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.mobile.order.Order;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.order.OrderTadbir;
import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 12, Mar, 2017
 */
@Mapper(withIoC = IoC.SPRING, withCustomFields = @Field({"enSymbol", "symbolShortName"}), withIgnoreMissing = IgnoreMissing.ALL)
public interface OrdersListEnglishMapper extends SelmaObjectMapper<List<OrderTadbir>, List<Order>> {
}
