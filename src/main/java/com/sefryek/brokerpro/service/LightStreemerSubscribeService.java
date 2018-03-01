package com.sefryek.brokerpro.service;//package com.sefryek.brokerpro.service;
//
//import com.lightstreamer.client.ClientListener;
//import com.lightstreamer.client.LightstreamerClient;
//import com.lightstreamer.client.Subscription;
//import com.sefryek.brokerpro.config.Constants;
//import com.sefryek.brokerpro.domain.Broker;
//import com.sefryek.brokerpro.domain.BrokerInfo;
//import com.sefryek.brokerpro.dto.response.gateway.LoginGateway;
//import com.sefryek.brokerpro.lightstreamer.SystemOutClientListener;
//import com.sefryek.brokerpro.repository.cache.BrokerCacheRepository;
//import com.sefryek.brokerpro.repository.cache.LoginGatewayCacheRepository;
//import com.sefryek.brokerpro.repository.mongo.BrokerInfoRepository;
//import com.sefryek.util.ObjectUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
////import org.slf4j.Logger;
//
///**
// * Copyright 2016 (C) sefryek.com
// *
// * @author: Ismael Sadeghi
// * @email: ismaelsadeghi111@gmail.com
// * @date: 27, Jan, 2018
// */
//@Component
//public class LightStreemerSubscribeService {
//
//    @Autowired
//    private BrokerCacheRepository brokerCacheRepository;
//    @Autowired
//    private BrokerInfoRepository brokerInfoRepository;
//    @Autowired
//    private LoginGatewayCacheRepository loginGatewayCacheRepository;
//
//    private final Logger log = LoggerFactory.getLogger(this.getClass());
//
//    public void subscribeAllBrokers() {
//        List<Broker> brokers = brokerCacheRepository.findAllByActiveTrue();
//        for (Broker broker : brokers) {
//            subscribeOneBroker(broker);
//        }
//    }
//
//    private void subscribeOneBroker(Broker broker) {
//        try {
//            LightstreamerClient client = new LightstreamerClient(broker.getLsUrl(), "STOCKLISTDEMO_REMOTE");
//            ClientListener clientListener = new SystemOutClientListener();
//            client.addListener(clientListener);
//            BrokerInfo brokerInfo = brokerInfoRepository.findByCode(broker.getCode());
//            String lsRequest = String.format(broker.getCode() + Constants.TADBIR_LS_REQUEST_FORMAT + brokerInfo.getUserName());
//            String[] lsItems = new String[]{broker.getCode().toString() + Constants.TADBIR_LS_SYSTEM_ITEM};
//            Subscription sub = new Subscription("RAW");
//            sub.setItems(lsItems);
//            sub.setRequestedSnapshot("no");
//            sub.setFieldSchema("cache");
//            sub.isActive();
//            sub.setDataAdapter("TadbirLightPrivateGatewayAdapter");
//            client.subscribe(sub);
//            sub.isActive();
//
//            LoginGateway loginGateway = loginGatewayCacheRepository.findByBrokerCode(broker.getCode());
//            String lsToken = "";
//            if (ObjectUtils.isNotNull(loginGateway)) {
//                lsToken = loginGateway.getLsToken();
//            }
//            client.connectionDetails.setPassword("123456tT");
//            client.connectionDetails.setUser("soheilkh");
//            client.connect();
//            log.info("LS status is: " + client.getStatus());
//            log.info("LS subscribe list is: " + client.getSubscriptions());
//        } catch (Exception ex) {
//            log.error("can not subscribe broker: " + broker.getCode());
//            ex.printStackTrace();
//        }
//    }
//
//    private void syncMongoExchanges(Broker broker) {
//        //TODO add a method to ExchangeBrokerService for syncing one broker with Tadbir and then call that method here
//    }
//
//}
