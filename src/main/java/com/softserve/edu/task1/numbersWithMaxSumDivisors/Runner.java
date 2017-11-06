/*
 * <h1>Finding a number with the maximal divisors' sum </h1>
 * This software searches for the numbers with maximum sum of divisors
 * from the range from 0 to 10000.
 *
 * @author  Yuri Pekelis
 * @version 1.01
 * @since   2017-09-21
 */
package com.softserve.edu.task1.numbersWithMaxSumDivisors;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is for running Software.
 */
public class Runner {

    /**
     * A Constant with upper range.
     */
    public static final int UPPER_RANGE = 10000;

    /**
     * This is the main method of the software.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        List<Integer> numbersWithMaxDivisorsSum = new ArrayList<Integer>();
        int maxDivisors = LoopForNumbers.loopForNumbers(
                UPPER_RANGE, numbersWithMaxDivisorsSum);
        OutputAnswer.printAnswer(numbersWithMaxDivisorsSum, maxDivisors,
                UPPER_RANGE);
    }
}
