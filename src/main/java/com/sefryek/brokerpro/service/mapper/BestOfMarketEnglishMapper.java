package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.tadbir.dto.response.market.price.Price;
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
 * @date: 08, Jan, 2017
 */
@Mapper(withIoC = IoC.SPRING, withCustomFields = @Field({"entitle", "title"}), withIgnoreMissing = IgnoreMissing.ALL)
public interface BestOfMarketEnglishMapper extends SelmaObjectMapper<List<Price>, List<com.sefryek.brokerpro.dto.response.market.price.Price>> {
}
