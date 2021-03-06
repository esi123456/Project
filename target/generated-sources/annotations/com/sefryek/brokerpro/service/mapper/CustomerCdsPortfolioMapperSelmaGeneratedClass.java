// GENERATED BY S3LM4
package com.sefryek.brokerpro.service.mapper;


@org.springframework.stereotype.Service("")
public final class CustomerCdsPortfolioMapperSelmaGeneratedClass
    implements CustomerCdsPortfolioMapper {

  @Override
  public final java.util.List<com.sefryek.brokerpro.dto.response.mobile.portfolio.Portfolio> as(java.util.List<com.sefryek.brokerpro.tadbir.dto.response.mobile.portfolio.PortfolioTadbir> in) {
    java.util.List<com.sefryek.brokerpro.dto.response.mobile.portfolio.Portfolio> out = null;
    if (in != null) {
      java.util.ArrayList<com.sefryek.brokerpro.dto.response.mobile.portfolio.Portfolio> aoutTmpCollection = new java.util.ArrayList<com.sefryek.brokerpro.dto.response.mobile.portfolio.Portfolio>(in.size());
      for (com.sefryek.brokerpro.tadbir.dto.response.mobile.portfolio.PortfolioTadbir aoutItem : in) {
        aoutTmpCollection.add(asPortfolio(aoutItem));
      }
      out = aoutTmpCollection;
    }
    return out;
  }

  public final com.sefryek.brokerpro.dto.response.mobile.portfolio.Portfolio asPortfolio(com.sefryek.brokerpro.tadbir.dto.response.mobile.portfolio.PortfolioTadbir in) {
    com.sefryek.brokerpro.dto.response.mobile.portfolio.Portfolio out = null;
    if (in != null) {
      out = new com.sefryek.brokerpro.dto.response.mobile.portfolio.Portfolio();
      out.setCount(in.getCount());
      out.setSymbolISIN(in.getSymbolISIN());
    }
    return out;
  }



  /**
   * Single constructor
   */
  public CustomerCdsPortfolioMapperSelmaGeneratedClass() {
  }

}
