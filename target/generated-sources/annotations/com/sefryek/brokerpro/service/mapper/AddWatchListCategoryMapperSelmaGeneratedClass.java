// GENERATED BY S3LM4
package com.sefryek.brokerpro.service.mapper;


@org.springframework.stereotype.Service("")
public final class AddWatchListCategoryMapperSelmaGeneratedClass
    implements AddWatchListCategoryMapper {

  @Override
  public final com.sefryek.brokerpro.dto.response.mobile.watchlist.AddWatchListCategory as(com.sefryek.brokerpro.tadbir.dto.response.mobile.watchlist.AddWatchListCategoryTadbir in) {
    com.sefryek.brokerpro.dto.response.mobile.watchlist.AddWatchListCategory out = null;
    if (in != null) {
      out = new com.sefryek.brokerpro.dto.response.mobile.watchlist.AddWatchListCategory();
      out.setCategoryId(in.getCategoryId());
    }
    return out;
  }



  /**
   * Single constructor
   */
  public AddWatchListCategoryMapperSelmaGeneratedClass() {
  }

}
