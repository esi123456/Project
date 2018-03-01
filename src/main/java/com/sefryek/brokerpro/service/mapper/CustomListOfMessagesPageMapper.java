package com.sefryek.brokerpro.service.mapper;

        import com.sefryek.brokerpro.dto.response.market.message.ListOfMessage;
        import org.springframework.stereotype.Component;

/**
 * Created by Amin on 7/23/2017.
 */
@Component
public class CustomListOfMessagesPageMapper extends CustomPageMapper<ListOfMessage> {

    @Override
    public com.sefryek.brokerpro.dto.response.Page<ListOfMessage> as(org.springframework.data.domain.Page<ListOfMessage> in) {
        return super.as(in);
    }

}