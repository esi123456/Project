package com.sefryek.brokerpro.repository.cache;

import com.sefryek.brokerpro.domain.ExchangeBroker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.hazelcast.repository.HazelcastRepository;

import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 11, Nov, 2017
 *
 *      Note for In all methods:  we save ExchangeBrokers in db that are isApproved=true and isTradeAble=true so we don't need to search by this tow parameter.
 *     If we change the rule of above in save to db, we have to change this method too (by filtering isApproved=true and isTradeAble=true)
 */
public interface ExchangeBrokerCacheRepository extends HazelcastRepository<ExchangeBroker, String> {

    Page<ExchangeBroker> findByLanguageAndBrokerCode(String language, String brokerCode, Pageable pageable);

    List<ExchangeBroker> findByLanguageAndBrokerCodeAndSymbolShortNameStartingWithIgnoreCaseOrderBySymbolShortName(String language, String brokerCode, String textForSearch);

    List<ExchangeBroker> findByLanguageAndBrokerCodeAndTextForSearchShortContainingIgnoreCaseOrderBySymbolShortName(String language, String brokerCode, String textForSearch);

    List<ExchangeBroker> findByLanguageAndBrokerCodeAndSymbolCompleteNameStartingWithIgnoreCaseOrderBySymbolCompleteName(String language, String brokerCode, String textForSearch);

    List<ExchangeBroker> findByLanguageAndBrokerCodeAndTextForSearchCompleteContainingIgnoreCaseOrderBySymbolCompleteName(String language, String brokerCode, String textForSearch);

    ExchangeBroker findOneBySymbolISINAndLanguageAndBrokerCode(String symbolISIN, String language, String brokerCode);
}
