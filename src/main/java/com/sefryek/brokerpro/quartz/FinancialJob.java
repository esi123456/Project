package com.sefryek.brokerpro.quartz;

import com.sefryek.brokerpro.service.FinancialProvidersService;
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
 * @date: 12, Aug, 2017
 */
@DisallowConcurrentExecution
public class FinancialJob implements Job {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FinancialProvidersService financialSertvice;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        log.info("financial job started for syncing financial with tadbir");
        financialSertvice.syncFinancialWithTadbir();
        log.info(String.format("financial updated from tadbir - %s", new Date().toString()));
    }
}