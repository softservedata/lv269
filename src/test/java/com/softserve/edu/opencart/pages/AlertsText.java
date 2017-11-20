package com.softserve.edu.opencart.pages;

public enum AlertsText {
    FIRST_NAME_MUST_BE_1_TO_32("First Name must be between 1 and 32 characters!"),
    SECOND_NAME_MUST_BE_1_TO_32("Second Name must be between 1 and 32 characters!"),;
    //
    public String field;

    private AlertsText(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return field;
    }
}
