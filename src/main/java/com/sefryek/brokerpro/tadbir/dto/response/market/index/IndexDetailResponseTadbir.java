package com.sefryek.brokerpro.tadbir.dto.response.market.index;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sefryek.brokerpro.tadbir.dto.response.TadbirResponse;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 28, May, 2017
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndexDetailResponseTadbir extends TadbirResponse {
    @JsonProperty("IndexInfo")
    private IndexInfoTadbir indexInfo;

    public IndexInfoTadbir getIndexInfo() {
        return indexInfo;
    }

    public void setIndexInfo(IndexInfoTadbir indexInfo) {
        this.indexInfo = indexInfo;
    }

    @Override
    public String toString() {
        return "IndexDetailResponseTadbir{" +
                "indexInfo=" + indexInfo +
                "} " + super.toString();
    }
}
