package com.softserve.edu.opencart.pages;

public enum RegexPatterns {
    ALL_DIGITS("\\d+"),
    FIRST_DIGITS("^\\d+"),
    LAST_DOUBLE("\\d+\\.\\d+$"),
    NUMBER_DOUBLE("\\d+\\.\\d+"),
    ANY_NUMBER_OF_SYMBOLS(".*");
    //
    private String field;

    private RegexPatterns(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return field;
    }
}