package com.softserve.edu.opencart.pages;

public enum TagAttribute {
    HREF("href"),
    TEXT_CONTENT("textContent"),
    VALUE("value"),
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
    STATUS ("Status"),
    IMAGE ("Image"),
    ENABLED("Enabled"),
    DISABLED("Disabled"),
    ASC ("asc"),
    DESC ("desc");
    //
    private String field;

    private TagAttribute(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return field;
    }
}
