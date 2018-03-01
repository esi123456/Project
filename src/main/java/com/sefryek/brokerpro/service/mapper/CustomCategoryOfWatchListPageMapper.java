package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.mobile.watchlist.WatchLists;
import org.springframework.stereotype.Component;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 17, Jul, 2017
 */
@Component
public class CustomCategoryOfWatchListPageMapper extends CustomPageMapper<WatchLists> {

    @Override
    public com.sefryek.brokerpro.dto.response.Page<WatchLists> as(org.springframework.data.domain.Page<WatchLists> in) {
        return super.as(in);
    }

}
