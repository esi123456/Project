package com.sefryek.brokerpro.quartz;

import com.sefryek.brokerpro.service.LoginGatewayService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by Amin on 6/22/2017.
 */
@DisallowConcurrentExecution
public class LoginGatewayJob implements Job {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LoginGatewayService service;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        log.info("login gateway job started for authenticate gateway to all brokers");
        service.loginAllBrokers();
        log.info(String.format("gateway authenticated to all brokers - %s", new Date().toString()));
    }
}
