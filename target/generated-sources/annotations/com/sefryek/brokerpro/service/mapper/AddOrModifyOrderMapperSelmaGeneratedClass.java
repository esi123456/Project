// GENERATED BY S3LM4
package com.sefryek.brokerpro.service.mapper;


@org.springframework.stereotype.Service("")
public final class AddOrModifyOrderMapperSelmaGeneratedClass
    implements AddOrModifyOrderMapper {

  @Override
  public final com.sefryek.brokerpro.dto.response.mobile.order.AddOrModifyOrder as(com.sefryek.brokerpro.tadbir.dto.response.mobile.order.AddOrModifyOrderTadbir in) {
    com.sefryek.brokerpro.dto.response.mobile.order.AddOrModifyOrder out = null;
    if (in != null) {
      out = new com.sefryek.brokerpro.dto.response.mobile.order.AddOrModifyOrder();
      out.setOrderId(in.getOrderId());
    }
    return out;
  }



  /**
   * Single constructor
   */
  public AddOrModifyOrderMapperSelmaGeneratedClass() {
  }

}
