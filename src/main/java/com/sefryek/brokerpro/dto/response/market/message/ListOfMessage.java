package com.sefryek.brokerpro.dto.response.market.message;

import java.util.Date;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, Jan, 2017
 */
public class ListOfMessage {
    private Long messageId;
    private Date messageDate;
    private String messageTitle;
    private String messageDetail;

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

    @Override
    public String toString() {
        return "ListOfMessage{" +
                "messageId=" + messageId +
                ", messageDate=" + messageDate +
                ", messageTitle='" + messageTitle + '\'' +
                ", messageDetail='" + messageDetail + '\'' +
                '}';
    }
}
