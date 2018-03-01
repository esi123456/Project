package com.sefryek.brokerpro.service.gateway;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sefryek.brokerpro.domain.Broker;
import com.sefryek.brokerpro.domain.DeviceType;
import com.sefryek.brokerpro.domain.GatewayUser;
import com.sefryek.brokerpro.dto.request.gateway.OnlineUsersRequest;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.gateway.OnlineUsers;
import com.sefryek.brokerpro.exception.ErrorCode;
import com.sefryek.brokerpro.repository.cache.BrokerCacheRepository;
import com.sefryek.brokerpro.repository.cache.SessionCacheRepository;
import com.sefryek.brokerpro.repository.mongo.GatewayUserRepository;
import com.sefryek.brokerpro.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;


/**
 * @author Amin Malekpour
 * @email amin.malekpour@hotmail.com
 * @date 16 Dec 2017
 */
@Component
public class OnlineUsersService extends Service<OnlineUsers> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SessionCacheRepository sessionCacheRepository;

    @Autowired
    private BrokerCacheRepository brokerCacheRepository;

    @Autowired
    private GatewayUserRepository gatewayUserRepository;

    public OnlineUsersService() {
        super(OnlineUsers.class);
    }

    public Response<List<OnlineUsers>> executeOnlineUsers(OnlineUsersRequest onlineUsersRequest) {
        Assert.notNull(onlineUsersRequest);
        Assert.notNull(onlineUsersRequest.getUserName());
        Assert.notNull(onlineUsersRequest.getPassword());
        List<OnlineUsers> result = new ArrayList<>();
        Response<List<OnlineUsers>> response = new Response<>();

        GatewayUser gatewayUser = gatewayUserRepository.findOneByUserNameAndActiveTrue(onlineUsersRequest.getUserName());
        if(gatewayUser != null && onlineUsersRequest.getUserName().equals(gatewayUser.getUserName()) && onlineUsersRequest.getPassword().equals(gatewayUser.getPassword())) {
            result.add(createOnlineUsersForAllBrokers());
            List<Broker> brokers = brokerCacheRepository.findAllByActiveTrue();
            for (Broker broker : brokers) {
                long onlineAndroidUsers = sessionCacheRepository.countByBrokerCodeAndDeviceTypeAndExpiresGreaterThanEqual(broker.getCode(), DeviceType.ANDROID, System.currentTimeMillis());
                long onlineIosUsers = sessionCacheRepository.countByBrokerCodeAndDeviceTypeAndExpiresGreaterThanEqual(broker.getCode(), DeviceType.IOS, System.currentTimeMillis());
                long allSeassions = sessionCacheRepository.countByBrokerCode(broker.getCode());
                long allAndroidSeassions = sessionCacheRepository.countByBrokerCodeAndDeviceType(broker.getCode(), DeviceType.ANDROID);
                long allIosSeassions = sessionCacheRepository.countByBrokerCodeAndDeviceType(broker.getCode(), DeviceType.IOS);
                long allOnlineUsers = onlineAndroidUsers + onlineIosUsers;
                OnlineUsers tempResult = new OnlineUsers(broker.getCode(), broker.getName(), allOnlineUsers, onlineAndroidUsers, onlineIosUsers, new Date(), allSeassions, allAndroidSeassions, allIosSeassions);
                result.add(tempResult);
            }
            response.setSuccessful(Boolean.TRUE);
        } else {
            response.setSuccessful(Boolean.FALSE);
            response.setErrorCode(String.valueOf(ErrorCode.AUTHORIZATION_EXCEPTION.getHttpResponseCode()));
            response.setErrorDescription(ErrorCode.AUTHORIZATION_EXCEPTION.getDescription());
        }
        response.setResponse(result);
        return response;
    }

    private OnlineUsers createOnlineUsersForAllBrokers() {
        long onlineAndroidUsers = sessionCacheRepository.countByDeviceTypeAndExpiresGreaterThanEqual(DeviceType.ANDROID, System.currentTimeMillis());
        long onlineIosUsers = sessionCacheRepository.countByDeviceTypeAndExpiresGreaterThanEqual(DeviceType.IOS, System.currentTimeMillis());
        long allSeassions =  sessionCacheRepository.count();
        long allAndroidSeassions =  sessionCacheRepository.countByDeviceType(DeviceType.ANDROID);
        long allIosSeassions =  sessionCacheRepository.countByDeviceType(DeviceType.IOS);
        long allOnlineUsers = onlineAndroidUsers + onlineIosUsers;
        OnlineUsers result = new OnlineUsers("ALL Brokers", "ALL Brokers", allOnlineUsers, onlineAndroidUsers, onlineIosUsers, new Date(), allSeassions, allAndroidSeassions, allIosSeassions);
        return result;
    }


    public void onlineUsersAllBrokers() {
        List<OnlineUsers> result = new ArrayList<>();
        result.add(createOnlineUsersForAllBrokers());
        log.info(String.format(result.toString()));
    }

}
