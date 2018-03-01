package com.sefryek.brokerpro.tadbir.dto.response.mobile.message;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirPageableResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 11, Mar, 2017
 */
public class MessagesTadbir extends TadbirPageableResponse {
    @JsonProperty("MessageList")
    private List<MessageTadbir> messageList = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<MessageTadbir> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<MessageTadbir> messageList) {
        this.messageList = messageList;
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
        return "MessagesTadbir{" +
                "messageList=" + messageList +
                ", additionalProperties=" + additionalProperties +
                "} " + super.toString();
    }
}
