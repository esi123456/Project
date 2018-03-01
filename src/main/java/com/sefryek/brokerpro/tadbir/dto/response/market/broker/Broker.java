package com.sefryek.brokerpro.tadbir.dto.response.market.broker;
/*
 * Copyright 2016 (C) syspod.co
 * 
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Broker {
    @JsonProperty("FaName")
    private String name;
    @JsonProperty("EnName")
    private String enName;
    @JsonProperty("Code")
    private String code;
    @JsonProperty("Status")
    private BrokerDeviceType deviceType;
    @JsonProperty("LogoUrl")
    private String logoUrl;
    @JsonProperty("BrokerUrl")
    private String brokerUrl;
    @JsonProperty("LsBrokerUrl")
    private String lsUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BrokerDeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(BrokerDeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getBrokerUrl() {
        return brokerUrl;
    }

    public void setBrokerUrl(String brokerUrl) {
        this.brokerUrl = brokerUrl;
    }

    public String getLsUrl() {
        return lsUrl;
    }

    public void setLsUrl(String lsUrl) {
        this.lsUrl = lsUrl;
    }

    @Override
    public String toString() {
        return "Broker{" +
                "name='" + name + '\'' +
                ", enName='" + enName + '\'' +
                ", code='" + code + '\'' +
                ", deviceType=" + deviceType +
                ", logoUrl='" + logoUrl + '\'' +
                ", brokerUrl='" + brokerUrl + '\'' +
                ", lsUrl='" + lsUrl + '\'' +
                '}';
    }
}