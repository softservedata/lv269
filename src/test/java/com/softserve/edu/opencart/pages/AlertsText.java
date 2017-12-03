package com.softserve.edu.opencart.pages;

public enum AlertsText {
    FIRST_NAME_MUST_BE_1_TO_32("First Name must be between 1 and 32 characters!"),
    LAST_NAME_MUST_BE_1_TO_32("Last Name must be between 1 and 32 characters!"),
    ADDRESS_MUST_BE_3_TO_128("Address must be between 3 and 128 characters!"),
    CITY_MUST_BE_2_TO_128("City must be between 2 and 128 characters!"),
    NOT_SELECTED_COUNTRY("Please select a country!"),
    NOT_SELECTED_REGION("Please select a region / state!"),
    CAN_NOT_DELETE_ADDRESS("Warning: You can not delete your default address!");


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
