package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.mobile.watchlist.AddMemberToWatchListCategory;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.watchlist.AddMemberToWatchListCategoryTadbir;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 26, Feb, 2017
 */
@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL)
public interface AddMemberToWatchListCategoryMapper extends SelmaObjectMapper<AddMemberToWatchListCategoryTadbir, AddMemberToWatchListCategory> {
}
