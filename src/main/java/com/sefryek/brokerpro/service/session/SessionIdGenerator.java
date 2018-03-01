package com.sefryek.brokerpro.service.session;


import org.jasypt.digest.PooledStringDigester;

import java.util.UUID;

public class SessionIdGenerator {


    public String generateToken(String username, String inputToken, long newId) {
        String key = String.format("%s-%s-%s-%s-%s", generateUUID(), newId, username, System.currentTimeMillis(), inputToken);

        PooledStringDigester digester = new PooledStringDigester();
        digester.setPoolSize(8);          // This would be a good value for a 4-core system
        digester.setAlgorithm("SHA-512");
        digester.setIterations(1);
        // this is the authentication token user will send in order to use the web service
        return digester.digest(key);
    }

    private static String generateUUID() {
        return UUID.randomUUID().toString().toUpperCase();
    }

}
