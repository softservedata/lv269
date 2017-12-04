package com.softserve.edu.opencart.tests;

public enum TestContextAttributes {

    PATHNAMES("Pathnnames"),
    DEFAULT_SETTING_OPTIONS_LIST ("DefaultSettingOptionsList"),
    TOKEN ("Token"),
    PRODUCT_ADMIN_PAGE("ProductAdminPage");
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