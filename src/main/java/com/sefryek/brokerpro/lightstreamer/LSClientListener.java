package com.sefryek.brokerpro.lightstreamer;//package com.sefryek.brokerpro.lightstreamer;
//
//import com.lightstreamer.client.ClientListener;
//import com.lightstreamer.client.LightstreamerClient;
//import com.sefryek.brokerpro.service.mobile.exchange.ExchangeBrokerService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * Copyright 2016 (C) sefryek.com
// *
// * @author: Ismael Sadeghi
// * @email: ismaelsadeghi111@gmail.com
// * @date: 27, Jan, 2018
// */
//public class LSClientListener implements ClientListener {
//    @Autowired
//    private ExchangeBrokerService exchangeBrokerService;
//    @Autowired
//    private final Logger log = LoggerFactory.getLogger(this.getClass());
//
//    @Override
//    public void onListenEnd(LightstreamerClient client) {
//        System.out.println("Stops listening to client events");
//    }
//
//    @Override
//    public void onListenStart(LightstreamerClient client) {
//        System.out.println("Start listening to client events");
//
//    }
//
//    @Override
//    public void onPropertyChange(String property) {
//        System.out.println("Client property changed: " + property);
//        log.debug("Client property changed: " + property);
//        //TODO add a method to ExchangeBrokerService for syncing one broker with Tadbir and then call that method here
//    }
//
//    @Override
//    public void onServerError(int code, String message) {
//        System.out.println("Server error: " + code + ": " + message);
//    }
//
//    @Override
//    public void onStatusChange(String newStatus) {
//        System.out.println("Connection status changed to " + newStatus);
//    }
//
//
//
//}
