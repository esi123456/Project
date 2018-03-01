package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.market.price.first.PriceWithFirstQueue;
import com.sefryek.brokerpro.dto.response.market.price.first.QueueFirstRow;
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
        @Field({"symbolShortNameFa", "symbolShortName"}),
        @Field({"symbolCompleteNameFa", "symbolCompleteName"})},
        withIgnoreMissing = IgnoreMissing.ALL)
public interface PriceListWithFirstQueuePersianMapper extends SelmaObjectMapper<List<PriceWithFirstQueueTadbir>, List<PriceWithFirstQueue>> {

    @Maps(withIgnoreMissing = IgnoreMissing.ALL)
    public QueueFirstRow asQueueFirstRow(QueueFirstRow queueFirstRow);
}
