// GENERATED BY S3LM4
package com.sefryek.brokerpro.service.mapper;


@org.springframework.stereotype.Service("")
public final class CustomerDeviceMapperSelmaGeneratedClass
    implements CustomerDeviceMapper {

  @Override
  public final com.sefryek.brokerpro.dto.response.mobile.CustomerDevice as(com.sefryek.brokerpro.tadbir.dto.response.mobile.customer.CustomerDeviceTadbir in) {
    com.sefryek.brokerpro.dto.response.mobile.CustomerDevice out = null;
    if (in != null) {
      out = new com.sefryek.brokerpro.dto.response.mobile.CustomerDevice();
      out.setAppVersion(in.getAppVersion());
      if (in.getDateTime() != null) {
        out.setDateTime(new java.util.Date(in.getDateTime().getTime()));
      }
      else {
        out.setDateTime(null);
      }
      out.setDeviceIp(in.getDeviceIp());
      out.setDeviceModel(in.getDeviceModel());
      out.setDeviceOS(in.getDeviceOS());
      out.setiMEI(in.getiMEI());
      out.setLatitude(in.getLatitude());
      out.setLongitude(in.getLongitude());
      out.setRoot(in.getRoot());
      out.setUserName(in.getUserName());
    }
    return out;
  }



  /**
   * Single constructor
   */
  public CustomerDeviceMapperSelmaGeneratedClass() {
  }

}
