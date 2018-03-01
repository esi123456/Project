package com.sefryek.brokerpro.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Application constants.
 */
public final class Constants {

    //AOP Log Syntax
    public static final String REQUEST_LOG = "Request:";
    public static final String RESPONSE_LOG = "Response:";
    public static final String ERROR_LOG = "Illegal argument:";

    public static final int STATUS_CODE_200 = 200;
    public static final int STATUS_CODE_401 = 401;
    public static final int STATUS_CODE_403 = 403;
    public static final int STATUS_CODE_404 = 404;
    public static final int STATUS_CODE_500 = 500;

    public static final int MAX_RETRY = 4;
    public static final long MILLISECOND_1000 = new Long(1000);

    public static final String UNKNOWN_EN = "Unknown";
    public static final String UNKNOWN_FA = "نامشخص";

    //OData Queries
    public static final String URL_APPEND = "/";
    public static final String ODATA_STRING_VALUE = "'%s'";
    public static final String ODATA_CUSTOMER_ISIN = "CustomerISIN";
    public static final String ODATA_USER_NAME = "UserName";
    public static final String ODATA_SYMBOL_START = "/?";
    public static final String ODATA_SYMBOL_AND = "&";
    public static final String ODATA_PAGEABLE = "$top=%s&$skip=%s";
    public static final String ODATA_FILTER_START = "$filter=";
    public static final String ODATA_ORDER_BY_START = "$orderby=";
    public static final String ODATA_ORDER_BY_VALUES = "%s+%s";
    public static final String ODATA_FILTER_AND = "+and+";
    public static final String ODATA_FILTER_OR = "+or+";
    public static final String ODATA_FILTER_CONDITION = "%s+%s+%s";
    public static final String ODATA_PARENTHESES_OPEN = "(";
    public static final String ODATA_PARENTHESES_CLOSE = ")";
    public static final String EMPTY_STRING = "";

    public static final String FULL_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DEFAULT_DATE_TADBIR = "0001-01-01";
    public static final String TIME_ZONE_TEHRAN = "Asia/Tehran";

    public static final int VERSION_CODE_ANDROID_FOR_FORCE_UPDATE = 4;
    public static final int VERSION_CODE_ANDROID_FOR_NORMAL_UPDATE = 4;
    public static final int VERSION_CODE_IOS_FOR_FORCE_UPDATE = 3;
    public static final int VERSION_CODE_IOS_FOR_NORMAL_UPDATE = 3;
    public static final String VERSION_UPDATE_LINK_IOS = "https://www.etadbir.com/Default.aspx?tabid=83";
    public static final String VERSION_UPDATE_LINK_ANDROID = "https://play.google.com/store/apps/details?id=com.sefryektadbir.mobiletradingpro";
    public static final String VERSION_DESCRIPTION_FARSI_FOR_FORCE_UPDATE = "\u0644\u0637\u0641\u0627 \u0627\u0632 \u0648\u0631\u0698\u0646 \u062C\u062F\u06CC\u062F \u0646\u0631\u0645 \u0627\u0641\u0632\u0627\u0631 \u0627\u0633\u062A\u0641\u0627\u062F\u0647 \u06A9\u0646\u06CC\u062F.";
    public static final String VERSION_DESCRIPTION_ENGLISH_FOR_FORCE_UPDATE = "Please upgrade your software.";
    public static final String VERSION_DESCRIPTION_FARSI_FOR_NORMAL_UPDATE = "\u0644\u0637\u0641\u0627 \u0627\u0632 \u0648\u0631\u0698\u0646 \u062C\u062F\u06CC\u062F \u0646\u0631\u0645 \u0627\u0641\u0632\u0627\u0631 \u0627\u0633\u062A\u0641\u0627\u062F\u0647 \u06A9\u0646\u06CC\u062F.";
    public static final String VERSION_DESCRIPTION_ENGLISH_FOR_NORMAL_UPDATE = "Please upgrade your software.";

    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";
    public static final String SPRING_PROFILE_PRODUCTION = "prod";
    public static final String SPRING_PROFILE_TEST = "test";
    public static final String SPRING_PROFILE_FAST = "fast";
    // Spring profile used to disable swagger
    public static final String SPRING_PROFILE_SWAGGER = "swagger";
    public static final String SYSTEM_ACCOUNT = "system";
    public static final String ROLE = "system";
    public static final String APPLICATION_JSON = "application/json;charset=utf-8";
    public static final String X_TADBIR_AUTH = "Authorization";
    public static final String AUTHENTICATION_TOKEN_HEADER_KEY = "x-auth-token";
    public static final String ISO_8601 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String LANGUAGE_REQUEST_HEADER_KEY = "language";
    public static final List<String> VALID_LANGUAGES = new ArrayList<>(Arrays.asList("fa", "en"));
    public static final String VALUE_REGEX = "[_'.@A-Za-z0-9-]+";
    public static final String BROKER_PRO_ID_GENERATOR = "BROKER_PRO_ID_GENERATOR";
    public static final String LOGIN_GATEWAY_TOKEN_BASIC = "Basic %s";

    public static final String BEST_OF_MARKET_URL = "market.best.url";

    //LS Constants
    public static final String ADAPTERNAME = "STOCKLISTDEMO_REMOTE";
//    public static final String ADAPTERNAME = "TadbirLightPrivateGatewayAdapter";
//    public static final String TADBIR_LS_REQUEST_FORMAT = "%s$%s";
    public static final String TADBIR_LS_REQUEST_FORMAT = "$";
    public static final String TADBIR_LS_SYSTEM_ITEM = "_SystemMessage";
    /////
    public static final String PUSHSERVERHOST = "push3.mofidonline.com";
    public static final String ADAPTER = "STOCKLISTDEMO_REMOTE";
    public static final String USER = "SOHEILKH";
    public static final String FINISH = "Finish";
    public static final String EXIT = "Exit";
    public static final String SCHEMANAME = "cache";
    public static final String GROUPNAME = "groupstate_lightrlc";
    public static final String MOD = "RAW";
    public static final boolean SNAP = false;
    public static final String DATAADAPTER = "TadbirLightPrivateGatewayAdapter";

    //New Market API
    public static final String MARKET_URL = "market.url";
    public static final String SYMBOL_QUEUE_URL = "market.symbol.queue.url";
    public static final String BROKERS_URL = "brokers.url";
    public static final String MARKET_SYMBOL_URL = "market.symbol.url";
    public static final String NATURAL_LEGAL_URL = "market.legal.url";
    public static final String SYMBOL_HISTORY_DATA_URL = "market.symbol.history.data.url";
    public static final String INDEX_HISTORY_DATA_URL = "market.index.history.data.url";
    public static final String LIST_OF_MESSAGES_URL = "market.message.list.url";
    public static final String MAIN_LAST_INFO_INDEX_URL = "market.main.last.info.index.url";
    public static final String MARKET_ACTIVITY_URL = "market.activity.url";
    public static final String MARKET_WATCH_URL = "market.watch.url";

    //Old Mobile AOI
    public static final String CONDITIONAL_ALERT_LIST_URL = "mobile.conditional.alert.list.url";
    public static final String ADD_CONDITIONAL_ALERT_URL = "mobile.conditional.alert.add.url";
    public static final String DELETE_CONDITIONAL_ALERT_URL = "mobile.conditional.alert.delete.url";
    public static final String CONDITIONAL_ALERT_CONDITIONS_URL = "mobile.conditional.alert.conditions.url";

    //New Mobile API
    public static final String GATEWAY_LOGIN_URL = "mobile.gateway.login.url";
    public static final String CONTACT_US_URL = "mobile.contact.us.url";
    public static final String DAILY_CUSTOMER_STOCK_PORTFOLIO_URL = "mobile.customer.stock.portfolio.url";
    public static final String CATEGORY_OF_WATCH_LIST_URL = "mobile.category.watch.list.url";
    public static final String MEMBER_LIST_OF_WATCH_LIST_CATEGORY_URL = "mobile.member.watch.list.url";
    public static final String MONEY_TRANSFER_GATEWAYS_URL = "mobile.money.transfer.gateways.url";
    public static final String CUSTOMER_CDS_PORTFOLIO_URL = "mobile.customer.cds.portfolio.url";
    public static final String REAL_TIME_PORTFOLIO_LIST_URL = "mobile.real.portfolio.list.url";
    public static final String COMMISSION_DETAIL_URL = "mobile.commission.detail.url";
    public static final String FINANCIAL_PROVIDERS_URL = "mobile.financial.provider.url";
    public static final String WITHDRAWAL_URL = "mobile.money.payment.list.url";
    public static final String MOBILE_CUSTOMER_URL = "mobile.customer.url";
    public static final String BROKER_BANK_ACCOUNTS_URL = "mobile.broker.bank.accounts.url";
    public static final String CHANGE_BROKER_URL = "mobile.get.change.broker.url";
    public static final String DEPOSIT_URL = "mobile.money.receipt.list.url";
    public static final String ORDER_URL = "mobile.order.url";
    public static final String ORDER_DETAIL_URL = "mobile.order.detail.url";
    public static final String REMAIN_URL = "mobile.remain.url";
    public static final String MESSAGES_URL = "mobile.messages.url";
    public static final String INSTANT_DEPOSIT_URL = "mobile.instant.deposit.status.url";
    public static final String TRANSACTION_ARCHIVE_URL = "mobile.transaction.archive.url";
    public static final String TIME_URL = "mobile.time.url";
    public static final String MOBILE_SYMBOL_URL = "mobile.symbol.url";
    public static final String CUSTOMER_DEVICE_URL = "mobile.customer.device.url";

    private Constants() {
    }

}
