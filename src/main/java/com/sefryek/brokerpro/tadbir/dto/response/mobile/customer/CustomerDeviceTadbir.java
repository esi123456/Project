package com.sefryek.brokerpro.tadbir.dto.response.mobile.customer;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Ismael Sadeghi
 * @email: ismaelsadeghi111@gmail.com
 * @date: 13, Jan, 2018
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDeviceTadbir {
    @JsonProperty("DeviceIp")
    private String deviceIp;
    @JsonProperty("DeviceOS")
    private String deviceOS;
    @JsonProperty("DateTime")
    private Date dateTime;
    @JsonProperty("AppVersion")
    private String appVersion;
    @JsonProperty("Root")
    private Boolean root;
    @JsonProperty("UserName")
    private String userName;
    @JsonProperty("IMEI")
    private String iMEI;
    @JsonProperty("Longitude")
    private String longitude;
    @JsonProperty("Latitude")
    private String latitude;
    @JsonProperty("DeviceModel")
    private String deviceModel;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getDeviceIp() {
        return deviceIp;
    }

    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }

    public String getDeviceOS() {
        return deviceOS;
    }

    public void setDeviceOS(String deviceOS) {
        this.deviceOS = deviceOS;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public Boolean getRoot() {
        return root;
    }

    public void setRoot(Boolean root) {
        this.root = root;
    }

    public String getiMEI() {
        return iMEI;
    }

    public void setiMEI(String iMEI) {
        this.iMEI = iMEI;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "CustomerDeviceTadbir{" +
                "deviceIp='" + deviceIp + '\'' +
                ", deviceOS='" + deviceOS + '\'' +
                ", dateTime=" + dateTime +
                ", appVersion='" + appVersion + '\'' +
                ", root=" + root +
                ", userName='" + userName + '\'' +
                ", iMEI='" + iMEI + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", deviceModel='" + deviceModel + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
