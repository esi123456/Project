// GENERATED BY S3LM4
package com.sefryek.brokerpro.service.mapper;


@org.springframework.stereotype.Service("")
public final class DepositListPageMapperSelmaGeneratedClass
    implements DepositListPageMapper {

  @Override
  public final com.sefryek.brokerpro.dto.response.Page<com.sefryek.brokerpro.dto.response.mobile.peyment.DepositList> as(org.springframework.data.domain.Page<com.sefryek.brokerpro.dto.response.mobile.peyment.DepositList> in) {
    com.sefryek.brokerpro.dto.response.Page<com.sefryek.brokerpro.dto.response.mobile.peyment.DepositList> out = null;
    if (in != null) {
      out = customMapperCustomDepositListPageMapper.as(in);
    }
    return out;
  }



  /**
   * This field is used for custom Mapping
   */
  @org.springframework.beans.factory.annotation.Autowired
  private CustomDepositListPageMapper customMapperCustomDepositListPageMapper;

  /**
   * Custom Mapper setter for customMapperCustomDepositListPageMapper
   */
  public final void setCustomMapperCustomDepositListPageMapper(CustomDepositListPageMapper mapper) {
    this.customMapperCustomDepositListPageMapper = mapper;
  }


  /**
   * Single constructor
   */
  public DepositListPageMapperSelmaGeneratedClass() {
    this.customMapperCustomDepositListPageMapper = new com.sefryek.brokerpro.service.mapper.CustomDepositListPageMapper();
  }

}