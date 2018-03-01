package com.sefryek.brokerpro.service.odata;

import com.sefryek.brokerpro.service.odata.enumeration.ODataCondition;

/**
 * Created by Amin on 6/22/2017.
 */
public class ODataFilter {
    private String filterName;
    private String filterValue;
    private ODataCondition filterCondition;
    private String filterQuery;

    public ODataFilter(String filterName, String filterValue, ODataCondition filterCondition) {
        this.filterName = filterName;
        this.filterValue = filterValue;
        this.filterCondition = filterCondition;
    }

    public ODataFilter(String filterQuery) {
        this.filterQuery = filterQuery;
    }

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }

    public ODataCondition getFilterCondition() {
        return filterCondition;
    }

    public void setFilterCondition(ODataCondition filterCondition) {
        this.filterCondition = filterCondition;
    }

    public String getFilterQuery() {
        return filterQuery;
    }

    public void setFilterQuery(String filterQuery) {
        this.filterQuery = filterQuery;
    }

    @Override
    public String toString() {
        return "ODataFilter{" +
                "filterName='" + filterName + '\'' +
                ", filterValue='" + filterValue + '\'' +
                ", filterCondition=" + filterCondition +
                ", filterQuery='" + filterQuery + '\'' +
                '}';
    }
}
