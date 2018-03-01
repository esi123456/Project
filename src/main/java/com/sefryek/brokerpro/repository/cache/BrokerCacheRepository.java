package com.sefryek.brokerpro.repository.cache;
/*
 * Author     : Ashkan Haghighi Kia
 * Email      : ashkan.haghighi.kia@gmail.com
 */

import com.sefryek.brokerpro.domain.Broker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.hazelcast.repository.HazelcastRepository;

import java.util.List;

public interface BrokerCacheRepository extends HazelcastRepository<Broker, String> {

    Broker findByCodeLikeAndDeviceTypeInAndActiveTrue(String code, List<String> deviceTypes);

    List<Broker> findAllByActiveTrue();

    Page<Broker> findByDeviceTypeInAndActiveTrue(List<String> deviceTypes, Pageable pageable);

    Broker findByCodeAndActiveTrue(String code);

    long countByDeviceTypeInAndActiveTrue(List<String> deviceTypes);

    List<Broker> findAll();

}

