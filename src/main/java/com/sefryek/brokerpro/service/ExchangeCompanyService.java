package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.domain.Exchange;
import com.sefryek.brokerpro.domain.enumeration.MarketCode;
import com.sefryek.brokerpro.dto.request.Language;
import com.sefryek.brokerpro.dto.request.Pageable;
import com.sefryek.brokerpro.dto.request.exchange.ExchangeBrokerRequest;
import com.sefryek.brokerpro.dto.response.DefaultResponse;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.repository.cache.ExchangeCacheRepository;
import com.sefryek.brokerpro.repository.mongo.ExchangeRepository;
import com.sefryek.brokerpro.service.mapper.ExchangeMapper;
import com.sefryek.brokerpro.service.mapper.ExchangePageMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.tadbir.dto.response.market.exchange.ExchangeCompanyDataTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.market.exchange.ExchangeCompanyTadbir;
import com.sefryek.brokerpro.utils.PersianUtils;
import com.sefryek.util.CollectionUtils;
import com.sefryek.util.ObjectUtils;
import com.sefryek.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @auther: Ashkan Haghighi Kia
 * @email: kia@syspod.co
 */
@Component
public class ExchangeCompanyService extends Service<ExchangeCompanyTadbir> {

    @Autowired
    private ExchangeCacheRepository exchangeCacheRepository;

    @Autowired
    private ExchangeRepository exchangeRepository;

    @Autowired
    private ExchangePageMapper exchangePageMapper;

    @Autowired
    private ExchangeMapper exchangeMapper;

    public ExchangeCompanyService() {
        super(ExchangeCompanyTadbir.class);
    }

    public Response<Page<Exchange>> findExchanges(ExchangeBrokerRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getLanguage());
        PageRequest pageRequest = getPageRequest(request);
        org.springframework.data.domain.Page<Exchange> page;
        String text = request.getTextForSearch();
        if (StringUtils.isEmptyOrBlank(text)) {
            page = exchangeCacheRepository.findByLanguageAndMarketCode(request.getLanguage().getCode(), MarketCode.NO, pageRequest);
        } else {
            if(Language.ENGLISH.equals(request.getLanguage())){
                page = exchangeCacheRepository.findByLanguageAndMarketCodeAndSymbolShortNameContainingIgnoreCase(request.getLanguage().getCode(), MarketCode.NO, text, pageRequest);
            } else {
                page = exchangeCacheRepository.findByLanguageAndMarketCodeAndSymbolShortNameContainingIgnoreCase(request.getLanguage().getCode(), MarketCode.NO, PersianUtils.convertArabicToPersian(text).toLowerCase(), pageRequest);
            }
        }
        Page<Exchange> result = exchangePageMapper.as(page);
        Response<Page<Exchange>> response = new Response<>();
        response.setResponse(result);
        createSuccessResponse(response);
        return response;
    }

    public Response<DefaultResponse> syncExchangesWithMongo() {
        syncExchangesWithMongoDb();
        Response<DefaultResponse> response = new Response<>();
        createSuccessResponse(response);
        return response;
    }

    private void syncExchangesWithMongoDb() {
        exchangeCacheRepository.save(exchangeRepository.findAll());
        //Some symbols maybe are removed (manually) from mongoDB, but there are still in cache, so they will remove from cache by below codes.
        Iterable<Exchange> exchangeCacheList = exchangeCacheRepository.findAll();
        for (Exchange exchangeCache : exchangeCacheList){
            Exchange exchangeMongoDb = exchangeRepository.findOne(exchangeCache.getId());
            if(exchangeMongoDb == null){
                exchangeCacheRepository.delete(exchangeCache.getId());
            }
        }
    }

    private Exchange findOne(String isin) {
        return exchangeCacheRepository.findOne(isin);
    }

    public synchronized void syncExchangeCompanyWithTadbir() {
        ExchangeCompanyTadbir exchangeCompanyTadbir = findAllExchangeSymbolsFromTadbir();
        syncExchangesWithMongoDb();
        if (ObjectUtils.isNotNull(exchangeCompanyTadbir) && CollectionUtils.isNotEmpty(exchangeCompanyTadbir.getExchangeCompanyData())) {
            List<ExchangeCompanyDataTadbir> exchangeCompanyDataList = exchangeCompanyTadbir.getExchangeCompanyData();
            List<Exchange> exchanges = exchangeMapper.as(exchangeCompanyDataList);
            save(exchanges);
        }
    }

    private ExchangeCompanyTadbir findAllExchangeSymbolsFromTadbir() {
        ExchangeCompanyTadbir responseTadbir = new ExchangeCompanyTadbir();
        int page = 0;
        int size = 100;
        Pageable pageable = new Pageable(page, size);
        do{
            pageable.setPage(page);
            UrlBuilder urlBuilder = new UrlBuilder(createMarketUrl(Constants.MARKET_SYMBOL_URL), true, pageable);
//            urlBuilder.addEqualFilter("MarketCode", "NO"); //todo because in realtimePortfolio added some exchanges from another markets after fix it we can uncomment this line
            ExchangeCompanyTadbir tempResponseTadbir = callWebServiceHttpMethodGET(urlBuilder);
            if(tempResponseTadbir.isSuccessful()){
                responseTadbir.setSuccessful(tempResponseTadbir.isSuccessful());
                if(responseTadbir.getExchangeCompanyData() == null){ //first loop
                    responseTadbir.setExchangeCompanyData(new ArrayList<>());
                    responseTadbir.setTotalRecord(tempResponseTadbir.getTotalRecord());
                }
                responseTadbir.getExchangeCompanyData().addAll(tempResponseTadbir.getExchangeCompanyData());
            } else {
//                responseTadbir = null;
                break;
            }
            page++;
        } while (responseTadbir.getExchangeCompanyData().size() < responseTadbir.getTotalRecord());
        return responseTadbir;
    }

    @Transactional
    private void save(List<Exchange> exchanges) {
        exchangeRepository.save(exchanges);
        exchangeCacheRepository.save(exchanges);
    }

    public Exchange findBySymbolISINAndLanguage(String symbolISIN, String language) {
        return exchangeCacheRepository.findOneBySymbolISINAndLanguageAndMarketCode(symbolISIN, language, MarketCode.NO);
    }

}
