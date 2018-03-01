package com.sefryek.brokerpro.tadbir.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Amin on 6/22/2017.
 */
public class TadbirPageableResponse extends TadbirResponse{
    @JsonProperty("TotalRecord")
    private Long totalRecord;

    public Long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Long totalRecord) {
        this.totalRecord = totalRecord;
    }

    @Override
    public String toString() {
        return "TadbirPageableResponse{" +
                "totalRecord=" + totalRecord +
                "} " + super.toString();
    }
}
