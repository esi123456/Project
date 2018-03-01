package com.sefryek.brokerpro.repository.cache;
/*
 * Copyright 2016 (C) syspod.co
 *
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */

import com.sefryek.brokerpro.domain.DeviceType;
import com.sefryek.brokerpro.domain.Session;
import org.springframework.data.hazelcast.repository.HazelcastRepository;

public interface SessionCacheRepository extends HazelcastRepository<Session, String> {

    /**  count active seassions (users) **/
    long countByDeviceTypeAndExpiresGreaterThanEqual(DeviceType deviceType, long currentTimeMillis);

    /**  count active seassions (users) **/
    long countByBrokerCodeAndDeviceTypeAndExpiresGreaterThanEqual(String brokerCode, DeviceType deviceType, long currentTimeMillis);

    /**  count active and inactive seassions (users) **/
    long countByBrokerCode(String brokerCode);

    /**  count active and inactive seassions (users) **/
    long countByDeviceType(DeviceType deviceType);

    /**  count active and inactive seassions (users) **/
    long countByBrokerCodeAndDeviceType(String brokerCode, DeviceType deviceType);

    /**  count inactive seassions (users) **/
    long countByBrokerCodeAndDeviceTypeAndExpiresLessThan(String brokerCode, DeviceType deviceType, long currentTimeMillis);

}

