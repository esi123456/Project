package com.sefryek.brokerpro.quartz;
/*
 * Copyright 2016 (C) syspod.co
 * 
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */

import com.sefryek.brokerpro.service.ExchangeCompanyService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@DisallowConcurrentExecution
public class ExchangeCompanyJob implements Job {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ExchangeCompanyService exchangeCompanyService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        log.info("exchangeCompany job started for syncing exchange-company with tadbir");
        exchangeCompanyService.syncExchangeCompanyWithTadbir();
        log.info(String.format("exchange-company updated from tadbir - %s", new Date().toString()));
    }
}
