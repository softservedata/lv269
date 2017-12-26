package com.softserve.edu.opencart.tests;

public enum TestContextAttributes {

    PATHNAMES("Pathnnames"),
    DEFAULT_SETTING_OPTIONS_LIST ("DefaultSettingOptionsList"),
    TOKEN ("Token"),
    PRODUCT_ADMIN_PAGE("ProductAdminPage"),
    REVIEW_FIELD_MESSAGE("Check field for %s using: %s"),
	PRICES_NOT_EQUALS("Prices not equals:"),
	SYMBOLS_NOT_EQUALS("Symbols not equals:"),
	ELEMENT_NOT_FOUND("Web element(s) not found!"),
	ENABLE_CURRENCY("Started enableCurrencyTest()"),
	ENUBLE_CURRENCY_OPTION("Started enableCurrencyOptionTest()"),
	STARTED_CHECK_CHANGE_CURRENCY_BY_PRICE("Started checkChangeCurrencyByPrice(DetailCategory %s, Product %s)");
    //
    private String field;

    private TestContextAttributes(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return field;
    }
}