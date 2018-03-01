package com.sefryek.brokerpro.repository.cache;

import com.sefryek.brokerpro.domain.Exchange;
import com.sefryek.brokerpro.domain.enumeration.MarketCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.hazelcast.repository.HazelcastRepository;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @auther: Ashkan Haghighi Kia
 * @email: kia@syspod.co
 */
public interface ExchangeCacheRepository extends HazelcastRepository<Exchange, String> {

    Exchange findOneBySymbolISINAndLanguageAndMarketCode(String symbolISIN, String language, MarketCode marketCode);

    Exchange findOneBySymbolISINAndLanguage(String symbolISIN, String language);

    Page<Exchange> findByLanguageAndMarketCode(String language, MarketCode marketCode, Pageable pageable);

    Page<Exchange> findByLanguageAndMarketCodeAndTextForSearchContainingIgnoreCase(String language, MarketCode marketCode, String textForSearch, Pageable pageable);

    Page<Exchange> findByLanguageAndMarketCodeAndSymbolShortNameContainingIgnoreCase(String language, MarketCode marketCode, String symbolShortName, Pageable pageable);

}

