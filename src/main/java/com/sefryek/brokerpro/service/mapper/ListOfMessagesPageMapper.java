package com.sefryek.brokerpro.service.mapper;

import com.sefryek.brokerpro.dto.response.market.message.ListOfMessage;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

/**
 * Created by Amin on 7/23/2017.
 */
@Mapper(withIoC = IoC.SPRING, withIgnoreMissing = IgnoreMissing.ALL, withCustom = CustomListOfMessagesPageMapper.class)
public interface ListOfMessagesPageMapper extends SelmaObjectMapper<org.springframework.data.domain.Page<ListOfMessage>, com.sefryek.brokerpro.dto.response.Page<ListOfMessage>> {
}