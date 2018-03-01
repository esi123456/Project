package com.sefryek.brokerpro.config;

import com.hazelcast.config.*;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.instance.HazelcastInstanceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.hazelcast.HazelcastKeyValueAdapter;
import org.springframework.data.hazelcast.repository.config.EnableHazelcastRepositories;
import org.springframework.data.keyvalue.core.KeyValueOperations;
import org.springframework.data.keyvalue.core.KeyValueTemplate;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
@EnableCaching
@AutoConfigureAfter(value = {MetricsConfiguration.class})
@EnableHazelcastRepositories(repositoryImplementationPostfix = "CacheRepository", basePackages = {"com.sefryek.brokerpro.repository.cache", "com.sefryek.brokerpro.domain", "com.sefryek.brokerpro.domain.mongo"})
@Profile("!" + Constants.SPRING_PROFILE_FAST)
public class CacheConfiguration {

    private static final String BROKER_PRO = "broker-pro";
    private final Logger log = LoggerFactory.getLogger(CacheConfiguration.class);

    @Autowired
    private Environment env;

    private CacheManager cacheManager;

    @PreDestroy
    public void destroy() {
        log.info("Closing Cache Manager");
        Hazelcast.shutdownAll();
    }

    @Bean
    @Autowired
    public CacheManager cacheManager(HazelcastInstance hazelcastInstance) {
        log.debug("Starting HazelcastCacheManager");
        cacheManager = new com.hazelcast.spring.cache.HazelcastCacheManager(hazelcastInstance);
        return cacheManager;
    }

    @Bean
    @PostConstruct
    public HazelcastInstance hazelcastInstance() {
        Config config = new Config();
        GroupConfig groupConfig = config.getGroupConfig();
        groupConfig.setName(env.getProperty("cache.group.name", String.class, "sefryek"));
        groupConfig.setPassword(env.getProperty("cache.group.password", String.class, "sefryek-password"));
        config.setGroupConfig(groupConfig);
        if (env.acceptsProfiles(Constants.SPRING_PROFILE_DEVELOPMENT)) {
            config.setInstanceName(String.format("%s-%s", BROKER_PRO, Constants.SPRING_PROFILE_DEVELOPMENT));
            System.setProperty("hazelcast.local.localAddress", "127.0.0.1");
            config.getNetworkConfig().getJoin().getAwsConfig().setEnabled(false);
            config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);
            config.getNetworkConfig().getJoin().getTcpIpConfig().setEnabled(false);
        } else if (env.acceptsProfiles(Constants.SPRING_PROFILE_PRODUCTION)) {
            config.setInstanceName(String.format("%s-%s", BROKER_PRO, Constants.SPRING_PROFILE_PRODUCTION));
            config.getNetworkConfig().getJoin().getAwsConfig().setEnabled(false);
            config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);
            TcpIpConfig tcpIpConfig = config.getNetworkConfig().getJoin().getTcpIpConfig().setEnabled(true);
            String[] ips = env.getProperty("cache.servers", String[].class, new String[]{});
            for (String ip : ips) {
                tcpIpConfig.addMember(ip);
            }
            config.getNetworkConfig().getJoin().setTcpIpConfig(tcpIpConfig);
        } else {
            config.setInstanceName(BROKER_PRO);
            groupConfig.setName(String.format("%s", BROKER_PRO));
        }
        config.getNetworkConfig().setPort(5701);
        config.getNetworkConfig().setPortAutoIncrement(true);
        config.setProperty("hazelcast.socket.bind.any", "false");
        config.setProperty("hazelcast.socket.server.bind.any", "false");
        config.setProperty("hazelcast.socket.client.bind.any", "false");
        config.setProperty("hazelcast.socket.client.bind", "false");
        config.getMapConfigs().put("default", initializeDefaultMapConfig());
        return HazelcastInstanceFactory.newHazelcastInstance(config);
    }

    private MapConfig initializeDefaultMapConfig() {
        MapConfig mapConfig = new MapConfig();

        /*
            Number of backups. If 1 is set as the backup-count for example,
            then all entries of the map will be copied to another JVM for
            fail-safety. Valid numbers are 0 (no backup), 1, 2, 3.
         */
        mapConfig.setBackupCount(0);

        /*
            Valid values are:
            NONE (no eviction),
            LRU (Least Recently Used),
            LFU (Least Frequently Used).
            NONE is the default.
         */
        mapConfig.setEvictionPolicy(EvictionPolicy.NONE);

        /*
            Maximum size of the map. When max size is reached,
            map is evicted based on the policy defined.
            Any integer between 0 and Integer.MAX_VALUE. 0 means
            Integer.MAX_VALUE. Default is 0.
         */
        mapConfig.setMaxSizeConfig(new MaxSizeConfig(0, MaxSizeConfig.MaxSizePolicy.USED_HEAP_SIZE));

        /*
            When max. size is reached, specified percentage of
            the map will be evicted. Any integer between 0 and 100.
            If 25 is set for example, 25% of the entries will
            get evicted.
         */
//        mapConfig.setEvictionPercentage(25);

        mapConfig.setCacheDeserializedValues(CacheDeserializedValues.ALWAYS);
        mapConfig.setInMemoryFormat(InMemoryFormat.BINARY);
        return mapConfig;
    }

    private MapConfig initializeDomainMapConfig() {
        MapConfig mapConfig = new MapConfig();

        mapConfig.setTimeToLiveSeconds(env.getProperty("cache.timeToLiveSeconds", Integer.class, 3600));
        return mapConfig;
    }


    private MapConfig initializeClusteredSession() {
        MapConfig mapConfig = new MapConfig();

        mapConfig.setBackupCount(env.getProperty("cache.hazelcast.backupCount", Integer.class, 1));
        mapConfig.setTimeToLiveSeconds(env.getProperty("cache.timeToLiveSeconds", Integer.class, 3600));
        return mapConfig;
    }

    @Bean
    public HazelcastKeyValueAdapter hazelcastKeyValueAdapter(HazelcastInstance hazelcastInstance) {
        return new HazelcastKeyValueAdapter(hazelcastInstance);
    }

    @Autowired
    @Bean
    public KeyValueOperations keyValueTemplate(HazelcastKeyValueAdapter hazelcastKeyValueAdapter) {
        return new KeyValueTemplate(hazelcastKeyValueAdapter);
    }

    /**
     * Use by Spring Security, to get events from Hazelcast.
     *
     * @return the session registry
     */
    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }
}
