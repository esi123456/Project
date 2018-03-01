package com.sefryek.brokerpro.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sefryek.brokerpro.domain.DeviceType;

import javax.validation.constraints.NotNull;

public class LoginRequest extends Request {
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String brokerCode;
    @NotNull
    private DeviceType deviceType;

    @JsonIgnore
    private LoginAdditionalData additionalData;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBrokerCode() {
        return brokerCode;
    }

    public void setBrokerCode(String brokerCode) {
        this.brokerCode = brokerCode;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public LoginAdditionalData getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(LoginAdditionalData additionalData) {
        this.additionalData = additionalData;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "username='" + username + '\'' +
                ", password= ****** " +
                ", brokerCode='" + brokerCode + '\'' +
                ", deviceType=" + deviceType +
                ", additionalData=" + additionalData +
                "} ";
    }
}
