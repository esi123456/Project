package com.sefryek.brokerpro.tadbir.dto.response.mobile.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirResponse;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "IsSuccessful",
        "ErrorCode",
        "ErrorDescription"
})
public class CancelOrderTadbir extends TadbirResponse {

    @Override
    public String toString() {
        return "CancelOrderTadbir{} " + super.toString();
    }
}