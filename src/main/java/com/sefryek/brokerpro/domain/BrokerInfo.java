package com.sefryek.brokerpro.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 12, Aug, 2017
 */
@KeySpace("broker_info")
@Document(collection = "broker_info")
public class BrokerInfo extends Entity implements Comparable<BrokerInfo> {

    @Id
    @Field("id")
    private String code;
    @Field("username")
    @JsonIgnore
    private String userName;
    @Field("password")
    @JsonIgnore
    private String password;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "BrokerInfo{" +
                "code='" + code + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + "***" + '\'' +
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

        BrokerInfo brokerInfo = (BrokerInfo) o;

        return code != null ? code.equals(brokerInfo.code) : brokerInfo.code == null;
    }

    @Override
    public int compareTo(BrokerInfo brokerInfo) {
        String code = brokerInfo.getCode();
        //ascending order
        return this.code.compareTo(code);
    }

}