package com.sefryek.brokerpro.dto.response.gateway;


import java.util.Date;

/**
 * @author Amin Malekpour
 * @email amin.malekpour@hotmail.com
 * @date 16 Dec 2017
 */
public class OnlineUsers {
    private String brokerCode;
    private String brokerName;
    private Long onlineUsers;
    private Long onlineAndroidUsers;
    private Long onlineIosUsers;
    private Date dateTime;
    private Long allSeassions;
    private Long allAndroidSeassions;
    private Long allIosSeassions;

    public OnlineUsers(String brokerCode, String brokerName, Long onlineUsers, Long onlineAndroidUsers, Long onlineIosUsers, Date dateTime, Long allSeassions, Long allAndroidSeassions, Long allIosSeassions) {
        this.brokerCode = brokerCode;
        this.brokerName = brokerName;
        this.onlineUsers = onlineUsers;
        this.onlineAndroidUsers = onlineAndroidUsers;
        this.onlineIosUsers = onlineIosUsers;
        this.dateTime = dateTime;
        this.allSeassions = allSeassions;
        this.allAndroidSeassions = allAndroidSeassions;
        this.allIosSeassions = allIosSeassions;
    }

    public String getBrokerCode() {
        return brokerCode;
    }

    public void setBrokerCode(String brokerCode) {
        this.brokerCode = brokerCode;
    }

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    public Long getOnlineUsers() {
        return onlineUsers;
    }

    public void setOnlineUsers(Long onlineUsers) {
        this.onlineUsers = onlineUsers;
    }

    public Long getOnlineAndroidUsers() {
        return onlineAndroidUsers;
    }

    public void setOnlineAndroidUsers(Long onlineAndroidUsers) {
        this.onlineAndroidUsers = onlineAndroidUsers;
    }

    public Long getOnlineIosUsers() {
        return onlineIosUsers;
    }

    public void setOnlineIosUsers(Long onlineIosUsers) {
        this.onlineIosUsers = onlineIosUsers;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Long getAllSeassions() {
        return allSeassions;
    }

    public void setAllSeassions(Long allSeassions) {
        this.allSeassions = allSeassions;
    }

    public Long getAllAndroidSeassions() {
        return allAndroidSeassions;
    }

    public void setAllAndroidSeassions(Long allAndroidSeassions) {
        this.allAndroidSeassions = allAndroidSeassions;
    }

    public Long getAllIosSeassions() {
        return allIosSeassions;
    }

    public void setAllIosSeassions(Long allIosSeassions) {
        this.allIosSeassions = allIosSeassions;
    }

    @Override
    public String toString() {
        return "OnlineUsers{" +
                "brokerCode='" + brokerCode + '\'' +
                ", brokerName='" + brokerName + '\'' +
                ", onlineUsers=" + onlineUsers +
                ", onlineAndroidUsers=" + onlineAndroidUsers +
                ", onlineIosUsers=" + onlineIosUsers +
                ", dateTime=" + dateTime +
                ", allSeassions=" + allSeassions +
                ", allAndroidSeassions=" + allAndroidSeassions +
                ", allIosSeassions=" + allIosSeassions +
                '}';
    }
}
