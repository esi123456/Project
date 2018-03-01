package com.sefryek.brokerpro.tadbir.dto.response.mobile.message;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sefryek.brokerpro.config.jackson.DateFilterTadbir;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 08, Mar, 2017
 */
public class MessageTadbir {
    @JsonProperty("MessageId")
    private Long messageId;
    @JsonProperty("MessageString")
    private String messageString;
    @JsonProperty("MessageTitle")
    private String messageTitle;
    @JsonDeserialize(using = DateFilterTadbir.class)
    @JsonProperty("SendDate")
    private Date sendDate;
    @JsonDeserialize(using = DateFilterTadbir.class)
    @JsonProperty("ReadDate")
    private Date readDate;
    @JsonProperty("IsRead")
    private Boolean read;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getMessageString() {
        return messageString;
    }

    public void setMessageString(String messageString) {
        this.messageString = messageString;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Date getReadDate() {
        return readDate;
    }

    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
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
        return "MessageTadbir{" +
                "messageId=" + messageId +
                ", messageString='" + messageString + '\'' +
                ", messageTitle='" + messageTitle + '\'' +
                ", sendDate=" + sendDate +
                ", readDate=" + readDate +
                ", read=" + read +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

}
