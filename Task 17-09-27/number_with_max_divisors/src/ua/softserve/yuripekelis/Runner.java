/*
 * <h1>Finding number(s) with max divisors</h1>
 * This software searches for the numbers from the range from 0 to 10000
 * with maximum quantity of divisors.
 * @author  Yuri Pekelis
 * @version 1.01
 * @since   2017-09-21
 */
package ua.softserve.yuripekelis;

import java.util.ArrayList;

/**
 * This class is for running Software.
 */
final class Runner {

    /**
     * The blank constructor.
     */
    private Runner() {
    }

    /**
     * The constants with text for an answer.
     */
    private static final String ANSWER_BETWEEN_NUMBERS
            = "Between numbers from 0 to ";

    /**
     * The constants with text for an answer.
     */
    private static final String ANSWER_WINNER = " the winner";

    /**
     * The constants with text for an answer.
     */
    private static final String IS = " is ";

    /**
     * The constants with text for an answer.
     */
    private static final String ARE = "s are ";

    /**
     * The constants with text for an answer.
     */
    private static final String WITH = "with ";

    /**
     * The constants with text for an answer.
     */
    private static final String DIVISORS = " divisors.";

    /**
     * A Constant with upper range.
     */
    private static final int UPPER_RANGE = 10000;

    /**
     * This is the main method which makes use of other methods.
     *
     * @param args Unused.
     */

    public static void main(final String[] args) {
        ArrayList<Integer> numbersWithMaxDivisors = new ArrayList<>();
        int maxDivisors = LoopForNumbers.loopForNumbers(
                UPPER_RANGE, numbersWithMaxDivisors);

        System.out.print(ANSWER_BETWEEN_NUMBERS + UPPER_RANGE);
        System.out.print(ANSWER_WINNER);
        if (numbersWithMaxDivisors.size() == 1) {
            System.out.print(IS);
        } else {
            System.out.print(ARE);
        }
        for (Integer number : numbersWithMaxDivisors) {
            System.out.print(number + " ");
        }
        System.out.println(WITH + maxDivisors + DIVISORS);
    }
}
