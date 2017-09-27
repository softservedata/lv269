package ua.softserve.yuripekelis;

/**
 * This class is for check of entered numbers.
 */
final class OperationWithNumbers {

    /**
     * The blank constructor.
     */
    private OperationWithNumbers() {
    }

    /**
     * This constant consists of text for error,
     * when user entered negative number or 0 .
     */
    private static final String ERROR_NEGATIVE_NUMBER
            = "Numbers must be positive!";

    /**
     * This constant consists of text for error,
     * when user didn't used only digits.
     */
    private static final String MESSAGE_EQUAL_NUMBER
            = "This numbers are equal.";

    /**
     * This method is for checking numbers (they must be positive and not
     * equal). If conditions are false then exit with code.
     *
     * @param firstNumber - entered the first number
     * @param secondNumber - entered numbers
     */
    static void checkNumbers(
            final Integer firstNumber, final Integer secondNumber) {
        if (firstNumber <= 0 || secondNumber <= 0) {
            System.out.println(ERROR_NEGATIVE_NUMBER);
            System.exit(2);
        }
        if (secondNumber.equals(firstNumber)) {
            System.out.println(MESSAGE_EQUAL_NUMBER);
            System.exit(0);
        }
    }
}
