package com.softserve.edu.opencart.data;

/**
 * enum with url, credentials, paths and parameters for drivers
 */
public enum ErrorMessages {
    WRONG_LOGIN_ADMIN_VALID("Wrong Action, when Admin is trying to login with valid credentials"),
    WRONG_LOGIN_ADMIN_INVALID("Wrong Action, when Admin is trying to login with invalid credentials"),
    WRONG_OPEN_ADMIN_PRODUCT_PAGE ("Wrong opening of the AdminProductPage"),
    WRONG_NUMBER_PAGES_PAGINATION ("Wrong Number of pages in pagination on AdminProductPage, items =%d, items per page = %d)"),
    WRONG_NUMBER_ITEMS_PER_PAGES ("Wrong number of items on every page, it is not equal to the first one"),

    WRONG_PATHNAMES_LIST_SIZE_EXC ("Wrong pathnamesListSize for %s");

    //TODO Clear extra

    private String field;

    ErrorMessages(String field) {
        this.field = field;
    }

    public String getMessage() {
        return field;
    }
}
