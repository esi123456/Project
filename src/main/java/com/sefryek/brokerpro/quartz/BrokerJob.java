package com.sefryek.brokerpro.quartz;
/*
 * Copyright 2016 (C) syspod.co
 * 
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */

import com.sefryek.brokerpro.service.BrokerService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@DisallowConcurrentExecution
public class BrokerJob implements Job {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BrokerService brokerService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        log.info("broker job started for syncing brokers with tadbir");
        brokerService.syncBrokersWithTadbir();
        log.info(String.format("brokers updated from tadbir - %s", new Date().toString()));
    }
}
