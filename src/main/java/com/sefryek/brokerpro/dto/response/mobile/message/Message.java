package com.sefryek.brokerpro.dto.response.mobile.message;

import java.util.Date;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 08, Mar, 2017
 */
public class Message {
    private Long messageId;
    private String messageString;
    private String messageTitle;
    private Date sendDate;
    private Date readDate;
    private Boolean read;

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

    @Override
    public String toString() {
        return "Messages{" +
                "messageId=" + messageId +
                ", messageString='" + messageString + '\'' +
                ", messageTitle='" + messageTitle + '\'' +
                ", sendDate=" + sendDate +
                ", readDate=" + readDate +
                ", read=" + read +
                '}';
    }
}
