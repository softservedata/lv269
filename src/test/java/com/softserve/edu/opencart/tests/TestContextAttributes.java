package com.softserve.edu.opencart.tests;

public enum TestContextAttributes {

    PATHNAMES("Pathnnames");
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