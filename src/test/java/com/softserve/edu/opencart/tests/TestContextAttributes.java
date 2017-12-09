package com.softserve.edu.opencart.tests;

public enum TestContextAttributes {

    PATHNAMES("Pathnnames"),
    DEFAULT_SETTING_OPTIONS_LIST ("DefaultSettingOptionsList"),
    TOKEN ("Token"),
    PRODUCT_ADMIN_PAGE("ProductAdminPage"),
    REVIEW_FIELD_MESSAGE("Check field for %s using: %s");
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