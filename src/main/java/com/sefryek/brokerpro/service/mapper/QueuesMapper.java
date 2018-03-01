package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.market.queue.Queue;
import com.sefryek.brokerpro.tadbir.dto.response.market.queue.QueueTadbir;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

import java.util.List;

/**
 * Created by amin.malekpour on 2016-12-13.
 */
@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL)
public interface QueuesMapper extends SelmaObjectMapper<List<QueueTadbir>, List<Queue>> {
}
