// GENERATED BY S3LM4
package com.sefryek.brokerpro.service.mapper;


@org.springframework.stereotype.Service("")
public final class GetChangeBrokerPageMapperSelmaGeneratedClass
    implements GetChangeBrokerPageMapper {

  @Override
  public final com.sefryek.brokerpro.dto.response.Page<com.sefryek.brokerpro.dto.response.mobile.broker.ChangeBroker> as(org.springframework.data.domain.Page<com.sefryek.brokerpro.dto.response.mobile.broker.ChangeBroker> in) {
    com.sefryek.brokerpro.dto.response.Page<com.sefryek.brokerpro.dto.response.mobile.broker.ChangeBroker> out = null;
    if (in != null) {
      out = customMapperCustomGetChangeBrokerPageMapper.as(in);
    }
    return out;
  }



  /**
   * This field is used for custom Mapping
   */
  @org.springframework.beans.factory.annotation.Autowired
  private CustomGetChangeBrokerPageMapper customMapperCustomGetChangeBrokerPageMapper;

  /**
   * Custom Mapper setter for customMapperCustomGetChangeBrokerPageMapper
   */
  public final void setCustomMapperCustomGetChangeBrokerPageMapper(CustomGetChangeBrokerPageMapper mapper) {
    this.customMapperCustomGetChangeBrokerPageMapper = mapper;
  }


  /**
   * Single constructor
   */
  public GetChangeBrokerPageMapperSelmaGeneratedClass() {
    this.customMapperCustomGetChangeBrokerPageMapper = new com.sefryek.brokerpro.service.mapper.CustomGetChangeBrokerPageMapper();
  }

}
