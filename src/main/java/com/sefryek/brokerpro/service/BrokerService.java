package com.sefryek.brokerpro.service;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.domain.Broker;
import com.sefryek.brokerpro.domain.BrokerDeviceType;
import com.sefryek.brokerpro.dto.request.BrokerRequest;
import com.sefryek.brokerpro.dto.response.DefaultResponse;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.exception.BrokerNotFoundException;
import com.sefryek.brokerpro.repository.cache.BrokerCacheRepository;
import com.sefryek.brokerpro.repository.mongo.BrokerRepository;
import com.sefryek.brokerpro.service.mapper.BrokerPageMapper;
import com.sefryek.brokerpro.service.mapper.BrokersMapper;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.tadbir.dto.response.market.broker.Brokers;
import com.sefryek.util.CollectionUtils;
import com.sefryek.util.ObjectUtils;
import com.sefryek.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@PropertySource("classpath:brokers-${spring.profiles.active}.properties")
public class BrokerService extends Service<Brokers> {

    @Autowired
    private BrokerCacheRepository brokerCacheRepository;

    @Autowired
    private BrokerRepository brokerRepository;

    @Autowired
    private BrokersMapper brokersMapper;

    @Autowired
    private BrokerPageMapper brokerPageMapper;

    public BrokerService() {
        super(Brokers.class);
    }

    public Broker findByCodeAndDeviceType(String code, BrokerDeviceType deviceType) {
        Assert.notNull(code);
        Broker broker = brokerCacheRepository.findByCodeLikeAndDeviceTypeInAndActiveTrue(code, Arrays.asList(new String[]{deviceType.getCode(), BrokerDeviceType.ALL.getCode()}));
        if (ObjectUtils.isNotNull(broker)) {
            return broker;
        }
        throw new BrokerNotFoundException();
    }

    public Response<Page<Broker>> findActiveBrokersByDeviceType(BrokerRequest request) {
        Assert.notNull(request);
        PageRequest pageRequest = getPageRequest(request);
        org.springframework.data.domain.Page<Broker> page = brokerCacheRepository.findByDeviceTypeInAndActiveTrue(Arrays.asList(new String[]{String.valueOf(request.getDeviceType()), BrokerDeviceType.ALL.getCode()}), pageRequest);
        Page<Broker> result = brokerPageMapper.as(page);
        Response<Page<Broker>> response = new Response<>();
        response.setResponse(result);
        createSuccessResponse(response);
        return response;
    }

    public List<Broker> findAll() {
        return (List<Broker>) brokerCacheRepository.findAll();
    }

    public Response<DefaultResponse> syncBrokersWithMongo() {
        syncBrokersWithMongoDb();
        Response<DefaultResponse> response = new Response<>();
        createSuccessResponse(response);
        return response;
    }

    private void syncBrokersWithMongoDb() {
        brokerCacheRepository.save(brokerRepository.findAll());
    }

    public synchronized void syncBrokersWithTadbir() {
        Brokers tadbirBrokers = findAllBrokersFromTadbir();
        syncBrokersWithMongoDb();
        if (ObjectUtils.isNotNull(tadbirBrokers) && CollectionUtils.isNotEmpty(tadbirBrokers.getBroker())) {
            /** Tadbir send some brokers with brokerUrl=null so we have to filter these invalid brokers, that means broker is inactive **/
            List<com.sefryek.brokerpro.tadbir.dto.response.market.broker.Broker> tadbirBrokerList = new ArrayList<>();
            for (com.sefryek.brokerpro.tadbir.dto.response.market.broker.Broker broker : tadbirBrokers.getBroker()){
                if(StringUtils.isNotEmpty(broker.getBrokerUrl())){
                        tadbirBrokerList.add(broker);
                }
            }
            List<Broker> newBrokers = brokersMapper.as(tadbirBrokerList);
            List<Broker> result;
            result = inactiveOldBrokers(newBrokers, brokerRepository.findAll());
            result.addAll(newBrokers);
            save(result);
        }
    }

    /** Inactive all Brokers there are in database (or cache) but there aren't in current Tadbir's response. **/
    private List<Broker> inactiveOldBrokers(List<Broker> newBrokers, List<Broker> oldBrokers) {
        List<Broker> result = new ArrayList<>();
        for(Broker oldBroker : oldBrokers){
            boolean find = false;
            for(Broker newBroker : newBrokers){
                if(oldBroker.getCode().equals(newBroker.getCode())){
                    find = true;
                    break;
                }
            }
            if(!find){
                oldBroker.setActive(false);
                result.add(oldBroker);
            }
        }
        return result;
    }

    public Brokers findAllBrokersFromTadbir() {
        UrlBuilder urlBuilder = new UrlBuilder(createMarketUrl(Constants.BROKERS_URL), ODataAuthStrategy.NONE);
        return callWebServiceHttpMethodGET(urlBuilder);
    }

    public Broker findOne(String code) {
        return brokerCacheRepository.findOne(code);
    }

    @Transactional
    public void save(List<Broker> brokers) {
        brokerCacheRepository.save(brokerRepository.save(brokers));
    }

}
