package com.sefryek.brokerpro.dto.request;

import com.sefryek.brokerpro.domain.DeviceType;

import javax.validation.constraints.NotNull;

public class BrokerRequest extends Request {

    @NotNull
    private DeviceType deviceType;

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    @Override
    public String toString() {
        return "BrokerRequest{" +
                "deviceType=" + deviceType +
                '}';
    }
}
