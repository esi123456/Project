// GENERATED BY S3LM4
package com.sefryek.brokerpro.service.mapper;


@org.springframework.stereotype.Service("")
public final class ExchangeBrokerMapperSelmaGeneratedClass
    implements ExchangeBrokerMapper {

  @Override
  public final java.util.List<com.sefryek.brokerpro.domain.ExchangeBroker> as(java.util.List<com.sefryek.brokerpro.tadbir.dto.response.market.exchange.broker.ExchangeBrokerDataTadbir> in) {
    java.util.List<com.sefryek.brokerpro.domain.ExchangeBroker> out = null;
    if (in != null) {
      out = customMapperCustomExchangeBrokerMapper.as(in);
    }
    return out;
  }



  /**
   * This field is used for custom Mapping
   */
  @org.springframework.beans.factory.annotation.Autowired
  private CustomExchangeBrokerMapper customMapperCustomExchangeBrokerMapper;

  /**
   * Custom Mapper setter for customMapperCustomExchangeBrokerMapper
   */
  public final void setCustomMapperCustomExchangeBrokerMapper(CustomExchangeBrokerMapper mapper) {
    this.customMapperCustomExchangeBrokerMapper = mapper;
  }


  /**
   * Single constructor
   */
  public ExchangeBrokerMapperSelmaGeneratedClass() {
    this.customMapperCustomExchangeBrokerMapper = new com.sefryek.brokerpro.service.mapper.CustomExchangeBrokerMapper();
  }

}
