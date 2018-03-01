package com.sefryek.brokerpro.repository.cache;

import com.sefryek.brokerpro.domain.FinancialProvider;
import org.springframework.data.hazelcast.repository.HazelcastRepository;

import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 12, Aug, 2017
 */
public interface FinancialCacheRepository extends HazelcastRepository<FinancialProvider, String> {

    List<FinancialProvider> findByBrokerCodeAndLanguageAndActiveTrueOrderByFinancialIdAsc(String brokerCode, String language);

    FinancialProvider findByBrokerCodeAndFinancialIdAndLanguage(String brokerCode, Integer financialId, String language);

    List<FinancialProvider> findAll();

}
