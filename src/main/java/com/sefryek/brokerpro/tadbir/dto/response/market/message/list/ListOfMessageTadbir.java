package com.sefryek.brokerpro.tadbir.dto.response.market.message.list;

import com.fasterxml.jackson.annotation.*;
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
 * @date: 09, Jan, 2017
 */
public class ListOfMessageTadbir {
    @JsonProperty("MessageId")
    private Long messageId;
    @JsonDeserialize(using = DateFilterTadbir.class)
    @JsonProperty("MessageDate")
    private Date messageDate;
    @JsonProperty("MessageTitle")
    private String messageTitle;
    @JsonProperty("MessageDetail")
    private String messageDetail;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageDetail() {
        return messageDetail;
    }

    public void setMessageDetail(String messageDetail) {
        this.messageDetail = messageDetail;
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
        return "ListOfMessageTadbir{" +
                "messageId=" + messageId +
                ", messageDate=" + messageDate +
                ", messageTitle='" + messageTitle + '\'' +
                ", messageDetail='" + messageDetail + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
