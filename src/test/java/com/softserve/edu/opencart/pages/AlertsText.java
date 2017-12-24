package com.softserve.edu.opencart.pages;

public enum AlertsText {
    FIRST_NAME_MUST_BE_1_TO_32("First Name must be between 1 and 32 characters!"),
    LAST_NAME_MUST_BE_1_TO_32("Last Name must be between 1 and 32 characters!"),
    ADDRESS_MUST_BE_3_TO_128("Address must be between 3 and 128 characters!"),
    CITY_MUST_BE_2_TO_128("City must be between 2 and 128 characters!"),
    NOT_SELECTED_COUNTRY("Please select a country!"),
    NOT_SELECTED_REGION("Please select a region / state!"),
    CAN_NOT_DELETE_ADDRESS("Warning: You can not delete your default address!"),
    SUCCESS_PASSWORD("Success: Your password has been successfully updated."),
    SUCCESS_ADDRESS_TEXT("Your address has been successfully updated"),
    NOT_VALID_PASS("Password must be between 4 and 20 characters!"),
    NOT_VALID_CONFIRM_PASS("Password confirmation does not match password!"),
    NOT_VALID_EMAIL("E-Mail Address does not appear to be valid!"),
    NOT_VALID_TELEPHONE("Telephone must be between 3 and 32 characters!"),
    NOT_VALID_ADDRESS("Address 1 must be between 3 and 128 characters!");


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
