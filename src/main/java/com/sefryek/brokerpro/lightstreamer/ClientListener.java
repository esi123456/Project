//package com.sefryek.brokerpro.lightstreamer;
//
//import com.lightstreamer.ls_client.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import com.sefryek.brokerpro.config.Constants;
//
///**
// * Copyright 2016 (C) sefryek.com
// *
// * @author: Ismael Sadeghi
// * @email: ismaelsadeghi111@gmail.com
// * @date: 13, Feb, 2018
// */
//public class ClientListener {
//
//    private static final Logger log = LoggerFactory.getLogger(ClientListener.class);
//
//    public static SubscribedTableKey subscribedTableKey(final LSClient myClient, String group) throws SubscrException, PushServerException, PushUserException, PushConnException {
//        // Group and Schema names have to be manageable by
//        // the LiteralBasedProvider used for the StockListDemo
//        SubscribedTableKey tableRef = myClient.subscribeTable(
//                new SimpleTableInfo(group, Constants.MOD, Constants.SCHEMANAME, Constants.SNAP) {
//                    {
//                        setDataAdapter(Constants.DATAADAPTER);
//                    }
//                },
//                new HandyTableListener() {
//                    // will only receive positional information
//                    private String notifyUpdate(UpdateInfo update) {
//                        return update.isSnapshot() ? "snapshot" : "update";
//                    }
//
//                    private String notifyValue(UpdateInfo update, int fldPos, String fldText) {
//                        String notify = " " + fldText + " = " + update.getNewValue(fldPos);
//                        if (update.isValueChanged(fldPos)) {
//                            notify += " (was " + update.getOldValue(fldPos) + ")";
//                        }
//                        return notify;
//                    }
//
//                    public void onUpdate(int itemPos, String itemName, UpdateInfo update) {
//                        for (int i = 1; i <= update.getNumFields(); i++) {
//                            if (update.isValueChanged(i)) {
//                                log.info("Position: {}", String.valueOf(i) ," Value: {}", update.getNewValue(i));
//                            }
//                        }
//
//                    }
//
//                    public void onSnapshotEnd(int itemPos, String itemName) {
//                        log.info("end of snapshot for " + itemPos);
//                    }
//
//                    public void onRawUpdatesLost(int itemPos, String itemName, int lostUpdates) {
//                        log.info("", lostUpdates + " updates lost for " + itemPos);
//                    }
//
//                    public void onUnsubscr(int itemPos, String itemName) {
//                        log.info("unsubscr" + itemPos);
//                    }
//
//                    public void onUnsubscrAll() {
//                        log.info("unsubscr table");
//                    }
//                },
//                false
//        );
//        return tableRef;
//    }
//}
