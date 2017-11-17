package com.softserve.edu.opencart.pages;

/**
 * enum with url, credentials, paths and parameters for drivers
 */
public enum PageNames {
    DASHBOARD_ADMIN("Dashboard"),
    PRODUCTS_ADMIN("Products");

    private String field;

    PageNames(String field) {
        this.field = field;
    }

    public String toString() {
        return field;
    }
}
