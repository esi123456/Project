package com.sefryek.brokerpro;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.repository.cache.ExchangeCacheRepository;
import com.sefryek.brokerpro.repository.mongo.ExchangeRepository;
import com.sefryek.brokerpro.service.*;
import com.sefryek.brokerpro.service.commision.CommissionService;
import com.sefryek.brokerpro.service.gateway.OnlineUsersService;
import com.sefryek.brokerpro.service.mobile.exchange.ExchangeBrokerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup {

    private static final Logger log = LoggerFactory.getLogger(ApplicationStartup.class);

    @Autowired
    private Environment env;
    @Autowired
    private BrokerService brokerService;
    @Autowired
    private ExchangeCompanyService exchangeCompanyService;
    @Autowired
    private ExchangeBrokerService exchangeBrokerService;
    @Autowired
    private LoginGatewayService loginGatewayService;
    @Autowired
    private FinancialProvidersService financialProvidersService;
    @Autowired
    private CommissionService commissionService;
    @Autowired
    private ExchangeRepository exchangeRepository;
    @Autowired
    private ExchangeCacheRepository exchangeCacheRepository;
    @Autowired
    private OnlineUsersService onlineUsersService;
//    @Autowired
//    /private LightStreemerService LightStreemerService;

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReadyEvent() {
        log.info("Application Ready Event on Startup App");
        brokerService.syncBrokersWithTadbir();
        loginGatewayService.loginAllBrokers();
        if (env.acceptsProfiles(Constants.SPRING_PROFILE_PRODUCTION) || env.acceptsProfiles(Constants.SPRING_PROFILE_TEST)) {
            exchangeCompanyService.syncExchangeCompanyWithTadbir();
        } else {
            exchangeCacheRepository.save(exchangeRepository.findAll());
        }
        exchangeBrokerService.syncExchangeBrokerWithTadbir();
        financialProvidersService.syncFinancialWithTadbir();
        commissionService.syncCommissionWithTadbir();
        onlineUsersService.onlineUsersAllBrokers();
//        LightStreemerService.subscribeAllBrokers();
    }

}
