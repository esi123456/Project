package com.sefryek.brokerpro.dto.response.mobile;

import java.util.Date;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Ismael Sadeghi
 * @email: ismaelsadeghi111@gmail.com
 * @date: 13, Jan, 2018
 */
public class CustomerDevice {
    private String deviceIp;
    private String deviceOS;
    private Date dateTime;
    private String appVersion;
    private Boolean root;
    private String userName;
    private String iMEI;
    private String longitude;
    private String latitude;
    private String deviceModel;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    @Override
    public String toString() {
        return "CustomerDevice{" +
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
                '}';
    }
}
