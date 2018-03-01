package com.sefryek.brokerpro.quartz;

import com.sefryek.brokerpro.service.mobile.exchange.ExchangeBrokerService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 11, Nov, 2017
 */
@DisallowConcurrentExecution
public class ExchangeBrokerJob implements Job {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ExchangeBrokerService exchangeBrokerService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        log.info("exchangeBroker job started for syncing exchange-broker with tadbir");
        exchangeBrokerService.syncExchangeBrokerWithTadbir();
        log.info(String.format("exchange-broker updated from tadbir - %s", new Date().toString()));
    }
}
