package com.softserve.edu.opencart.pages;

public enum TagAttribute {
    HREF("href"),
    VALUE("value");
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
