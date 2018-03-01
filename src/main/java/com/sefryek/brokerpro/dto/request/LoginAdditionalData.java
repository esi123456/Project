package com.sefryek.brokerpro.dto.request;

/**
 * Copyright 2016 (C) syspod.co
 *
 * @auther: Ashkan Haghighi Kia
 * @email: kia@syspod.co
 */

public class LoginAdditionalData {

    private String ip;

    public LoginAdditionalData() {
    }

    public LoginAdditionalData(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "LoginAdditionalData{" +
                "ip='" + ip + '\'' +
                '}';
    }
}
