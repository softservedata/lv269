package com.softserve.edu.opencart.pages;

/**
 * enum with url, credentials, paths,  parameters for drivers,
 * values...
 */
public enum TagAttribute {

    VALUE("value"),
    TEXT_CONTENT("textContent"),
    HREF("href"),
    SRC("src"),
    CLASS ("class"),
    TEXTAREA ("textarea"),
    INPUT ("input"),
    SELECT ("select"),
    ANCHOR("a"),
    LABEL("label"),
    PRODUCT_NAME ("Product Name"),
    MODEL ("Model"),
    PRICE ("Price"),
    QUANTITY ("Quantity"),
    STATUS ("Disabled"),
    IMAGE ("Image"),
    ENABLED("Enabled"),
    DISABLED("Disabled");

    private String field;

    TagAttribute(String field) {
        this.field = field;
    }

    public String toString() {
        return field;
    }
}
