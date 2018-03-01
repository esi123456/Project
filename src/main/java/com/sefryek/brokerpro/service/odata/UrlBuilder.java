package com.sefryek.brokerpro.service.odata;

import com.sefryek.brokerpro.config.Constants;
import com.sefryek.brokerpro.dto.request.Pageable;
import com.sefryek.brokerpro.service.odata.enumeration.ODataAuthStrategy;
import com.sefryek.brokerpro.service.odata.enumeration.Direction;
import com.sefryek.brokerpro.service.odata.enumeration.ODataCondition;
import com.sefryek.util.DatePattern;
import com.sefryek.util.DateUtils;
import com.sefryek.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * Created by Amin on 6/22/2017.
 */
public class UrlBuilder {
    private String mainUrl;
    private ODataAuthStrategy ODataAuthStrategy;
    private List<String> urlParams = new ArrayList<>();
    private Pageable pageable;
    private boolean isPageable;
    private List<ODataFilter> oDataFilters = new ArrayList<>();
    private List<OrFilters> orFilters = new ArrayList<>();
    private Map<String, Direction> orderBy = new HashMap<>();
    private String customerISIN;
    private String userName;

    /**
     * Use this Constructor when:
     *    1- don't need to send UserName or CustomerISIN in OData filter or URL.
     *    2- Pageable doesn't support.
     */
    public UrlBuilder(@NotNull String mainUrl) {
        this.mainUrl = mainUrl;
        this.ODataAuthStrategy = ODataAuthStrategy.NONE;
    }

    /**
     * Use this Constructor when:
     *    1- need to send UserName or CustomerISIN in OData filter or URL.
     *    2- Pageable doesn't support.
     */
    public UrlBuilder(@NotNull String mainUrl, @NotNull ODataAuthStrategy ODataAuthStrategy) {
        this.mainUrl = mainUrl;
        this.ODataAuthStrategy = ODataAuthStrategy;
    }

    /**
     * Use this Constructor when:
     *    1- don't need to send UserName or CustomerISIN in OData filter or URL.
     *    2- Pageable supports.
     */
    public UrlBuilder(@NotNull String mainUrl, boolean isPageable, @NotNull Pageable pageable) {
        this.mainUrl = mainUrl;
        this.ODataAuthStrategy = ODataAuthStrategy.NONE;
        this.isPageable = isPageable;
        this.pageable = pageable;
    }

    /**
     * Use this Constructor when:
     *    1- need to send UserName or CustomerISIN in OData filter or URL.
     *    2- Pageable supports.
     */
    public UrlBuilder(@NotNull String mainUrl, @NotNull ODataAuthStrategy ODataAuthStrategy, boolean isPageable, @NotNull Pageable pageable) {
        this.mainUrl = mainUrl;
        this.ODataAuthStrategy = ODataAuthStrategy;
        this.isPageable = isPageable;
        this.pageable = pageable;
    }

    public ODataAuthStrategy getODataAuthStrategy() {
        return this.ODataAuthStrategy;
    }

    /**
     * Set CustomerISIN in last step (Service.java).
     */
    public void setCustomerISIN(String customerISIN) {
        this.customerISIN = customerISIN;
    }

    /**
     * Set UserName in last step (Service.java).
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Build URL in last step (Service.java).
     */
    public String build() {
        validateData();
        StringBuilder result = new StringBuilder(this.mainUrl);
        result.append(userStrategyProvider());
        result.append(urlParamProvider());
        //If OData is available
        if (this.isPageable || this.oDataFilters.size() > 0 || this.orFilters.size() > 0 || orderBy.size()>0) {
            result.append(Constants.ODATA_SYMBOL_START);
            if (this.isPageable) {
                result.append(oDataPageableProvider());
            }
            if (this.oDataFilters.size() > 0 || this.orFilters.size() > 0) {
                result.append(oDataFilterProvider());
            }
            if(orderBy.size()>0){
                if(this.isPageable || this.oDataFilters.size() > 0 || this.orFilters.size() > 0){
                    result.append(Constants.ODATA_SYMBOL_AND);
                }
                result.append(Constants.ODATA_ORDER_BY_START);
                Iterator<Map.Entry<String, Direction>> it = orderBy.entrySet().iterator();
                int i = 0;
                while (it.hasNext()){
                    Map.Entry<String, Direction> order = it.next();
                    result.append(String.format(Constants.ODATA_ORDER_BY_VALUES, order.getKey(), order.getValue().getValue()));
                    i++;
                    if(i<(orderBy.size())){
                        result.append(Constants.ODATA_FILTER_AND);
                    }
                }
            }
        }
        return result.toString();
    }

    private void validateData() {
        if (StringUtils.isEmpty(this.mainUrl)) {
            //throw exception
        }
        if (this.ODataAuthStrategy == null) {
            //throw exception
        }
        if (ODataAuthStrategy.CUSTOMER_ISIN_ODATA.equals(this.ODataAuthStrategy) || ODataAuthStrategy.CUSTOMER_ISIN_URL.equals(this.ODataAuthStrategy)) {
            //throw exception
        } else if (ODataAuthStrategy.USER_NAME_ODATA.equals(this.ODataAuthStrategy) || ODataAuthStrategy.USER_NAME_URL.equals(this.ODataAuthStrategy)) {
            //throw exception
        }
        this.urlParams.forEach(urlParam -> {
            if (StringUtils.isEmpty(urlParam)) {
                //throw exception
            }
        });
        this.oDataFilters.forEach(oDataFilter -> {
            if (StringUtils.isEmpty(oDataFilter.getFilterName()) || StringUtils.isEmpty(oDataFilter.getFilterValue())) {
                //throw exception
            }
        });
    }

    private StringBuilder userStrategyProvider() {
        StringBuilder result = new StringBuilder();
        if (ODataAuthStrategy.CUSTOMER_ISIN_URL.equals(this.ODataAuthStrategy)) {
            result.append(Constants.URL_APPEND);
            result.append(this.customerISIN);
        } else if (ODataAuthStrategy.USER_NAME_URL.equals(this.ODataAuthStrategy)) {
            result.append(Constants.URL_APPEND);
            result.append(this.userName);
        } else if (ODataAuthStrategy.CUSTOMER_ISIN_ODATA.equals(this.ODataAuthStrategy)) {
            addEqualFilter(Constants.ODATA_CUSTOMER_ISIN, this.customerISIN);
        } else if (ODataAuthStrategy.USER_NAME_ODATA.equals(this.ODataAuthStrategy)) {
            addEqualFilter(Constants.ODATA_USER_NAME, this.userName);
        }
        return result;
    }

    private String urlParamProvider() {
        StringBuilder result = new StringBuilder();
        this.urlParams.forEach(urlParam -> {
            result.append(Constants.URL_APPEND);
            result.append(urlParam);
        });
        return result.toString();
    }

    private String oDataPageableProvider() {
        StringBuilder result = new StringBuilder();
        result.append(String.format(Constants.ODATA_PAGEABLE, this.pageable.getSize(), this.pageable.getPage()));
        if (this.oDataFilters.size() > 0) {
            result.append(Constants.ODATA_SYMBOL_AND);
        }
        return result.toString();
    }

    private String oDataFilterProvider() {
        StringBuilder result = new StringBuilder();
        List<String> filterList = new ArrayList<>();

        if(this.oDataFilters.size() > 0){
            filterList = convertFiltersToStringList(this.oDataFilters);
        }

        if(this.orFilters.size() > 0){
            for (OrFilters orFilters : this.orFilters){
                filterList.add(createOrFilters(orFilters));
            }
        }

        if(filterList.size() > 0){
            result.append(Constants.ODATA_FILTER_START);
            for (int i = 0; i < (filterList.size() - 1); i++) {
                String filter = filterList.get(i);
                result.append(filter);
                result.append(Constants.ODATA_FILTER_AND);
            }
            String lastFilter = filterList.get(filterList.size() - 1);
            result.append(lastFilter);
        }

        return result.toString();
    }

    private String createOrFilters(OrFilters orFilters) {
        StringBuilder result = new StringBuilder();
        List<String> filterList = new ArrayList<>();
        if(orFilters.getOrFilterList().size() > 0){
            filterList = convertFiltersToStringList(orFilters.orFilterList);
            result.append(Constants.ODATA_PARENTHESES_OPEN);
            for (int i = 0; i < (filterList.size() - 1); i++) {
                String filter = filterList.get(i);
                result.append(filter);
                result.append(Constants.ODATA_FILTER_OR);
            }
            String lastOrFilter = filterList.get(filterList.size() - 1);
            result.append(lastOrFilter);
            result.append(Constants.ODATA_PARENTHESES_CLOSE);
        }

        return result.toString();
    }

    private List<String> convertFiltersToStringList(List<ODataFilter> oDataFilterList){
        List<String> result = new ArrayList<>();
        for(ODataFilter oDataFilter : oDataFilterList){
            if(oDataFilter.getFilterName() != null && oDataFilter.getFilterValue() != null && oDataFilter.getFilterCondition() != null){
                result.add(String.format(Constants.ODATA_FILTER_CONDITION, oDataFilter.getFilterName(), oDataFilter.getFilterCondition().getValue(),oDataFilter.getFilterValue()));
            } else if(oDataFilter.getFilterQuery() != null){
                result.add(oDataFilter.getFilterQuery());
            }
        }
        return result;
    }

    /**
     * These methods are for append a String in URL.
     * e.g. you want to call this URL: http://mobilerestapi.mofidonline.com/api/RealtimePortfolio
     * Result of this method is: /RealtimePortfolio
     */
    public void appendUrl(@NotNull String param) {
        this.urlParams.add(param);
    }

    public void appendUrl(boolean param) {
        this.urlParams.add(String.valueOf(param));
    }

    public void appendUrl(@NotNull Boolean param) {
        this.urlParams.add(String.valueOf(param));
    }

    public void appendUrl(short param) {
        this.urlParams.add(String.valueOf(param));
    }

    public void appendUrl(int param) {
        this.urlParams.add(String.valueOf(param));
    }

    public void appendUrl(long param) {
        this.urlParams.add(String.valueOf(param));
    }

    public void appendUrl(float param) {
        this.urlParams.add(String.valueOf(param));
    }

    public void appendUrl(double param) {
        this.urlParams.add(String.valueOf(param));
    }

    public void appendUrl(@NotNull Number param) {
        this.urlParams.add(String.valueOf(param));
    }

    /**
     * These methods are for adding filter inside OData Filter with optional conditions(See: ODataCondition).
     * e.g. you want to send this filter: filter = MarketCode eq 'NO' and TradeDate gt 2017-07-23
     * Result of this method is: filter=MarketCode+eq'NO'+and+TradeDate+gt+2017-07-23
     *
     * Attention: When you want to send Enum in OData Filter you maybe use '' or not (MarketCode eq 'NO' || MarketCode eq NO) ,
     * So we provide two different methods for adding String value.
     */
    public void addFilter(@NotNull String name, @NotNull String value, @NotNull ODataCondition condition, boolean isWithoutSingleQuotation) {
        ODataFilter oDataFilter = null;
        if(isWithoutSingleQuotation){
            oDataFilter = new ODataFilter(name, value, condition);
        } else {
            oDataFilter = new ODataFilter(name, String.format(Constants.ODATA_STRING_VALUE, value), condition);
        }
        this.oDataFilters.add(oDataFilter);
    }

    public void addFilter(@NotNull String name, @NotNull String value, @NotNull ODataCondition condition) {
        addFilter(name, value, condition,false);
    }

    public void addFilter(@NotNull String name, boolean value, @NotNull ODataCondition condition) {
        ODataFilter oDataFilter = new ODataFilter(name, String.valueOf(value), condition);
        this.oDataFilters.add(oDataFilter);
    }

    public void addFilter(@NotNull String name, @NotNull Boolean value, @NotNull ODataCondition condition) {
        ODataFilter oDataFilter = new ODataFilter(name, String.valueOf(value), condition);
        this.oDataFilters.add(oDataFilter);
    }

    public void addFilter(@NotNull String name, short value, @NotNull ODataCondition condition) {
        ODataFilter oDataFilter = new ODataFilter(name, String.valueOf(value), condition);
        this.oDataFilters.add(oDataFilter);
    }

    public void addFilter(@NotNull String name, int value, @NotNull ODataCondition condition) {
        ODataFilter oDataFilter = new ODataFilter(name, String.valueOf(value), condition);
        this.oDataFilters.add(oDataFilter);
    }

    public void addFilter(@NotNull String name, long value, @NotNull ODataCondition condition) {
        ODataFilter oDataFilter = new ODataFilter(name, String.valueOf(value), condition);
        this.oDataFilters.add(oDataFilter);
    }

    public void addFilter(@NotNull String name, float value, @NotNull ODataCondition condition) {
        ODataFilter oDataFilter = new ODataFilter(name, String.valueOf(value), condition);
        this.oDataFilters.add(oDataFilter);
    }

    public void addFilter(@NotNull String name, double value, @NotNull ODataCondition condition) {
        ODataFilter oDataFilter = new ODataFilter(name, String.valueOf(value), condition);
        this.oDataFilters.add(oDataFilter);
    }

    public void addFilter(@NotNull String name, @NotNull Number value, @NotNull ODataCondition condition) {
        ODataFilter oDataFilter = new ODataFilter(name, String.valueOf(value), condition);
        this.oDataFilters.add(oDataFilter);
    }

    public void addFilter(@NotNull String name, @NotNull Date value, @NotNull ODataCondition condition) {
        ODataFilter oDataFilter = new ODataFilter(name, convertDateToStringByHyphen(value), condition);
        this.oDataFilters.add(oDataFilter);
    }

    /**
     * These methods just are for adding EQUAL filter inside OData Filter.
     * e.g. you want to send this filter: filter = MarketCode eq 'NO'
     * Result of this method is: filter=MarketCode+eq'NO'
     *
     * Attention: When you want to send Enum in OData Filter you maybe use '' or not (MarketCode eq 'NO' || MarketCode eq NO) ,
     * So we provide two different methods for adding String value.
     */
    public void addEqualFilter(@NotNull String name, @NotNull String value, boolean isEnum) {
        addFilter(name, value, ODataCondition.EQUAL, isEnum);
    }

    public void addEqualFilter(@NotNull String name, @NotNull String value) {
        addFilter(name, value, ODataCondition.EQUAL);
    }

    public void addEqualFilter(@NotNull String name, boolean value) {
        addFilter(name, value, ODataCondition.EQUAL);
    }

    public void addEqualFilter(@NotNull String name, @NotNull Boolean value) {
        addFilter(name, value, ODataCondition.EQUAL);
    }

    public void addEqualFilter(@NotNull String name, short value) {
        addFilter(name, value, ODataCondition.EQUAL);
    }

    public void addEqualFilter(@NotNull String name, int value) {
        addFilter(name, value, ODataCondition.EQUAL);
    }

    public void addEqualFilter(@NotNull String name, long value) {
        addFilter(name, value, ODataCondition.EQUAL);
    }

    public void addEqualFilter(@NotNull String name, float value) {
        addFilter(name, value, ODataCondition.EQUAL);
    }

    public void addEqualFilter(@NotNull String name, double value) {
        addFilter(name, value, ODataCondition.EQUAL);
    }

    public void addEqualFilter(@NotNull String name, @NotNull Number value) {
        addFilter(name, value, ODataCondition.EQUAL);
    }

    public void addEqualFilter(@NotNull String name, @NotNull Date value) {
        addFilter(name, value, ODataCondition.EQUAL);
    }

    /**
     * This method is for adding manual query (optional query) inside OData Filter.
     * e.g. you want to send this filter: filter = MarketCode eq 'NO' and startswith(SymbolISIN, 'IRO1')
     * Result of this method is: startswith(SymbolISIN, 'IRO1')
     */
    public void addFilterQuery(@NotNull String filterQuery){
        ODataFilter oDataFilter = new ODataFilter(filterQuery);
        this.oDataFilters.add(oDataFilter);
    }

    /**
    * This method is for adding 'OR' conditions inside OData Filter.
    * e.g. you want to send this filter: filter = (SymbolISIN eq 'IRO1LAPS0001' or SymbolISIN eq 'IRO1BALB0001') and MarketCode eq 'NO'
    * Result of this method is: (SymbolISIN+eq+'IRO1LAPS0001'+or+SymbolISIN+eq+'IRO1BALB0001')
    */
    public void addOrFilters(OrFilters orFilters) {
        this.orFilters.add(orFilters);
    }

    /**
     * This method is for adding OrderBy in filter, when you want to sorting result by a parameter.
     * e.g. You want to send this filter: filter = (SymbolISIN eq 'IRO1LAPS0001' or SymbolISIN eq 'IRO1BALB0001') and MarketCode eq 'NO' &$orderby = PriceVar desc
     * Result of this method is: &$orderb+=+PriceVar+desc
     */
    public void addOrderBy(String orderBy, Direction direction){
        this.orderBy.put(orderBy, direction);
    }

    /**
     * This method is for converting date to string by this format yyyy-MM-dd
     * Result of this method is: yyyy-MM-dd
     */
    private String convertDateToStringByHyphen(Date date) {
        return DateUtils.convertDateToString(date, DatePattern.DATE_BY_HYPHEN_PATTERN);
    }
}
