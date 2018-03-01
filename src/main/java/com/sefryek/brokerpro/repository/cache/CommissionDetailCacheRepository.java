package com.sefryek.brokerpro.repository.cache;

import com.sefryek.brokerpro.domain.CommissionDetail;
import org.springframework.data.hazelcast.repository.HazelcastRepository;

import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 15, Aug, 2017
 */
public interface CommissionDetailCacheRepository extends HazelcastRepository<CommissionDetail, String> {

    List<CommissionDetail> findByBrokerCode(String brokerCode);

    CommissionDetail findByBrokerCodeAndMarketUnitAndOrderSideAndCommissionType(String brokerCode, String marketUnit, String orderSide, String commissionType);

    List<CommissionDetail> findAll();

}
