package com.sefryek.brokerpro.tadbir.dto.response.mobile.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirResponse;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "OrderId",
        "IsSuccessful",
        "ErrorCode",
        "ErrorDescription"
})
public class AddOrModifyOrderTadbir extends TadbirResponse {

    @JsonProperty("OrderId")
    private Long orderId;

    @JsonProperty("OrderId")
    public Long getOrderId() {
        return orderId;
    }

    @JsonProperty("OrderId")
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "AddOrModifyOrderTadbir{" +
                "orderId=" + orderId +
                "} " + super.toString();
    }
}