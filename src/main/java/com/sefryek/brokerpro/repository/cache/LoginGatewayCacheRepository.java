package com.sefryek.brokerpro.repository.cache;

import com.sefryek.brokerpro.dto.response.gateway.LoginGateway;
import org.springframework.data.hazelcast.repository.HazelcastRepository;

import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 10, Jul, 2017
 */
public interface LoginGatewayCacheRepository extends HazelcastRepository<LoginGateway, String> {

    LoginGateway findByBrokerCode(String brokerCode);

    List<LoginGateway> findAll();

}
