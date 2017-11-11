package com.softserve.edu.opencart.testng.pages;

public enum GeneralLocators {
    FIRST_ANCHOR_CSS ("a:first-child"),
    CHILDREN_LI_XPTH("./li"),
    SPAN_TAG("span");

    private String field;

    GeneralLocators(String field) {
        this.field = field;
    }

    public String toString() {
        return field;
    }
}
