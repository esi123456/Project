package com.sefryek.brokerpro.quartz;

import com.sefryek.brokerpro.service.commision.CommissionService;
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
 * @date: 15, Aug, 2017
 */
@DisallowConcurrentExecution
public class CommissionDetailJob implements Job {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CommissionService commissionService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        log.info("commissionDetail job started for syncing commission with tadbir");
        commissionService.syncCommissionWithTadbir();
        log.info(String.format("commissionDetail updated from tadbir - %s", new Date().toString()));
    }
}