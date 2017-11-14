package com.softserve.edu.opencart.pages;

/**
 * enum with url, credentials, paths and parameters for drivers
 */
public enum MessagesOnPages {
    ADMIN_LOGIN_ERROR ("No match for Username and/or Password.");

    private String field;

    MessagesOnPages(String field) {
        this.field = field;
    }

    public String toString() {
        return field;
    }
}
