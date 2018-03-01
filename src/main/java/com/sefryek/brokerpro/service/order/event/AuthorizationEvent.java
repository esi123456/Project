package com.sefryek.brokerpro.service.order.event;

import com.sefryek.brokerpro.service.Retry.ServiceInputs;

/**
 * Copyright 2016 (C) syspod.co
 *
 * @auther: Ashkan Haghighi Kia
 * @email: kia@syspod.co
 */

public class AuthorizationEvent {

    private ServiceInputs serviceInputs;

    public AuthorizationEvent(ServiceInputs serviceInputs) {
        this.serviceInputs = serviceInputs;
    }

    public ServiceInputs getServiceInputs() {
        return serviceInputs;
    }
}
