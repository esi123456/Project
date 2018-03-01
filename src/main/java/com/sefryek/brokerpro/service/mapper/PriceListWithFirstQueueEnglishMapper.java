package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.market.price.first.PriceWithFirstQueue;
import com.sefryek.brokerpro.dto.response.market.queue.Queue;
import com.sefryek.brokerpro.tadbir.dto.response.market.price.first.PriceWithFirstQueueTadbir;
import fr.xebia.extras.selma.*;

import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 06, Mar, 2017
 */
@Mapper(withIoC = IoC.SPRING, withCustomFields = {
        @Field({"symbolShortNameEn", "symbolShortName"}),
        @Field({"symbolCompleteNameEn", "symbolCompleteName"})},
        withIgnoreMissing = IgnoreMissing.ALL)
public interface PriceListWithFirstQueueEnglishMapper extends SelmaObjectMapper<List<PriceWithFirstQueueTadbir>, List<PriceWithFirstQueue>> {

    @Maps(withIgnoreMissing = IgnoreMissing.ALL)
    public Queue asQueueFirstRow(Queue queue);

}



