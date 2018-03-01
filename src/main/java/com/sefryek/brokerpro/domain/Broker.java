package com.sefryek.brokerpro.domain;
/*
 * Copyright 2016 (C) syspod.co
 * 
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@KeySpace("broker")
@Document(collection = "broker")
public class Broker extends Entity implements Comparable<Broker> {

    @Id
    @Field("id")
    private String code;
    @Field("name")
    private String name;
    @Field("en_name")
    private String enName;
    @Field("device_type")
    private BrokerDeviceType deviceType;
    @Field("logo_url")
    private String logoUrl;
    @Field("broker_url")
    @JsonIgnore
    private String brokerUrl;
    @Field("ls_url")
    private String lsUrl;
    @Field("active")
    @JsonIgnore
    private Boolean active = Boolean.TRUE;

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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Broker{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", enName='" + enName + '\'' +
                ", deviceType=" + deviceType +
                ", logoUrl='" + logoUrl + '\'' +
                ", brokerUrl='" + brokerUrl + '\'' +
                ", lsUrl='" + lsUrl + '\'' +
                ", active=" + active +
                '}';
    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Broker broker = (Broker) o;

        return code != null ? code.equals(broker.code) : broker.code == null;
    }

    @Override
    public int compareTo(Broker broker) {
        String code = broker.getCode();
        //ascending order
        return this.code.compareTo(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}