package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.mobile.message.Message;
import org.springframework.stereotype.Component;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 08, Apr, 2017
 */
@Component
public class CustomMessagesPageMapper extends CustomPageMapper<Message> {

    @Override
    public com.sefryek.brokerpro.dto.response.Page<Message> as(org.springframework.data.domain.Page<Message> in) {
        return super.as(in);
    }

}
