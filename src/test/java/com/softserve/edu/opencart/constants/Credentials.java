package com.softserve.edu.opencart.constants;

/**
 * enum with url, credentials, paths,  parameters for drivers,
 * values...
 */
public enum Credentials {
    ADMINISTRATOR_LOGIN("admin"),
    ADMINISTRATOR_PASSWORD("269lv269lv"),

    ITEMS_PER_PAGE_DFLT("20"),
    ITEMS_PER_PAGE_MIN("1"),
    ITEMS_PER_PAGE_GREAT("10000"),
    BUTTON("button"),
    ENTER("enter"),
    ADM_PRODUCT_PG_STATUS_SLCT_NONVALUE_TXT (""),
    ADM_PRODUCT_PG_STATUS_SLCT_VALUE_TRUE_TXT ("Enabled"),
    ADM_PRODUCT_PG_STATUS_SLCT_VALUE_FALSE_TXT ("Disabled"),
    ADM_PRODUCT_PG_IMG_SLCT_NONVALUE_TXT (""),
    ADM_PRODUCT_PG_IMG_SLCT_VALUE_TRUE_TXT("Enabled"),
    ADM_PRODUCT_PG_IMG_SLCT_VALUE_FALSE_TXT("Disabled"),

    ATTRIBUTE_VALUE ("value"),
    TEST_USER_LOGIN("q2098007@mvrht.net"),
    TEST_USER_PASSWORD("temporary");

    private String field;

    Credentials(String field) {
        this.field = field;
    }

    public String toString() {
        return field;
    }
    }
