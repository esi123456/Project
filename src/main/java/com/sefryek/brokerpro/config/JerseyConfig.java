package com.sefryek.brokerpro.config;

import com.sefryek.brokerpro.config.jackson.JacksonConfiguration;
import com.sefryek.brokerpro.config.jackson.MyJacksonFeature;
import com.sefryek.brokerpro.config.validation.ValidationConfigurationContextResolver;
import com.sefryek.brokerpro.exception.BrokerProExceptionMapper;
import com.sefryek.brokerpro.exception.ConstraintViolationExceptionMapper;
import com.sefryek.brokerpro.exception.ExceptionMapper;
import com.sefryek.brokerpro.web.rest.*;
import com.sefryek.brokerpro.web.rest.commission.CommissionEndpoint;
import com.sefryek.brokerpro.web.rest.customerdevice.AddCustomerDeviceEndpoint;
import com.sefryek.brokerpro.web.rest.exchange.ExchangeCompanyEndpoint;
import com.sefryek.brokerpro.web.rest.gateway.OnlineUsersEndpoint;
import com.sefryek.brokerpro.web.rest.index.IndexDetailEndpoint;
import com.sefryek.brokerpro.web.rest.index.IndexHistoryDataEndpoint;
import com.sefryek.brokerpro.web.rest.market.MarketWatchEndpoint;
import com.sefryek.brokerpro.web.rest.mobile.broker.ChangeBrokerEndpoint;
import com.sefryek.brokerpro.web.rest.mobile.contact.ContactUsEndpoint;
import com.sefryek.brokerpro.web.rest.mobile.exchanges.ExchangeBrokerEndpoint;
import com.sefryek.brokerpro.web.rest.mobile.order.OrderDetailEndpoint;
import com.sefryek.brokerpro.web.rest.mobile.payment.*;
import com.sefryek.brokerpro.web.rest.order.AddOrderEndpoint;
import com.sefryek.brokerpro.web.rest.order.AddOrdersEndpoint;
import com.sefryek.brokerpro.web.rest.order.CancelOrderEndpoint;
import com.sefryek.brokerpro.web.rest.order.ModifyOrderEndpoint;
import com.sefryek.brokerpro.web.rest.portfolio.RowDetailsRealTimePortfolioEndpoint;
import com.sefryek.brokerpro.web.rest.portfolio.stock.DailyCustomerStockPortfolioEndpoint;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.validation.internal.InjectingConstraintValidatorFactory;

import java.util.ArrayList;
import java.util.List;

public class JerseyConfig {
    public static final List<Class> ENDPOINTS = createEndpoints();

    private static List<Class> createEndpoints() {
        ArrayList<Class> classes = new ArrayList<>();
        classes.add(ValidationConfigurationContextResolver.class);
        classes.add(ConstraintViolationExceptionMapper.class);
        classes.add(BrokerProExceptionMapper.class);
        classes.add(ExceptionMapper.class);
        classes.add(InjectingConstraintValidatorFactory.class);

//        classes.add(WadlResource.class);
        classes.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        classes.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        classes.add(LoginEndpoint.class);
        classes.add(BrokerEndpoint.class);
        classes.add(SymbolQueueEndpoint.class);
        classes.add(RemainEndpoint.class);
        classes.add(MarketActivityEndpoint.class);
        classes.add(SymbolPriceWithFirstQueueEndpoint.class);
        classes.add(CustomerCdsPortfolioEndpoint.class);
        classes.add(CustomerCdsPortfolioWithDetailEndpoint.class);
        classes.add(AddCustomerDeviceEndpoint.class);
        classes.add(CustomerDeviceEndpoint.class);
        classes.add(ExchangeCompanyEndpoint.class);
        classes.add(SymbolHistoryDataEndpoint.class);
        classes.add(ListOfMessagesEndpoint.class);
        classes.add(OrderListEndpoint.class);
        classes.add(FinancialProvidersEndpoint.class);
        classes.add(AddOrderEndpoint.class);
        classes.add(ModifyOrderEndpoint.class);
        classes.add(CancelOrderEndpoint.class);
        classes.add(CommissionEndpoint.class);
        classes.add(MarketTimeEndpoint.class);
        classes.add(NaturalLegalEndpoint.class);
        classes.add(HealthCheckEndpoint.class);
        classes.add(CategoryOfWatchListEndpoint.class);
        classes.add(BestOfMarketWithFirstQueueEndpoint.class);
        classes.add(AddWatchListCategoryEndpoint.class);
        classes.add(DeleteWatchListCategoryEndpoint.class);
        classes.add(EditWatchListCategoryEndpoint.class);
        classes.add(MemberListOfWatchListCategoryEndpoint.class);
        classes.add(AddMemberToWatchListCategoryEndpoint.class);
        classes.add(DeleteMemberOfWatchListCategoryEndpoint.class);
        classes.add(MessageByIdEndpoint.class);
        classes.add(SymbolPriceListWithFirstQueueEndpoint.class);
        classes.add(MessagesEndpoint.class);
        classes.add(AddOrdersEndpoint.class);
        classes.add(DailyCustomerStockPortfolioEndpoint.class);
        classes.add(MessageReadFlagEndpoint.class);
        classes.add(RealTimePortfolioListEndpoint.class);
        classes.add(RowDetailsRealTimePortfolioEndpoint.class);
        classes.add(AddRowToRealTimePortfolioEndpoint.class);
        classes.add(DeleteRowFromRealTimePortfolioEndpoint.class);
        classes.add(CheckVersionCodeEndpoint.class);
        classes.add(InstantDepositGatewaysEndpoint.class);
        classes.add(WithdrawalListEndpoint.class);
        classes.add(WithdrawalDetailEndpoint.class);
        classes.add(AddWithdrawalEndpoint.class);
        classes.add(DeleteWithdrawalEndpoint.class);
        classes.add(DeleteDepositEndpoint.class);
        classes.add(AddDepositEndpoint.class);
        classes.add(InstantDepositStatusEndpoint.class);
        classes.add(InstantDepositTokenEndpoint.class);
        classes.add(DepositListEndpoint.class);
        classes.add(BrokerBankAccountsEndpoint.class);
        classes.add(IndexDetailEndpoint.class);
        classes.add(IndexHistoryDataEndpoint.class);
        classes.add(ChangeBrokerEndpoint.class);
        classes.add(TransactionArchiveEndpoint.class);
        classes.add(MarketWatchEndpoint.class);
        classes.add(ContactUsEndpoint.class);
        classes.add(DepositReasonEndpoint.class);
        classes.add(OrderDetailEndpoint.class);
        classes.add(ExchangeBrokerEndpoint.class);
        classes.add(OnlineUsersEndpoint.class);

        //TODO Tadbir must complete these services
//        classes.add(ConditionalAlertListEndpoint.class);
//        classes.add(AddConditionalAlertEndpoint.class);
//        classes.add(DeleteConditionalAlertEndpoint.class);
//        classes.add(ConditionalAlertConditionsEndpoint.class);
//        classes.add(SymbolPriceEndpoint.class);
//        classes.add(BestOfMarketEndpoint.class);


        classes.add(JacksonConfiguration.class);
        classes.add(MyJacksonFeature.class);
        classes.add(MultiPartFeature.class);
        return classes;
    }

}