package com.sefryek.brokerpro.domain;

import java.io.Serializable;

/**
 * User: ashkan (kia@syspod.co)
 * Date: 01/14/2015
 * Time: 10:42 AM
 */
public class DeviceInfo implements Serializable {

    private String os;
    private String deviceModel;
    private String latitude;
    private String longitude;

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "DeviceInfo{" +
                "os='" + os + '\'' +
                ", deviceModel='" + deviceModel + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}