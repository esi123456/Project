package com.sefryek.brokerpro.dto.request;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 08, Mar, 2017
 */
public class MessagesRequest extends Request{

    private Long messageId;
    private Boolean onlyRead;

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Boolean getOnlyRead() {
        return onlyRead;
    }

    public void setOnlyRead(Boolean onlyRead) {
        this.onlyRead = onlyRead;
    }

    @Override
    public String toString() {
        return "MessagesPageable{" +
                "onlyRead=" + onlyRead +
                ", messageId=" + messageId +
                '}';
    }
}
