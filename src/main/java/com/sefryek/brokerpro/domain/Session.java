package com.sefryek.brokerpro.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

@KeySpace("session")
public class Session extends Entity {

    @Id
    private String id;
    private String username;
    private String customerISIN;
    private String brokerCode;
    private String lsToken;
    private DeviceType deviceType;
    private DeviceInfo deviceInfo;
    private String ip;
    private long expires;

    public Session(String username, String customerISIN, String id, String brokerCode, String lsToken) {
        this.username = username;
        this.customerISIN = customerISIN;
        this.id = id;
        this.brokerCode = brokerCode;
        this.lsToken = lsToken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCustomerISIN() {
        return customerISIN;
    }

    public void setCustomerISIN(String customerISIN) {
        this.customerISIN = customerISIN;
    }

    public String getBrokerCode() {
        return brokerCode;
    }

    public void setBrokerCode(String brokerCode) {
        this.brokerCode = brokerCode;
    }

    public DeviceInfo getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public long getExpires() {
        return expires;
    }

    public void setExpires(long expires) {
        this.expires = expires;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", customerISIN='" + customerISIN + '\'' +
                ", brokerCode='" + brokerCode + '\'' +
                ", deviceInfo=" + deviceInfo +
                ", deviceType=" + deviceType +
                ", ip='" + ip + '\'' +
                ", expires=" + expires +
                '}';
    }
}
