package com.sefryek.brokerpro.service.order;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.domain.FinancialProvider;
import com.sefryek.brokerpro.dto.request.Language;
import com.sefryek.brokerpro.dto.request.order.OrderListRequest;
import com.sefryek.brokerpro.dto.request.order.enumeration.ReportType;
import com.sefryek.brokerpro.dto.response.Page;
import com.sefryek.brokerpro.dto.response.Response;
import com.sefryek.brokerpro.dto.response.mobile.order.Order;
import com.sefryek.brokerpro.repository.cache.FinancialCacheRepository;
import com.sefryek.brokerpro.service.AuthStrategy;
import com.sefryek.brokerpro.service.Service;
import com.sefryek.brokerpro.service.mapper.OrderPageMapper;
import com.sefryek.brokerpro.service.mapper.OrdersListEnglishMapper;
import com.sefryek.brokerpro.service.mapper.OrdersListPersianMapper;
import com.sefryek.brokerpro.service.odata.OrFilters;
import com.sefryek.brokerpro.service.odata.UrlBuilder;
import com.sefryek.brokerpro.service.odata.enumeration.Direction;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.service.odata.enumeration.ODataCondition;
import com.sefryek.brokerpro.tadbir.dto.response.mobile.order.OrdersListTadbir;
import com.sefryek.util.CollectionUtils;
import com.sefryek.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.Form;
import java.util.List;

/**
 * Copyright 2016 (C) sefryek.com
 *
 * @author: Amin Malekpour
 * @email: amin.malekpour@hotmail.com
 * @date: 28, Jan, 2017
 */
@Component
public class OrderListService extends Service<OrdersListTadbir> {

    @Autowired
    private OrdersListPersianMapper ordersListPersianMapper;

    @Autowired
    private OrdersListEnglishMapper ordersListEnglishMapper;

    @Autowired
    private OrderPageMapper orderPageMapper;

    @Autowired
    private FinancialCacheRepository financialCacheRepository;

    public OrderListService() {
        super(OrdersListTadbir.class);
    }

    public Response<Page<Order>> findOrderList(OrderListRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getToken());
        UrlBuilder urlBuilder = createUrlBuilder(request);
        OrdersListTadbir responseTadbir = callWebService(HttpMethod.GET, new Form(), urlBuilder, AuthStrategy.USER, request.getToken());
        Response<Page<Order>> result = new Response<>();
        if(ObjectUtils.isNotNull(responseTadbir)){
            if (responseTadbir.isSuccessful()) {
                List<Order> out;
                if (request.getLanguage() != null && Language.ENGLISH.equals(request.getLanguage())) {
                    out = ordersListEnglishMapper.as(responseTadbir.getOrderList());
                    if(CollectionUtils.isNotEmpty(out)){
                        for(int i=0; i<out.size(); i++){
                            FinancialProvider financialProvider = financialCacheRepository.findByBrokerCodeAndFinancialIdAndLanguage(findBrokerCodeByToken(request.getToken()), out.get(i).getFinancialId(), request.getLanguage().getCode());
                            String financialName = Constants.UNKNOWN_EN;
                            if(financialProvider != null){
                                financialName = financialProvider.getName();
                            }
                            out.get(i).setFinancialName(financialName);
                        }
                    }
                } else {
                    out = ordersListPersianMapper.as(responseTadbir.getOrderList());
                    if(CollectionUtils.isNotEmpty(out)){
                        for(int i=0; i<out.size(); i++){
                            FinancialProvider financialProvider = financialCacheRepository.findByBrokerCodeAndFinancialIdAndLanguage(findBrokerCodeByToken(request.getToken()), out.get(i).getFinancialId(), Language.PERSIAN.getCode());
                            String financialName = Constants.UNKNOWN_FA;
                            if(financialProvider != null){
                                financialName = financialProvider.getName();
                            }
                            out.get(i).setFinancialName(financialName);
                        }
                    }
                }

                PageImpl<Order> orderPage = new PageImpl<>(out, new PageRequest(request.getPageable().getPage(), request.getPageable().getSize()), responseTadbir.getTotalRecord());
                Page<Order> page = orderPageMapper.as(orderPage);
                result.setResponse(page);
            }
        } else {
            return createNotSuccessResponse();
        }

       return createResponse(result, responseTadbir.isSuccessful(), responseTadbir.getErrorCode(), responseTadbir.getErrorDescription());
    }

    private UrlBuilder createUrlBuilder(OrderListRequest request) {
        UrlBuilder urlBuilder = new UrlBuilder(createMobileUrl(request.getToken(), Constants.ORDER_URL), ODataAuthStrategy.CUSTOMER_ISIN_ODATA, true, request.getPageable());
        if(request.getReportType() != null){
            OrFilters orFilters = new OrFilters();
            if(ReportType.TRADES.equals(request.getReportType())){
                urlBuilder.addFilter("ExcutedAmount", 0, ODataCondition.GREATER_THAN);
            } else if(ReportType.OPEN_ORDERS.equals(request.getReportType())){
                orFilters.addEqualFilter("OrderState", "TadbirAPIModels.Models.Order.APIOrderState'OnBoard'", true);
                orFilters.addEqualFilter("OrderState", "TadbirAPIModels.Models.Order.APIOrderState'OnSending'", true);
                orFilters.addEqualFilter("OrderState", "TadbirAPIModels.Models.Order.APIOrderState'PartiallyExcution'", true);
                orFilters.addEqualFilter("OrderState", "TadbirAPIModels.Models.Order.APIOrderState'OnCanceling'", true);
                orFilters.addEqualFilter("OrderState", "TadbirAPIModels.Models.Order.APIOrderState'OnCancelError'", true);
                orFilters.addEqualFilter("OrderState", "TadbirAPIModels.Models.Order.APIOrderState'OnModifyError'", true);
                orFilters.addEqualFilter("OrderState", "TadbirAPIModels.Models.Order.APIOrderState'OnModifyBoard'", true);
            }
            if(CollectionUtils.isNotEmpty(orFilters.getOrFilterList())){
                urlBuilder.addOrFilters(orFilters);
            }
        }
        urlBuilder.addOrderBy("OrderEntryDate", Direction.DESC);
        return urlBuilder;
    }

}
