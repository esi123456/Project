// GENERATED BY S3LM4
package com.sefryek.brokerpro.service.mapper;


@org.springframework.stereotype.Service("")
public final class BrokerBankAccountsMapperSelmaGeneratedClass
    implements BrokerBankAccountsMapper {

  @Override
  public final java.util.List<com.sefryek.brokerpro.dto.response.mobile.peyment.BrokerBankAccounts> as(java.util.List<com.sefryek.brokerpro.tadbir.dto.response.mobile.payment.BrokerBankAccountTadbir> in) {
    java.util.List<com.sefryek.brokerpro.dto.response.mobile.peyment.BrokerBankAccounts> out = null;
    if (in != null) {
      java.util.ArrayList<com.sefryek.brokerpro.dto.response.mobile.peyment.BrokerBankAccounts> aoutTmpCollection = new java.util.ArrayList<com.sefryek.brokerpro.dto.response.mobile.peyment.BrokerBankAccounts>(in.size());
      for (com.sefryek.brokerpro.tadbir.dto.response.mobile.payment.BrokerBankAccountTadbir aoutItem : in) {
        aoutTmpCollection.add(asBrokerBankAccounts(aoutItem));
      }
      out = aoutTmpCollection;
    }
    return out;
  }

  public final com.sefryek.brokerpro.dto.response.mobile.peyment.BrokerBankAccounts asBrokerBankAccounts(com.sefryek.brokerpro.tadbir.dto.response.mobile.payment.BrokerBankAccountTadbir in) {
    com.sefryek.brokerpro.dto.response.mobile.peyment.BrokerBankAccounts out = null;
    if (in != null) {
      out = new com.sefryek.brokerpro.dto.response.mobile.peyment.BrokerBankAccounts();
      out.setAccountNumber(in.getAccountNumber());
      out.setBankName(in.getBankName());
    }
    return out;
  }



  /**
   * Single constructor
   */
  public BrokerBankAccountsMapperSelmaGeneratedClass() {
  }

}
