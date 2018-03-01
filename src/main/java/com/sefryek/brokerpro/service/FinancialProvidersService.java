package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.domain.Broker;
import com.sefryek.brokerpro.domain.FinancialProvider;
import com.sefryek.brokerpro.dto.request.EmptyRequest;
import com.sefryek.brokerpro.dto.request.Language;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.repository.cache.BrokerCacheRepository;
import com.sefryek.brokerpro.repository.cache.FinancialCacheRepository;
import com.sefryek.brokerpro.repository.mongo.FinancialRepository;
import com.sefryek.brokerpro.service.mapper.FinancialProviderMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.financial.FinancialProviderTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.financial.FinancialProvidersTadbir;
import com.sefryek.util.CollectionUtils;
import com.sefryek.util.ObjectUtils;
import com.sefryek.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 30, Jan, 2017
 */
@Component
public class FinancialProvidersService extends Service<FinancialProvidersTadbir> {

    @Autowired
    private FinancialProviderMapper financialProviderMapper;

    @Autowired
    private BrokerCacheRepository brokerCacheRepository;

    @Autowired
    private FinancialRepository financialRepository;

    @Autowired
    private FinancialCacheRepository financialCacheRepository;

    public FinancialProvidersService() {
        super(FinancialProvidersTadbir.class);
    }

    public Response<List<FinancialProvider>> findFinancialProviders(EmptyRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        Response<List<FinancialProvider>> result = new Response<>();
        List<FinancialProvider> financialList = new ArrayList<>();
        if(request.getLanguage()!=null && Language.ENGLISH.equals(request.getLanguage())){
            financialList.addAll(financialCacheRepository.findByBrokerCodeAndLanguageAndActiveTrueOrderByFinancialIdAsc(findBrokerCodeByToken(request.getToken()), request.getLanguage().getCode()));
        } else {
            financialList.addAll(financialCacheRepository.findByBrokerCodeAndLanguageAndActiveTrueOrderByFinancialIdAsc(findBrokerCodeByToken(request.getToken()), Language.PERSIAN.getCode()));
        }
        result.setResponse(financialList);
        createSuccessResponse(result);
        return result;
    }

    private void syncFinancialWithMongoDb() {
        financialCacheRepository.save(financialRepository.findAll());
    }

    public synchronized void syncFinancialWithTadbir() {
        List<FinancialProvidersTadbir> fainancialListTB = findAllFinancialFromTadbir(Boolean.FALSE);
        syncFinancialWithMongoDb();
        List<FinancialProvider> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(fainancialListTB)) {
            for (FinancialProvidersTadbir financialTB : fainancialListTB) {
                List<FinancialProviderTadbir> tadbirList = financialTB.getFinancialProviders();
                List<FinancialProvider> financialList = financialProviderMapper.as(tadbirList);
                result.addAll(financialList);
            }
            if (CollectionUtils.isNotEmpty(result)) {
                saveAndInactiveOldFinancial(result);
            }
        }

    }

    public List<FinancialProvidersTadbir> findAllFinancialFromTadbir(Boolean active) {
        List<FinancialProvidersTadbir> result = new ArrayList<>();
        List<Broker> brokers = brokerCacheRepository.findAllByActiveTrue();
        for (Broker broker : brokers) {
            if (StringUtils.isNotEmpty(broker.getBrokerUrl())) {
                UrlBuilder urlBuilder = new UrlBuilder(createMobileUrlByBroker(broker, Constants.FINANCIAL_PROVIDERS_URL));
                urlBuilder.appendUrl(active);
                FinancialProvidersTadbir responseTadbir = callWebServiceHttpMethodGET(urlBuilder, AuthStrategy.GATEWAY, broker.getCode());
                if (ObjectUtils.isNotNull(responseTadbir) && responseTadbir.isSuccessful() && CollectionUtils.isNotEmpty(responseTadbir.getFinancialProviders())) {
                    for (int i = 0; i < responseTadbir.getFinancialProviders().size(); i++) {
                        responseTadbir.getFinancialProviders().get(i).setBrokerCode(broker.getCode());
                    }
                    result.add(responseTadbir);
                }
            }
        }
        return result;
    }

    @Transactional
    public void saveAndInactiveOldFinancial(List<FinancialProvider> financialList) {
        inactiveAllFinancial();
        financialCacheRepository.save(financialRepository.save(financialList));
    }

    private void inactiveAllFinancial(){
        List<FinancialProvider> financialRepo = financialRepository.findAll();
        if(CollectionUtils.isNotEmpty(financialRepo)){
            for(FinancialProvider financialProvider : financialRepo){
                financialProvider.setActive(false);
            }
            financialRepository.save(financialRepo);
        }

        List<FinancialProvider> financialCache = financialCacheRepository.findAll();
        if(CollectionUtils.isNotEmpty(financialCache)){
            for(FinancialProvider financialProvider : financialCache){
                financialProvider.setActive(false);
            }
            financialCacheRepository.save(financialCache);
        }
        syncFinancialWithMongoDb();
    }

}


