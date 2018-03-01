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
//public class ClientConnectionListener {
//
//    private final Logger log = LoggerFactory.getLogger(ClientConnectionListener.class);
//
//    public void openConnect(LSClient myClient, String pushServerUrl, String adapter, String user, String password) throws Exception {
//        myClient.openConnection(
//                new ConnectionInfo() {
//                    {
//                        this.pushServerUrl = pushServerUrl;
//                        this.adapter = adapter;
//                        this.user = user;
//                        this.password = password;
//                    }
//                },
//                new ExtendedConnectionListener() {
//
//                    private long bytes = 0;
//
//                    public void onConnectionEstablished() {
//                        log.info("connection established");
//                    }
//
//                    public void onSessionStarted(boolean isPolling) {
//                        log.info("session started: {}", isPolling);
//                    }
//
//                    public void onSessionStarted(boolean isPolling, String controlLink) {
//                        String clAddendum = controlLink != null ? " to server " + controlLink : "";
//                        if (isPolling) {
//                            log.info("Session started in smart polling {}", clAddendum);
//                        } else {
//                            log.info("Session started in streaming {}", clAddendum);
//                        }
//                    }
//
//                    public void onNewBytes(long newBytes) {
//                        this.bytes += newBytes;
//                    }
//
//                    public void onDataError(PushServerException e) {
//                        log.error("data error, message: {}", e.getMessage());
//                    }
//
//                    public void onActivityWarning(boolean warningOn) {
//                        if (warningOn) {
//                            log.info("connection stalled");
//                        } else {
//                            log.info("connection no longer stalled");
//                        }
//                    }
//
//                    public void onEnd(int cause) {
//                        log.info("connection forcibly closed");
//                    }
//
//                    public void onClose() {
//                        log.info("total bytes: {}", bytes);
//                    }
//
//                    public void onFailure(PushServerException e) {
//                        log.info("server failure, message: {}", e.getMessage());
//                    }
//
//                    public void onFailure(PushConnException e) {
//                        log.info("connection failure, message: {}", e.getMessage());
//                    }
//                }
//
//        );
//    }
//}
