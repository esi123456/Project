package com.sefryek.brokerpro.service.odata.enumeration;

/**
 * Created by Amin on 6/22/2017.
 *
 *      NONE:                 customerISIN or userName don't need to send to Tadbir's Service in URL or OData Filter.
 *      CUSTOMER_ISIN_URL:    customerISIN must be send in URL.
 *      USER_NAME_URL:        userName must be send in URL.
 *      CUSTOMER_ISIN_ODATA:  customerISIN must be send in OData Filter.
 *      USER_NAME_ODATA:      userName must be send in OData Filter.
 */
public enum ODataAuthStrategy {
    NONE,
    CUSTOMER_ISIN_URL,
    USER_NAME_URL,
    CUSTOMER_ISIN_ODATA,
    USER_NAME_ODATA;
}
