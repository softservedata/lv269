package edu.softserve.yuripekelis.numbersWithMaxSumDivisors;

import java.util.List;

public class OutputAnswer {
    /**
     * The constants with text for the answer.
     */
    private static final String ANSWER_BETWEEN_NUMBERS
            = "Between numbers from 0 to ";
    private static final String ANSWER_WINNER = " the winner";
    private static final String IS = " is ";
    private static final String ARE = "s are ";
    private static final String WITH = "with ";
    private static final String DIVISORS = " divisors' sum.";

    public static void printAnswer (List<Integer>  numbersWithMaxDivisorsSum,
                                    int maxDivisorsSum) {
        System.out.print(ANSWER_BETWEEN_NUMBERS + Runner.UPPER_RANGE);
        System.out.print(ANSWER_WINNER);
        if (numbersWithMaxDivisorsSum.size() == 1) {
            System.out.print(IS);
        } else {
            System.out.print(ARE);
        }
        for (Integer number : numbersWithMaxDivisorsSum) {
            System.out.print(number + " ");
        }
        System.out.println(WITH + maxDivisorsSum + DIVISORS);
    }
}
