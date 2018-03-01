package com.sefryek.brokerpro.repository.mongo;

import com.sefryek.brokerpro.domain.BrokerInfo;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 12, Aug, 2017
 */
public interface BrokerInfoRepository extends GeneralRepository<BrokerInfo> {

    BrokerInfo findByCode(String code);
}

