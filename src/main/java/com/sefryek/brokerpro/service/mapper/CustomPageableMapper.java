package com.sefryek.brokerpro.service.mapper;
/*
 * Copyright 2016 (C) syspod.co
 * 
 * Author     : Ashkan Haghighi Kia
 * Email      : kia@syspod.co
 */

import com.sefryek.brokerpro.dto.SortDirection;
import com.sefryek.brokerpro.dto.request.Pageable;
import com.sefryek.brokerpro.dto.request.Request;
import com.sefryek.util.ObjectUtils;
import com.sefryek.util.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class CustomPageableMapper implements SelmaObjectMapper<Request, PageRequest> {
    @Override
    public PageRequest as(Request in) {
        if (ObjectUtils.isNotNull(in) && ObjectUtils.isNotNull(in.getPageable())) {
            Pageable pageable = in.getPageable();
            if (ObjectUtils.isNotNull(pageable.getSort()) && StringUtils.isNotEmpty(pageable.getSort().getForField())) {
                Sort.Direction direction = Sort.Direction.valueOf((pageable.getSort().getDirection() == null ? SortDirection.ASC : pageable.getSort().getDirection()).toString());
                Sort sort = new Sort(direction, pageable.getSort().getForField());
                return new PageRequest(pageable.getPage(), pageable.getSize(), sort);
            }
            return new PageRequest(pageable.getPage(), pageable.getSize());
        }
        return null;
    }
}