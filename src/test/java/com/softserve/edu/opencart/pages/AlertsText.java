package com.softserve.edu.opencart.pages;

public enum AlertsText {
    FIRST_NAME_MUST_BE_1_TO_32("First Name must be between 1 and 32 characters!"),
    SECOND_NAME_MUST_BE_1_TO_32("Second Name must be between 1 and 32 characters!"),
    ADDRESS_MUST_BE_3_TO_128("Address must be between 3 and 128 characters!"),
    CITY_MUST_BE_2_TO_128("City must be between 2 and 128 characters!");

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
