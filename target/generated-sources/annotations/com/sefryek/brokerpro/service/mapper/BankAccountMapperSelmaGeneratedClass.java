// GENERATED BY S3LM4
package com.sefryek.brokerpro.service.mapper;


@org.springframework.stereotype.Service("")
public final class BankAccountMapperSelmaGeneratedClass
    implements BankAccountMapper {

  @Override
  public final com.sefryek.brokerpro.dto.response.mobile.peyment.BankAccount as(com.sefryek.brokerpro.tadbir.dto.response.mobile.payment.BankAccountTadbir in) {
    com.sefryek.brokerpro.dto.response.mobile.peyment.BankAccount out = null;
    if (in != null) {
      out = new com.sefryek.brokerpro.dto.response.mobile.peyment.BankAccount();
      out.setBankAccountId(in.getBankAccountId());
      out.setDescription(in.getDescription());
    }
    return out;
  }



  /**
   * Single constructor
   */
  public BankAccountMapperSelmaGeneratedClass() {
  }

}