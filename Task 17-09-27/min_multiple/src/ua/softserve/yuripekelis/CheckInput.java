
package ua.softserve.yuripekelis;

/**
 * This class is for parsing String.
 */
final class CheckInput {

    /**
     * The blank constructor.
     */
    private CheckInput() {
    }

    /**
     * This constant consists of text for error,
     * when user didn't used only digits.
     */
    private static final String ERROR_NOT_NUMBER = "Input numbers next time";

    /**
     * This method is used for checking typed string.
     *
     * @param enteredString - String that has been typed
     * @return number parsed from the string
     * @throws NumberFormatException - if string isn't number
     */
    static int enteredStringCheck(final String enteredString) {
        int number = 0;
        try {
            number = Integer.parseInt(enteredString);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_NOT_NUMBER);
            System.exit(1);
        }
        return number;
    }
}
