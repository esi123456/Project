package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.mobile.watchlist.WatchLists;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 17, Jul, 2017
 */
@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL, withCustom = CustomCategoryOfWatchListPageMapper.class)
public interface CategoryOfWatchListPageMapper extends SelmaObjectMapper<org.springframework.data.domain.Page<WatchLists>, com.sefryek.brokerpro.dto.response.Page<WatchLists>> {
}
