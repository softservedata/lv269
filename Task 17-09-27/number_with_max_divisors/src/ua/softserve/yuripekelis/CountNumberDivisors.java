package ua.softserve.yuripekelis;

/**
 * This class is for organizing calculation of divisors for the number.
 */
final class CountNumberDivisors {

    /**
     * The blank constructor.
     */
    private CountNumberDivisors() {
    }

    /**
     * This class counts quantity of divisors for a number.
     *
     * @param number which must be counted
     * @return the number of divisors
     */
    static int countDivisors(final int number) {
        int divisorsForThisNumber = 2;
        /* There is no sense to count after number/2 */
        for (int i = 2; i < (number / 2 + 1); i++) {
            if (number % i == 0) {
                divisorsForThisNumber++;
            }
        }
        return divisorsForThisNumber;
    }

}
