package com.sefryek.brokerpro.config;

import com.hazelcast.core.HazelcastInstance;
import com.sefryek.brokerpro.config.job.AutowiringSpringBeanJobFactory;
import com.sefryek.brokerpro.quartz.*;
import com.sefryek.util.TimeZoneTable;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;

/*
 * Author     : Ashkan Haghighi Kia
 * Email      : ashkan.haghighi.kia@gmail.com
 */
@Configuration
@EnableAsync
@ConditionalOnProperty(name = "quartz.enabled")
public class SchedulerConfiguration {

    private static SimpleTriggerFactoryBean createTrigger(JobDetail jobDetail, long pollFrequencyMs) {
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        factoryBean.setJobDetail(jobDetail);
        factoryBean.setStartDelay(0L);
        factoryBean.setRepeatInterval(pollFrequencyMs);
        factoryBean.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
        factoryBean.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_RESCHEDULE_NEXT_WITH_REMAINING_COUNT);
        return factoryBean;
    }

    private static SimpleTriggerFactoryBean createOneTimeStartupTrigger(JobDetail jobDetail) {
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        factoryBean.setJobDetail(jobDetail);
        factoryBean.setStartDelay(5000L);
        factoryBean.setRepeatInterval(1);
        factoryBean.setRepeatCount(1);
        factoryBean.setStartTime(new Date());
        factoryBean.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_RESCHEDULE_NEXT_WITH_REMAINING_COUNT);
        return factoryBean;
    }

    @Bean
    public JobFactory jobFactory(ApplicationContext applicationContext) {
        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory, HazelcastInstance hazelcastInstance,
                                                     @Qualifier("brokerJobTrigger") Trigger brokerJobTrigger,
                                                     @Qualifier("exchangeCompanyJobTrigger") Trigger exchangeCompanyJobTrigger,
                                                     @Qualifier("financialJobTrigger") Trigger financialJobTrigger,
                                                     @Qualifier("commissionDetailJobTrigger") Trigger commissionDetailJobTrigger,
                                                     @Qualifier("loginGatewayJobTrigger") Trigger loginGatewayJobTrigger,
                                                     @Qualifier("exchangeBrokerJobTrigger") Trigger exchangeBrokerJobTrigger,
                                                     @Qualifier("OnlineUsersJobTrigger") Trigger OnlineUsersJobTrigger
                                                     ) throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setOverwriteExistingJobs(true);
        factory.setJobFactory(jobFactory);
        factory.setQuartzProperties(quartzProperties());
        factory.setTriggers(brokerJobTrigger, exchangeCompanyJobTrigger, financialJobTrigger, commissionDetailJobTrigger, loginGatewayJobTrigger, exchangeBrokerJobTrigger, OnlineUsersJobTrigger);
        return factory;
    }

    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }

    @Bean(name = "sampleJobTrigger")
    public CronTriggerFactoryBean sampleJobTrigger(@Qualifier("sampleJobDetail") JobDetail jobDetail,
                                                   @Value("${brokerpro.job.sample.cron}") String cronExpression) {
        return createCronTrigger(jobDetail, cronExpression);
    }

    // Use this method for creating cron triggers instead of simple triggers:
    private static CronTriggerFactoryBean createCronTrigger(JobDetail jobDetail, String cronExpression) {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(jobDetail);
        factoryBean.setCronExpression(cronExpression);
        factoryBean.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_FIRE_NOW);
        factoryBean.setTimeZone(TimeZone.getTimeZone(TimeZoneTable.ASIA_TEHRAN.getTimezoneId()));
        return factoryBean;
    }

    @Bean(name = "sampleJobDetail")
    public JobDetailFactoryBean sampleJobDetail() {
        return createJobDetail(SampleJob.class);
    }

    private static JobDetailFactoryBean createJobDetail(Class jobClass) {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(jobClass);
        factoryBean.setDurability(true);
        return factoryBean;
    }

    @Bean(name = "brokerJobTrigger")
    public CronTriggerFactoryBean brokerJobTrigger(@Qualifier("brokerJobDetail") JobDetail jobDetail,
                                                   @Value("${brokerpro.job.broker.cron}") String cronExpression) {
        return createCronTrigger(jobDetail, cronExpression);
    }

    @Bean(name = "brokerJobDetail")
    public JobDetailFactoryBean brokerJobDetail() {
        return createJobDetail(BrokerJob.class);
    }

    @Bean(name = "exchangeCompanyJobTrigger")
    public CronTriggerFactoryBean exchangeCompanyJobTrigger(@Qualifier("exchangeCompanyJobDetail") JobDetail jobDetail,
                                                     @Value("${brokerpro.job.exchangeCompany.cron}") String cronExpression) {
        return createCronTrigger(jobDetail, cronExpression);
    }

    @Bean(name = "exchangeCompanyJobDetail")
    public JobDetailFactoryBean exchangeCompanyJobDetail() {
        return createJobDetail(ExchangeCompanyJob.class);
    }

    @Bean(name = "financialJobTrigger")
    public CronTriggerFactoryBean financialJobTrigger(@Qualifier("financialJobDetail") JobDetail jobDetail,
                                                     @Value("${brokerpro.job.financial.cron}") String cronExpression) {
        return createCronTrigger(jobDetail, cronExpression);
    }

    @Bean(name = "financialJobDetail")
    public JobDetailFactoryBean financialJobDetail() {
        return createJobDetail(FinancialJob.class);
    }

    @Bean(name = "commissionDetailJobTrigger")
    public CronTriggerFactoryBean commissionDetailJobTrigger(@Qualifier("commissionDetailJobDetail") JobDetail jobDetail,
                                                      @Value("${brokerpro.job.commissionDetail.cron}") String cronExpression) {
        return createCronTrigger(jobDetail, cronExpression);
    }

    @Bean(name = "commissionDetailJobDetail")
    public JobDetailFactoryBean commissionDetailJobDetail() {
        return createJobDetail(CommissionDetailJob.class);
    }

    @Bean(name = "loginGatewayJobTrigger")
    public CronTriggerFactoryBean loginGatewayJobTrigger(@Qualifier("loginGatewayJobDetail") JobDetail jobDetail,
                                                             @Value("${brokerpro.job.loginGateway.cron}") String cronExpression) {
        return createCronTrigger(jobDetail, cronExpression);
    }

    @Bean(name = "loginGatewayJobDetail")
    public JobDetailFactoryBean loginGatewayJobDetail() {
        return createJobDetail(LoginGatewayJob.class);
    }

    @Bean(name = "exchangeBrokerJobTrigger")
    public CronTriggerFactoryBean exchangeBrokerJobTrigger(@Qualifier("exchangeBrokerJobDetail") JobDetail jobDetail,
                                                            @Value("${brokerpro.job.exchangeBroker.cron}") String cronExpression) {
        return createCronTrigger(jobDetail, cronExpression);
    }

    @Bean(name = "exchangeBrokerJobDetail")
    public JobDetailFactoryBean exchangeBrokerJobDetail() {
        return createJobDetail(ExchangeBrokerJob.class);
    }

    @Bean(name = "OnlineUsersJobTrigger")
    public CronTriggerFactoryBean onlineUsersJobTrigger(@Qualifier("OnlineUsersJobDetail") JobDetail jobDetail,
                                                        @Value("${brokerpro.job.onlineUsers.cron}") String cronExpression) {
        return createCronTrigger(jobDetail, cronExpression);
    }

    @Bean(name = "OnlineUsersJobDetail")
    public JobDetailFactoryBean OnlineUsersJobDetail() {
        return createJobDetail(OnlineUsersJob.class);
    }
}
