package com.softserve.edu.opencart.pages;

public enum GeneralLocators {
    FIRST_ANCHOR_CSS("a:first-child");
    //
    private String field;

    private GeneralLocators(String field) {
        this.field = field;
    }

    public String toString() {
        return field;
    }
}
