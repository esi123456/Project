package com.sefryek.brokerpro.security.xauth;

public class ServiceProvider {

    private final int connectTimeout;
    private final int readTimeout;

    public ServiceProvider(int connectTimeout, int readTimeout) {
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }
}
