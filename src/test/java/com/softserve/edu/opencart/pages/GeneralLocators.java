package com.softserve.edu.opencart.pages;

public enum GeneralLocators {
    FIRST_ANCHOR_CSS("a:first-child"),
    FIRST_NAME_LOCATOR("input-firstname"),
    LAST_NAME_LOCATOR("input-lastname"),
    ADDRESS_LOCATOR("input-address-1"),
    CITY_LOCATOR("input-city");
    //
    private String field;

    private GeneralLocators(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return field;
    }
}
