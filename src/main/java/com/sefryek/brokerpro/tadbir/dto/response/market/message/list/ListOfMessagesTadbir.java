package com.sefryek.brokerpro.tadbir.dto.response.market.message.list;

import com.fasterxml.jackson.annotation.*;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirPageableResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 09, Jan, 2017
 */

public class ListOfMessagesTadbir extends TadbirPageableResponse {

    @JsonProperty("Messages")
    private List<ListOfMessageTadbir> listOfMessages = new ArrayList<>();

    public List<ListOfMessageTadbir> getListOfMessages() {
        return listOfMessages;
    }

    public void setListOfMessages(List<ListOfMessageTadbir> listOfMessages) {
        this.listOfMessages = listOfMessages;
    }

    @Override
    public String toString() {
        return "ListOfMessagesTadbir{" +
                "listOfMessages=" + listOfMessages +
                "} " + super.toString();
    }
}
