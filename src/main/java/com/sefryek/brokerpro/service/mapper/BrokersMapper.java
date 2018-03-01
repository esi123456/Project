package com.sefryek.brokerpro.service.mapper;
/*
 * Copyright 2016 (C) syspod.co
 * 
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */

import com.sefryek.brokerpro.domain.Broker;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

import java.util.List;

@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL)
//        withIgnoreFields = {
//                "com.sefryek.brokerpro.tadbir.dto.response.market.broker.Broker.additionalproperties",
//                "com.sefryek.brokerpro.domain.Broker.active",
//                "com.sefryek.brokerpro.domain.Broker.createdby",
//                "com.sefryek.brokerpro.domain.Broker.createddate",
//                "com.sefryek.brokerpro.domain.Broker.lastmodifiedby",
//                "com.sefryek.brokerpro.domain.Broker.lastmodifieddate",
//                "com.sefryek.brokerpro.domain.Broker.createdby",
//                "com.sefryek.brokerpro.domain.Broker.createddate",
//                "com.sefryek.brokerpro.domain.Broker.lastmodifiedby",
//                "com.sefryek.brokerpro.domain.Broker.lastmodifieddate"
//        })
public interface BrokersMapper extends SelmaObjectMapper<List<com.sefryek.brokerpro.tadbir.dto.response.market.broker.Broker>, List<Broker>> {
}