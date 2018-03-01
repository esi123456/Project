package com.sefryek.brokerpro.service.session;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.util.StringUtil;
import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.domain.Broker;
import com.sefryek.brokerpro.domain.BrokerDeviceType;
import com.sefryek.brokerpro.domain.DeviceType;
import com.sefryek.brokerpro.domain.Session;
import com.sefryek.brokerpro.repository.cache.SessionCacheRepository;
import com.sefryek.brokerpro.security.xauth.TokenProvider;
import com.sefryek.brokerpro.service.BrokerService;
import com.sefryek.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class SessionManager {

    @Autowired
    private SessionCacheRepository cacheRepository;
    @Autowired
    private SessionIdGenerator sessionIdGenerator;
    @Autowired
    private HazelcastInstance hazelcastInstance;
    @Autowired
    private TokenProvider tokenProvider;
    @Autowired
    private BrokerService brokerService;

    public void deleteSession(Session session) {
        if (session != null && StringUtils.isNotEmpty(session.getId())) {
            deleteSession(session.getId());
        }
    }

    public void deleteSession(String sessionId) {
        if (StringUtils.isNotEmpty(sessionId)) {
            cacheRepository.delete(sessionId);
        }
    }

    public Session createSession(String username, String customerISIN, String inputToken, Broker broker, DeviceType deviceType) {
        Assert.notNull(broker);
        String sessionId = sessionIdGenerator.generateToken(username, inputToken, getNewId());
        Session session = new Session(username, customerISIN, sessionId, broker.getCode(),inputToken);
        session.setBrokerCode(broker.getCode());
        session.setDeviceType(deviceType);
        session = updateSessionExpires(session);
        putSession(session);
        return session;
    }

    public long getNewId() {
        return hazelcastInstance.getIdGenerator(Constants.BROKER_PRO_ID_GENERATOR).newId();
    }

    public Session updateSessionExpires(Session session) {
        long expires = System.currentTimeMillis() + 8000L * tokenProvider.getTokenValidity();
//        String token = userDetails.getUsername() + ":" + expires + ":" + computeSignature(userDetails, expires);
//        return new Token(token, expires);
//    }

        session.setExpires(expires);
        return session;
    }

    public void putSession(Session session) {
        cacheRepository.save(session);
    }

    public boolean validateToken(String authToken) {
        if (StringUtil.isNullOrEmpty(authToken)) {
            return false;
        }
        Session session = getSession(authToken);
        if (session == null) {
            return false;
        }
        boolean status = session.getExpires() >= System.currentTimeMillis();
        if (Boolean.FALSE.equals(status)) {
            invalidateSession(authToken);
        }
        return status;
    }

    public Session getSession(String token) {
        return cacheRepository.findOne(token);
    }

    public void invalidateSession(String authToken) {
        deleteSession(authToken);
    }

    public Broker findByCodeAndDeviceType(String code, DeviceType deviceType) {
        BrokerDeviceType brokerDeviceType = BrokerDeviceType.fromString(String.valueOf(deviceType));
        return brokerService.findByCodeAndDeviceType(code, brokerDeviceType);
    }

}
