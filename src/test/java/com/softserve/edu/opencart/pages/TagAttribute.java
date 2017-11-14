package com.softserve.edu.opencart.pages;

/**
 * enum with url, credentials, paths,  parameters for drivers,
 * values...
 */
public enum TagAttribute {

    VALUE("value"),
    HREF("href"),
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
