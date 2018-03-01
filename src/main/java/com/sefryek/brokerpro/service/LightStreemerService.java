//package com.sefryek.brokerpro.service;
//
//import com.lightstreamer.ls_client.*;
//import com.sefryek.brokerpro.config.Constants;
//import com.sefryek.brokerpro.domain.Broker;
//import com.sefryek.brokerpro.domain.BrokerInfo;
//import com.sefryek.brokerpro.dto.response.gateway.LoginGateway;
//import com.sefryek.brokerpro.lightstreamer.ClientConnectionListener;
//import com.sefryek.brokerpro.lightstreamer.ClientListener;
//import com.sefryek.brokerpro.repository.cache.BrokerCacheRepository;
//import com.sefryek.brokerpro.repository.cache.LoginGatewayCacheRepository;
//import com.sefryek.brokerpro.repository.mongo.BrokerInfoRepository;
//import com.sefryek.util.ObjectUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Copyright 2016 (C) sefryek.com
// *
// * @author: Ismael Sadeghi
// * @email: ismaelsadeghi111@gmail.com
// * @date: 14, Feb, 2018
// */
//@Component
//public class LightStreemerService {
//
//    private final Logger log = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    private BrokerCacheRepository brokerCacheRepository;
//    @Autowired
//    private BrokerInfoRepository brokerInfoRepository;
//    @Autowireda
//    private LoginGatewayCacheRepository loginGatewayCacheRepository;
//
//    public void subscribeAllBrokers() {
//        log.info("\n----- start lightstreamer -------");
//        List<Broker> brokers = brokerCacheRepository.findAllByActiveTrue();
//        for (Broker broker : brokers) {
//            subscribeOneBroker(broker);
//        }
//    }
//
//    final LSClient myClient = new LSClient();
//
//    public void subscribeOneBroker(Broker broker) {
//        try {
//
//            BrokerInfo brokerInfo = brokerInfoRepository.findByCode(broker.getCode());
//            String lsRequest = String.format(broker.getCode() + Constants.TADBIR_LS_REQUEST_FORMAT + Constants.USER);
//            String lsItems = broker.getCode().toString() + Constants.TADBIR_LS_SYSTEM_ITEM;
//
//            LoginGateway loginGateway = loginGatewayCacheRepository.findByBrokerCode(broker.getCode());
//            String lsToken = "";
//            if (ObjectUtils.isNotNull(loginGateway)) {
//                lsToken = loginGateway.getLsToken();
//            }
//
////            ClientConnectionListener connection = new ClientConnectionListener();
//            myClient.openConnection(
//                    new ConnectionInfo() {
//                        {
//                            this.pushServerUrl = Constants.PUSHSERVERHOST;
//                            this.adapter = Constants.ADAPTER;
//                            this.user = Constants.USER;
//                        }
//                    },
//                    new ExtendedConnectionListener() {
//
//                        private long bytes = 0;
//
//                        public void onConnectionEstablished() {
//                            log.info("connection established");
//                        }
//
//                        public void onSessionStarted(boolean isPolling) {
//                            log.info("session started: {}", isPolling);
//                        }
//
//                        public void onSessionStarted(boolean isPolling, String controlLink) {
//                            String clAddendum = controlLink != null ? " to server " + controlLink : "";
//                            if (isPolling) {
//                                log.info("Session started in smart polling {}", clAddendum);
//                            } else {
//                                log.info("Session started in streaming {}", clAddendum);
//                            }
//                        }
//
//                        public void onNewBytes(long newBytes) {
//                            this.bytes += newBytes;
//                        }
//
//                        public void onDataError(PushServerException e) {
//                            log.error("data error, message: {}", e.getMessage());
//                        }
//
//                        public void onActivityWarning(boolean warningOn) {
//                            if (warningOn) {
//                                log.info("connection stalled");
//                            } else {
//                                log.info("connection no longer stalled");
//                            }
//                        }
//
//                        public void onEnd(int cause) {
//                            log.info("connection forcibly closed");
//                        }
//
//                        public void onClose() {
//                            log.info("total bytes: {}", bytes);
//                        }
//
//                        public void onFailure(PushServerException e) {
//                            log.info("server failure, message: {}", e.getMessage());
//                        }
//
//                        public void onFailure(PushConnException e) {
//                            log.info("connection failure, message: {}", e.getMessage());
//                        }
//
//                    }
//
//            );
//
////            connection.openConnect(myClient, broker.getLsUrl(), Constants.ADAPTER, Constants.USER, "");
//
//            ArrayList<SubscribedTableKey> subscrRefs = new ArrayList<>();
//            SubscribedTableKey tableRef = ClientListener.subscribedTableKey(myClient, lsItems);
//            subscrRefs.add(tableRef);
//
//            SubscribedTableKey[] subscrKeys = subscrRefs.toArray(new SubscribedTableKey[0]);
//            log.info(Constants.FINISH);
//            System.in.read();
//            log.info(Constants.EXIT);
//            Thread.sleep(10000);
//            myClient.changeSubscriptions(subscrKeys, new SubscriptionConstraints() {
//                {
//                    maxFrequency = new Double(0.1);
//                }
//            });
//
//            Thread.sleep(10000);
//
//            myClient.unsubscribeTables(subscrKeys);
//
//            Thread.sleep(5000);
//
//            myClient.closeConnection();
//            Thread.sleep(2000);
//            System.exit(0);
//
//        } catch (PushUserException e) {
//            log.error("user not found , message: {}", e.getMessage());
//        } catch (PushServerException e) {
//            log.error("cannot connect to lightstreamer server, message: {}", e.getMessage());
//        } catch (SubscrException e) {
//            log.error("subscription or unsubscription is not correct or the request cannot be executed for some reason, message: {}", e.getStackTrace());
//        } catch (PushConnException e) {
//            log.error("the connection has not been established, message: {}", e.getMessage());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            log.error("message: {}", e.getMessage());
//        }
//
//    }
//
//    private void syncMongoExchanges(Broker broker) {
////        //TODO add a method to ExchangeBrokerService for syncing one broker with Tadbir and then call that method here
//    }
//
//}
