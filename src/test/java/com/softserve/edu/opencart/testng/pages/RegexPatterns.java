package com.softserve.edu.opencart.testng.pages;

/**
 * enum with url, credentials, paths,  parameters for drivers,
 * values...
 */
public enum RegexPatterns {

    ALL_DIGITS("\\d+"),
    FIRST_DIGITS("^\\d+"),
    LAST_DOUBLE("\\d+\\.\\d+$");

    private String chosen;

    RegexPatterns(String choice) {
        chosen = choice;
    }

    public String get() {
        return chosen;
    }
    }
