package server7.testng;

/**
 * enum with url, credentials, paths and parameters for drivers
 */
public enum Messages {
    FAIL_LOGIN_ADMIN_CHROME_CLICK("Fail Admin login to his profile " +
            "on Chrome with clicking button"),
    FAIL_LOGIN_ADMIN_FIREFOX_CLICK("Fail Admin login to his profile " +
            "on Firefox with clicking button"),
    FAIL_LOGIN_ADMIN_CHROME_ENTER("Fail Admin login to his profile " +
            "on Chrome with clicking 'Enter'"),
    FAIL_LOGIN_ADMIN_FIREFOX_ENTER("Fail Admin login to his profile " +
            "on Firefox with clicking 'Enter'"),
    FAIL_LOGOUT_ADMIN_CHROME_CLICK("Fail Admin logout from his profile " +
            "on Chrome with clicking button"),
    FAIL_LOGOUT_ADMIN_FIREFOX_CLICK("Fail Admin logout from his profile " +
            "on Firefox with clicking button"),
    FAIL_LOGOUT_ADMIN_CHROME_ENTER("Fail Admin logout from his profile " +
            "on Chrome with clicking 'Enter'"),
    FAIL_LOGOUT_ADMIN_FIREFOX_ENTER("Fail Admin logout from his profile " +
            "on Firefox with clicking 'Enter'"),
    FAIL_ENTER_PRODUCTS_CHROME_FOLD_SIDEBAR("Fail admin enter to the " +
            "products window on Chrome with folded sidebar"),
    FAIL_ENTER_PRODUCTS_FIREFOX_FOLD_SIDEBAR("Fail admin enter to the " +
            "products window on Firefox with folded sidebar"),
    FAIL_ENTER_PRODUCTS_CHROME("Fail admin enter to the " +
            "products window on Chrome"),
    FAIL_ENTER_PRODUCTS_FIREFOX_UNFOLD_SIDEBAR("Fail admin enter to the " +
            "products window on Firefox with unfolded sidebar"),
    FAIL_PAGINATION_NUMBER_OF_PAGES ("Number of pages is wrong"),
    FAIL_PAGINATION_NUMBER_OF_ITEMS_PER_PAGE ("Wrong number of items per page");

    private String chosenMessage;

    Messages(String choice) {
        chosenMessage = choice;
    }

    public String getMessage() {
        return chosenMessage;
    }
}
