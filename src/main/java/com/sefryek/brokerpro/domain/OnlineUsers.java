package com.sefryek.brokerpro.domain;//package com.sefryek.brokerpro.domain;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.keyvalue.annotation.KeySpace;
//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.Field;
//
//import java.util.Date;
//
///**
// * Copyright 2016 (C) sefryek.com
// *
// * @author: Ismael Sadeghi
// * @email: ismaelsadeghi111@gmail.com
// * @date: 22, Jan, 2018
// */
//@KeySpace("online_users")
//@Document(collection = "online_users")
//public class OnlineUsers extends Entity implements Comparable<OnlineUsers> {
//
//    @Id
//    @JsonIgnore
//    private String id;
//    @JsonIgnore
//    @Field("broker_Code")
//    private String brokerCode;
//    @Field("broker_Name")
//    private String brokerName;
//    @Field("online_Users")
//    private Long onlineUsers;
//    @Field("online_Android_Users")
//    private Long onlineAndroidUsers;
//    @Field("online_Ios_Users")
//    private Long onlineIosUsers;
//    @Field("date_Time")
//    private Date dateTime;
//    @Field("all_Seassions")
//    private Long allSeassions;
//    @Field("all_Android_Seassions")
//    private Long allAndroidSeassions;
//    @Field("all_Ios_Seassions")
//    private Long allIosSeassions;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getBrokerCode() {
//        return brokerCode;
//    }
//
//    public void setBrokerCode(String brokerCode) {
//        this.brokerCode = brokerCode;
//    }
//
//    public String getBrokerName() {
//        return brokerName;
//    }
//
//    public void setBrokerName(String brokerName) {
//        this.brokerName = brokerName;
//    }
//
//    public Long getOnlineUsers() {
//        return onlineUsers;
//    }
//
//    public void setOnlineUsers(Long onlineUsers) {
//        this.onlineUsers = onlineUsers;
//    }
//
//    public Long getOnlineAndroidUsers() {
//        return onlineAndroidUsers;
//    }
//
//    public void setOnlineAndroidUsers(Long onlineAndroidUsers) {
//        this.onlineAndroidUsers = onlineAndroidUsers;
//    }
//
//    public Long getOnlineIosUsers() {
//        return onlineIosUsers;
//    }
//
//    public void setOnlineIosUsers(Long onlineIosUsers) {
//        this.onlineIosUsers = onlineIosUsers;
//    }
//
//    public Date getDateTime() {
//        return dateTime;
//    }
//
//    public void setDateTime(Date dateTime) {
//        this.dateTime = dateTime;
//    }
//
//    public Long getAllSeassions() {
//        return allSeassions;
//    }
//
//    public void setAllSeassions(Long allSeassions) {
//        this.allSeassions = allSeassions;
//    }
//
//    public Long getAllAndroidSeassions() {
//        return allAndroidSeassions;
//    }
//
//    public void setAllAndroidSeassions(Long allAndroidSeassions) {
//        this.allAndroidSeassions = allAndroidSeassions;
//    }
//
//    public Long getAllIosSeassions() {
//        return allIosSeassions;
//    }
//
//    public void setAllIosSeassions(Long allIosSeassions) {
//        this.allIosSeassions = allIosSeassions;
//    }
//
//    @Override
//    public String toString() {
//        return "OnlineUsers{" +
//                "id='" + id + '\'' +
//                ", brokerCode='" + brokerCode + '\'' +
//                ", brokerName='" + brokerName + '\'' +
//                ", onlineUsers=" + onlineUsers +
//                ", onlineAndroidUsers=" + onlineAndroidUsers +
//                ", onlineIosUsers=" + onlineIosUsers +
//                ", dateTime=" + dateTime +
//                ", allSeassions=" + allSeassions +
//                ", allAndroidSeassions=" + allAndroidSeassions +
//                ", allIosSeassions=" + allIosSeassions +
//                '}';
//    }
//
//    @Override
//    public int hashCode() {
//        return id.hashCode();
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o)
//            return true;
//        if (o == null || getClass() != o.getClass())
//            return false;
//
//        OnlineUsers onlineUsers = (OnlineUsers) o;
//
//        return id.equals(onlineUsers.id);
//    }
//
//    @Override
//    public int compareTo(OnlineUsers onlineUsers) {
//        String OnlineUsersId = onlineUsers.getId();
//
//        return this.id.compareTo(OnlineUsersId);
//    }
//}
