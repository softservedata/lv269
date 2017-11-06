package com.softserve.edu.task1.numbersWithMaxSumDivisors;

import java.util.List;

/**
 * This class is for printing a result.
 */
public class OutputAnswer {

    /**
     * This method prints result
     *
     * @param numbersWithMaxDivisorsSum - array with numbers that have the
     *                                  maximal divisor sum
     * @param maxDivisorsSum            - the maximal divisors' sum
     * @param upperRange                - upper range where the result has
     *                                  been found
     */
    public static void printAnswer(List<Integer> numbersWithMaxDivisorsSum,
                                   int maxDivisorsSum, int upperRange) {
        System.out.print(Messages.ANSWER_BETWEEN_NUMBERS.getMessage()
                + upperRange);
        System.out.print(Messages.ANSWER_WINNER.getMessage());
        if (numbersWithMaxDivisorsSum.size() == 1) {
            System.out.print(Messages.IS.getMessage());
        } else {
            System.out.print(Messages.ARE.getMessage());
        }
        for (Integer number : numbersWithMaxDivisorsSum) {
            System.out.print(number + " ");
        }
        System.out.println(Messages.WITH.getMessage() + maxDivisorsSum
                + Messages.DIVISORS.getMessage());
    }
}
