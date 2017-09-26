package ua.softserve.yuripekelis;
import java.util.ArrayList;
/**
 * <h1>Finding number(s) with max divisors</h1>
 * This software searches for the numbers from the range from 0 to 10000
 * with maximum quantity of divisors.
 * @author  Yuri Pekelis
 * @version 1.01
 * @since   2017-09-21
 */

public class Runner {
    public static final String ANSWER_BETWEEN_NUMBERS = "Between numbers from 0 to ";
    public static final String ANSWER_WINNER = " the winner";
    public static final String IS = " is ";
    public static final String ARE = "s are ";
    public static final String WITH = "with ";
    public static final String DIVISORS = " divisors.";

    /**
     * This is the main method which makes use of other methods.
     * @param args Unused.
     * @return Nothing.
     */

    public static void main(String[] args) {
        int maxNumber = 10000;
        ArrayList<Integer> numbersWithMaxDivisors = new ArrayList<>();
        int maxDivisors = LoopForNumbers.loopForNumbers(maxNumber, numbersWithMaxDivisors);

        System.out.print(ANSWER_BETWEEN_NUMBERS + maxNumber);
        System.out.print(ANSWER_WINNER);
        if (numbersWithMaxDivisors.size() == 1)
            System.out.print(IS);
        else
            System.out.print(ARE);
        for (Integer number : numbersWithMaxDivisors) {
            System.out.print(number + " ");
        }
        System.out.println(WITH + maxDivisors + DIVISORS);
    }
}
