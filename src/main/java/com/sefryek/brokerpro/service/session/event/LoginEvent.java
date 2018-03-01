package com.sefryek.brokerpro.service.session.event;

import com.sefryek.brokerpro.domain.Broker;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 02, Nov, 2017
 */
public class LoginEvent {
    private Broker broker;

    public LoginEvent(Broker broker) {
        this.broker = broker;
    }

    public Broker getBroker() {
        return broker;
    }

    public void setBroker(Broker broker) {
        this.broker = broker;
    }
}
