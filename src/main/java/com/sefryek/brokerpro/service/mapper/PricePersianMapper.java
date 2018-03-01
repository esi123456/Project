package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.market.price.Price;
import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 08, Mar, 2017
 */
@Mapper(withIoC = IoC.SPRING, withCustomFields = {@Field({"SymbolFa", "symbolShortName"}), @Field({"symbolCompleteNameFa", "symbolCompleteName"})}, withIgnoreMissing = IgnoreMissing.ALL)
public interface PricePersianMapper extends SelmaObjectMapper<com.sefryek.brokerpro.tadbir.dto.response.market.price.Price, Price> {
}
