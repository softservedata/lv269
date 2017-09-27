
package ua.softserve.yuripekelis;

/**
 * This class is for parsing String and checking data.
 */
final class DataCheck {

    /**
     * The blank constructor.
     */
    private DataCheck() {
    }

    /**
     * This constant consists of text for error,
     * when user didn't used only digits.
     */
    private static final String ERROR_NOT_NUMBER = "Input numbers next time";

    /**
     * This constant consists of text for error,
     * when user entered negative number or 0 .
     */
    private static final String ERROR_NEGATIVE_NUMBER
            = "Numbers must be positive!";

    /**
     * This method is used for checking typed string.
     *
     * @param enteredString - String that has been typed
     * @return number parsed from the string
     * @throws NumberFormatException - if string isn't number
     */
    static int dataCheck(final String enteredString) {
        int number = 0;
        try {
            number = Integer.parseInt(enteredString);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_NOT_NUMBER);
            System.exit(1);
        }
        if (number <= 0) {
            System.out.println(ERROR_NEGATIVE_NUMBER);
            System.exit(2);
        }
        return number;
    }
}
