package com.sefryek.brokerpro.service.mobile.exchange;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.domain.Broker;
import com.sefryek.brokerpro.domain.ExchangeBroker;
import com.sefryek.brokerpro.domain.Session;
import com.sefryek.brokerpro.dto.request.Language;
import com.sefryek.brokerpro.dto.request.Pageable;
import com.sefryek.brokerpro.dto.request.exchange.ExchangeBrokerRequest;
import com.sefryek.brokerpro.dto.response.DefaultResponse;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.repository.cache.BrokerCacheRepository;
import com.sefryek.brokerpro.repository.cache.ExchangeBrokerCacheRepository;
import com.sefryek.brokerpro.repository.mongo.ExchangeBrokerRepository;
import com.sefryek.brokerpro.service.AuthStrategy;
import com.sefryek.brokerpro.service.Service;
import com.sefryek.brokerpro.service.mapper.ExchangeBrokerMapper;
import com.sefryek.brokerpro.service.mapper.ExchangeBrokerPageMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.session.SessionManager;
import com.sefryek.brokerpro.tadbir.dto.response.market.exchange.broker.ExchangeBrokerTadbir;
import com.sefryek.brokerpro.utils.PersianUtils;
import com.sefryek.util.CollectionUtils;
import com.sefryek.util.ObjectUtils;
import com.sefryek.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 11, Nov, 2017
 */
@Component
public class ExchangeBrokerService extends Service<ExchangeBrokerTadbir> {

    @Autowired
    private ExchangeBrokerCacheRepository exchangeBrokerCacheRepository;

    @Autowired
    private ExchangeBrokerRepository exchangeBrokerRepository;

    @Autowired
    private ExchangeBrokerPageMapper exchangeBrokerPageMapper;

    @Autowired
    private ExchangeBrokerMapper exchangeBrokerMapper;

    @Autowired
    private SessionManager sessionManager;

    @Autowired
    private BrokerCacheRepository brokerCacheRepository;

    public ExchangeBrokerService() {
        super(ExchangeBrokerTadbir.class);
    }

    public Response<Page<ExchangeBroker>> findExchanges(ExchangeBrokerRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getLanguage());
        Assert.notNull(request.getToken());
        PageRequest pageRequest = getPageRequest(request);
        org.springframework.data.domain.Page<ExchangeBroker> page;
        Page<ExchangeBroker> result;
        List<ExchangeBroker> out = new LinkedList<>();
        String text = request.getTextForSearch();
        Session session = sessionManager.getSession(request.getToken());
        Assert.notNull(session);
        if (StringUtils.isEmptyOrBlank(text)) {
            page = exchangeBrokerCacheRepository.findByLanguageAndBrokerCode(request.getLanguage().getCode(), session.getBrokerCode(), pageRequest);
            result = exchangeBrokerPageMapper.as(page);
        } else {
            if(Language.ENGLISH.equals(request.getLanguage())){
                out.addAll(findAndSortAllByTextForSearch(request, session, text));
            } else {
                out.addAll(findAndSortAllByTextForSearch(request, session, PersianUtils.convertArabicToPersian(text).toLowerCase()));
            }
            PageImpl<ExchangeBroker> orderPage = new PageImpl<>(out, new PageRequest(request.getPageable().getPage(), request.getPageable().getSize()), out.size());
            result = exchangeBrokerPageMapper.as(orderPage);
        }
        Response<Page<ExchangeBroker>> response = new Response<>();
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
        exchangeBrokerCacheRepository.save(exchangeBrokerRepository.findAll());
        //Some symbols maybe are removed (manually) from mongoDB, but there are still in cache, so they will remove from cache by below codes.
        Iterable<ExchangeBroker> exchangeCacheList = exchangeBrokerCacheRepository.findAll();
        for (ExchangeBroker exchangeCache : exchangeCacheList){
            ExchangeBroker exchangeMongoDb = exchangeBrokerRepository.findOne(exchangeCache.getId());
            if(exchangeMongoDb == null){
                exchangeBrokerCacheRepository.delete(exchangeCache.getId());
            }
        }
    }

    private ExchangeBroker findOne(String isin) {
        return exchangeBrokerCacheRepository.findOne(isin);
    }

    public synchronized void syncExchangeBrokerWithTadbir() {
        List<ExchangeBroker> result = findAllSymbolsForBrokers();
        syncExchangesWithMongoDb();
        if (ObjectUtils.isNotNull(result) && CollectionUtils.isNotEmpty(result)) {
            save(result);
        }
    }

    private List<ExchangeBroker> findAllSymbolsForBrokers(){
        List<ExchangeBroker> result = new LinkedList<>();

        List<Broker> brokers = brokerCacheRepository.findAllByActiveTrue();
        for (Broker broker : brokers) {
            if (StringUtils.isNotEmpty(broker.getBrokerUrl())) {
                ExchangeBrokerTadbir exchangeBrokerTadbir = findAllExchangeSymbolsFromTadbir(broker);
                if (ObjectUtils.isNotNull(exchangeBrokerTadbir) && CollectionUtils.isNotEmpty(exchangeBrokerTadbir.getExchangeBrokerData())) {
                    for(int i=0; i < exchangeBrokerTadbir.getExchangeBrokerData().size(); i++){
                        exchangeBrokerTadbir.getExchangeBrokerData().get(i).setBrokerCode(broker.getCode());
                    }
                    List<ExchangeBroker> exchanges = exchangeBrokerMapper.as(exchangeBrokerTadbir.getExchangeBrokerData());
                    result.addAll(exchanges);
                }
            }
        }

        return result;
    }

    private ExchangeBrokerTadbir findAllExchangeSymbolsFromTadbir(Broker broker ) {
        ExchangeBrokerTadbir responseTadbir = new ExchangeBrokerTadbir();
        int page = 0;
        int size = 100;
        Pageable pageable = new Pageable(page, size);
        do{
            pageable.setPage(page);
            UrlBuilder urlBuilder = new UrlBuilder(createMobileUrlByBroker(broker, Constants.MOBILE_SYMBOL_URL), true, pageable);
            urlBuilder.addEqualFilter("IsApproved", true);
            urlBuilder.addEqualFilter("IsTradable", true);
            ExchangeBrokerTadbir tempResponseTadbir = callWebServiceHttpMethodGET(urlBuilder, AuthStrategy.GATEWAY, broker.getCode());
            if(ObjectUtils.isNotNull(tempResponseTadbir) && tempResponseTadbir.isSuccessful()){
                responseTadbir.setSuccessful(tempResponseTadbir.isSuccessful());
                if(responseTadbir.getExchangeBrokerData() == null){ //first loop
                    responseTadbir.setExchangeBrokerData(new ArrayList<>());
                    responseTadbir.setTotalRecord(tempResponseTadbir.getTotalRecord());
                }
                responseTadbir.getExchangeBrokerData().addAll(tempResponseTadbir.getExchangeBrokerData());
            } else {
//                responseTadbir = null;
                break;
            }
            page++;
        } while (responseTadbir.getExchangeBrokerData().size() < responseTadbir.getTotalRecord());
        return responseTadbir;
    }

    @Transactional
    private void save(List<ExchangeBroker> exchanges) {
        exchangeBrokerRepository.save(exchanges);
        exchangeBrokerCacheRepository.save(exchanges);
    }

    public ExchangeBroker findBySymbolISINAndLanguageAndBrokerCode(String symbolISIN, String language, String brokerCode) {
        return exchangeBrokerCacheRepository.findOneBySymbolISINAndLanguageAndBrokerCode(symbolISIN, language, brokerCode);
    }

    /**
     * SEQUENCE IS IMPORTANT
     * Tadbir wants to sort symbols in search by this sequence:
     * 1- symbolShortName starts with.
     * 2- symbolShortName contains.
     * 3- symbolCompleteName starts with.
     * 4- symbolCompleteName contains.
     */
    private List<ExchangeBroker> findAndSortAllByTextForSearch(ExchangeBrokerRequest request, Session session, String textForSearch){
        List<ExchangeBroker> result = new LinkedList<>();
        result.addAll(exchangeBrokerCacheRepository.findByLanguageAndBrokerCodeAndSymbolShortNameStartingWithIgnoreCaseOrderBySymbolShortName(request.getLanguage().getCode(), session.getBrokerCode(), textForSearch));
        result.addAll(filterList(result, exchangeBrokerCacheRepository.findByLanguageAndBrokerCodeAndTextForSearchShortContainingIgnoreCaseOrderBySymbolShortName(request.getLanguage().getCode(), session.getBrokerCode(), textForSearch)));
        result.addAll(filterList(result, exchangeBrokerCacheRepository.findByLanguageAndBrokerCodeAndSymbolCompleteNameStartingWithIgnoreCaseOrderBySymbolCompleteName(request.getLanguage().getCode(), session.getBrokerCode(), textForSearch)));
        result.addAll(filterList(result, exchangeBrokerCacheRepository.findByLanguageAndBrokerCodeAndTextForSearchCompleteContainingIgnoreCaseOrderBySymbolCompleteName(request.getLanguage().getCode(), session.getBrokerCode(), textForSearch)));
        return result;
    }

    private List<ExchangeBroker> filterList(List<ExchangeBroker> in, List<ExchangeBroker> out){
        List<ExchangeBroker> result = new LinkedList<>();
        if(CollectionUtils.isNotEmpty(in) && CollectionUtils.isNotEmpty(out)){
            for(ExchangeBroker tempOut : out){
                boolean find = false;
                for(ExchangeBroker tempIn : in){
                    if(tempIn.getSymbolISIN().equalsIgnoreCase(tempOut.getSymbolISIN())){
                        find = true;
                        break;
                    }
                }
                if(!find){
                    result.add(tempOut);
                }
            }
        }
        if(CollectionUtils.isEmpty(in) && CollectionUtils.isNotEmpty(out)){
            result.addAll(out);
        }
        return result;
    }

}
