package com.sefryek.brokerpro.lightstreamer;//package com.sefryek.brokerpro.lightstreamer;
//
//import com.lightstreamer.client.*;
//import com.lightstreamer.client.ItemUpdate;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.Iterator;
//import java.util.Map;
//
///**
// * Copyright 2016 (C) sefryek.com
// *
// * @author: Ismael Sadeghi
// * @email: ismaelsadeghi111@gmail.com
// * @date: 21, Jan, 2018
// */
//public class SubscriptionListenerImpl implements SubscriptionListener {
//
//    private final Logger log = LoggerFactory.getLogger(this.getClass());
//
//    @Override
//    public void onClearSnapshot(String itemName, int itemPos) {
//        System.out.println("Server has cleared the current status of the portfolio");
//    }
//
//    @Override
//    public void onCommandSecondLevelItemLostUpdates(int lostUpdates, String key) {
//        System.out.println(lostUpdates + " messages were lost ("+key+")");
//    }
//
//    @Override
//    public void onCommandSecondLevelSubscriptionError(int code, String message, String key) {
//        System.out.println("Cannot subscribe (2nd-level item "+key+") because of error " + code + ": " + message);
//    }
//
//    @Override
//    public void onEndOfSnapshot(String itemName, int itemPos) {
//        System.out.println("Initial portfolio received");
//    }
//
//    @Override
//    public void onItemLostUpdates(String itemName, int itemPos, int lostUpdates) {
//        System.out.println(lostUpdates + " messages were lost");
//    }
//
//    @Override
//    public void onItemUpdate(ItemUpdate update) {
//
//        log.info("START UPDATE:", update.getItemName());
//
//        Iterator<Map.Entry<String,String>> changedValues = update.getChangedFields().entrySet().iterator();
//        while(changedValues.hasNext()) {
//            Map.Entry<String,String> field = changedValues.next();
//            log.info("Field " + field.getKey() + " changed: " + field.getValue() );
//        }
//
////        String command = update.getValue("command");
////        if (command.equals("ADD")) {
////            System.out.println("first update for this key ("+update.getValue("key")+"), the library is now automatically subscribing the second level item for it");
////        } else if (command.equals("UPDATE")) {
////            StringBuilder updateString = new StringBuilder("Update for ");
////            updateString.append(update.getValue("stock_name")); //2nd level field
////            updateString.append(", last price is ");
////            updateString.append(update.getValue("last_price")); //2nd level field
////            updateString.append(", we own ");
////            updateString.append(update.getValue("qty")); //1st level field
////
////            System.out.println(updateString);
////
////            //there is the possibility that a second update for the first level is received before the first update for the second level
////            //thus we might print a message that contains a few NULLs
////        } else if (command.equals("DELETE")) {
////            System.out.println("key ("+update.getValue("key")+"), was removed, the library is now automatically unsubscribing the second level item for it");
////        }
//
//    }
//
//    @Override
//    public void onListenEnd(Subscription subscription) {
//        System.out.println("Stop listeneing to subscription events");
//    }
//
//    @Override
//    public void onListenStart(Subscription subscription) {
//        System.out.println("Start listeneing to subscription events");
//    }
//
//    @Override
//    public void onSubscription() {
//        System.out.println("Now subscribed to the portfolio item");
//    }
//
//    @Override
//    public void onSubscriptionError(int code, String message) {
//        System.out.println("Cannot subscribe because of error " + code + ": " + message);
//    }
//
//    @Override
//    public void onUnsubscription() {
//        System.out.println("Now unsubscribed from portfolio item");
//    }
//
//    @Override
//    public void onRealMaxFrequency(String frequency) {
//        System.out.println("Frequency is " + frequency);
//    }
//
//}