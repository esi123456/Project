package com.sefryek.brokerpro.lightstreamer;//package com.sefryek.brokerpro.lightstreamer;
//
//import com.lightstreamer.client.ClientListener;
//import com.lightstreamer.client.LightstreamerClient;
//
///**
// * Copyright 2016 (C) sefryek.com
// *
// * @author: Ismael Sadeghi
// * @email: ismaelsadeghi111@gmail.com
// * @date: 21, Jan, 2018
// */
//public class SystemOutClientListener implements ClientListener {
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
//}