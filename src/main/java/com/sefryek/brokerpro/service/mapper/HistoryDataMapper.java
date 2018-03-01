package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.market.history.HistoryData;
import com.sefryek.brokerpro.tadbir.dto.response.market.history.HistoryDataTadbir;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 26, Dec, 2016
 */
@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL)
public interface HistoryDataMapper extends SelmaObjectMapper<List<HistoryDataTadbir>, List<HistoryData>> {
}
