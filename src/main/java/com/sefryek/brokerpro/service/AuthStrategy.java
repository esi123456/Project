package com.sefryek.brokerpro.service;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, Aug, 2017
 *
 * NONE:   (brokerCode or userToken doesn't need in Service.java)
 *       When Gateway does't need to authenticate to Tadbir servers and data doesn't depend to client (Just Market Service).
 *       gatewayToken doesn't need to send to tadbir's Services.
 *       Just when gateway needs to get some general data from Tadbir's services (e.g. Brokers, Exchanges).
 *
 * GATEWAY: (Just brokerCode needs in Service.java)
 *      When just Gateway need to authenticate to Tadbir servers and data doesn't depend to client (Just OMS Service).
 *      gatewayToken needs to send to tadbir's Services.
 *      Just when gateway needs to get some general data from Tadbir's services (e.g. Commission).
 *
 * USER:   (Just userToken needs in Service.java)
 *      When Gateway needs to authenticate to Tadbir servers and data maybe depends (or not) to client (Just OMS Service).
 *      gatewayToken needs to send to tadbir's Services.
 */
public enum AuthStrategy {
    NONE,
    GATEWAY,
    USER;
}
