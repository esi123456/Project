package com.sefryek.brokerpro.dto.response.market.Index;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 24, Jul, 2017
 */
public class IndexInfo {
    private Map<String, IndexDetail> indexDetailMap  = new HashMap<>();

    public Map<String, IndexDetail> getIndexDetailMap() {
        return indexDetailMap;
    }

    public void setIndexDetailMap(Map<String, IndexDetail> indexDetailMap) {
        this.indexDetailMap = indexDetailMap;
    }

    @Override
    public String toString() {
        return "IndexInfo{" +
                "indexDetailMap=" + indexDetailMap +
                '}';
    }
}
