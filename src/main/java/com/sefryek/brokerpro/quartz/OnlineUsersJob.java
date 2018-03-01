package com.sefryek.brokerpro.quartz;

import com.sefryek.brokerpro.service.gateway.OnlineUsersService;
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
 * @author: Ismael Sadeghi
 * @email: ismaelsadeghi111@gmail.com
 * @date: 20, Jan, 2018
 */
@DisallowConcurrentExecution
public class OnlineUsersJob implements Job {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    OnlineUsersService onlineUsersService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        log.info("create online Users for all brokers");
        onlineUsersService.onlineUsersAllBrokers();
        log.info(String.format("online users are for all brokers updated - %s", new Date().toString()));
    }
}
