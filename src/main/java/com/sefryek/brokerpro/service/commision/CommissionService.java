package com.sefryek.brokerpro.service.commision;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.domain.Broker;
import com.sefryek.brokerpro.domain.Commission;
import com.sefryek.brokerpro.domain.CommissionDetail;
import com.sefryek.brokerpro.domain.Exchange;
import com.sefryek.brokerpro.domain.enumeration.CommissionType;
import com.sefryek.brokerpro.dto.request.Language;
import com.sefryek.brokerpro.dto.request.commission.CommissionRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.portfolio.OrderSide;
import com.sefryek.brokerpro.exception.CommissionNotFoundException;
import com.sefryek.brokerpro.repository.cache.BrokerCacheRepository;
import com.sefryek.brokerpro.repository.cache.CommissionDetailCacheRepository;
import com.sefryek.brokerpro.repository.cache.ExchangeCacheRepository;
import com.sefryek.brokerpro.repository.mongo.CommissionDetailRepository;
import com.sefryek.brokerpro.service.AuthStrategy;
import com.sefryek.brokerpro.service.Service;
import com.sefryek.brokerpro.service.mapper.CommissionDetailMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.commission.CommissionDetailTadbir;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.commission.SymbolCommissionDetailsTadbir;
import com.sefryek.util.CollectionUtils;
import com.sefryek.util.ObjectUtils;
import com.sefryek.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @auther: Ashkan Haghighi Kia
 * @email: kia@syspod.co
 */
@Component
public class CommissionService extends Service<SymbolCommissionDetailsTadbir> {

    @Autowired
    private CommissionDetailMapper commissionDetailMapper;

    @Autowired
    private ExchangeCacheRepository exchangeCacheRepository;

    @Autowired
    private BrokerCacheRepository brokerCacheRepository;

    @Autowired
    private CommissionDetailRepository commissionDetailRepository;

    @Autowired
    private CommissionDetailCacheRepository commissionDetailCacheRepository;

    public CommissionService() {
        super(SymbolCommissionDetailsTadbir.class);
    }

    public Response<Commission> findCommission(CommissionRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        List<CommissionDetail> commissionDetailList = commissionDetailCacheRepository.findByBrokerCode(findBrokerByToken(request.getToken()).getCode());
        if (CollectionUtils.isNotEmpty(commissionDetailList)) {
            Response<Commission> result = new Response<>();
            result.setResponse(convertCommission(request.getSymbolISIN(), commissionDetailList));
            createSuccessResponse(result);
            return result;
        }
        throw new CommissionNotFoundException();
    }

    private Commission convertCommission(String symbolISIN, List<CommissionDetail> commissionDetailList){
        Commission result = new Commission();
        Exchange exchange = exchangeCacheRepository.findOneBySymbolISINAndLanguage(symbolISIN, Language.ENGLISH.getCode());
        List<CommissionDetail> tempList = commissionDetailList.stream()
                .filter(commission -> exchange.getSymbolISIN().equals(symbolISIN))
                .filter(commission -> exchange.getMarketUnit().equals(commission.getMarketUnit()))
                .filter(commission -> CommissionType.NORMAL.equals(commission.getCommissionType())) //Mr.Khosro Zare from tadbir have said only use CommissionType.NORMAL.
                .collect(Collectors.toList());

        if(CollectionUtils.isNotEmpty(tempList)){
            for (CommissionDetail commissionDetail: tempList) {
                if (commissionDetail.getOrderSide().equals(OrderSide.BUY)){
                    result.setBuyCommissionBroker(commissionDetail.getKarmozdPercent());
                    result.setMinBuyBrokerCommissionPrice(commissionDetail.getMinKarmozdPrice());
                    result.setBuyCommissionOther(calculateOtherCommission(commissionDetail));
                } else if(commissionDetail.getOrderSide().equals(OrderSide.SELL)){
                    result.setSellCommissionBroker(commissionDetail.getKarmozdPercent());
                    result.setMinSellBrokerCommissionPrice(commissionDetail.getMinKarmozdPrice());
                    result.setSellCommissionOther(calculateOtherCommission(commissionDetail));
                }
            }
        }
        return  result;
    }

    private BigDecimal calculateOtherCommission(CommissionDetail commissionDetail){
        BigDecimal commissionOther =  new BigDecimal(0.0);
        commissionOther = commissionOther.add(commissionDetail.getAvarezPercent())
                .add(commissionDetail.getFanavariPercent())
                .add(commissionDetail.getSazmanPercent())
                .add(commissionDetail.getSepodegozariPercent())
                .add(commissionDetail.getTaxPercent());
        return commissionOther;
    }

    private void syncCommissionWithMongoDb() {
        commissionDetailCacheRepository.save(commissionDetailRepository.findAll());
    }

    public synchronized void syncCommissionWithTadbir() {
        List<CommissionDetailTadbir> commissionsDetailTB = findCommissionFromTadbirForAllBroker();
        syncCommissionWithMongoDb();
        List<CommissionDetail> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(commissionsDetailTB)) {
                result.addAll(commissionDetailMapper.as(commissionsDetailTB));
                save(result);
        }
    }

    private List<CommissionDetailTadbir> findCommissionFromTadbirForAllBroker() {
        List<CommissionDetailTadbir> result = new ArrayList<>();
        List<Broker> brokers = brokerCacheRepository.findAllByActiveTrue();
        for (Broker broker : brokers) {
            if (StringUtils.isNotEmpty(broker.getBrokerUrl())) {
                result.addAll(findCommissionFromTadbirForOneBroker(broker));
            }
        }
        return result;
    }

    private List<CommissionDetailTadbir> findCommissionFromTadbirForOneBroker(Broker broker) {
        List<CommissionDetailTadbir> result = new ArrayList<>();
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrlByBroker(broker, Constants.COMMISSION_DETAIL_URL));
        SymbolCommissionDetailsTadbir responseTadbir = callWebServiceHttpMethodGET(urlBuilder, AuthStrategy.GATEWAY, broker.getCode());
        if (ObjectUtils.isNotNull(responseTadbir) && responseTadbir.isSuccessful()) {
            if (responseTadbir.getCommissionDetails() != null && responseTadbir.getCommissionDetails().size() > 0) {
                Iterator it = responseTadbir.getCommissionDetails().entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry)it.next();
                    CommissionDetailTadbir commissionTB = (CommissionDetailTadbir) pair.getValue();
                    commissionTB.setBrokerCode(broker.getCode());
                }
                result.addAll(responseTadbir.getCommissionDetails().values());
            }
        }
        return result;
    }

    @Transactional
    public void save(List<CommissionDetail> commissionDetailList) {
        commissionDetailCacheRepository.save(commissionDetailRepository.save(commissionDetailList));
    }

}
