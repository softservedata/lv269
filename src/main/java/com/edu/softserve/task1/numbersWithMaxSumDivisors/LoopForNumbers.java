package com.edu.softserve.task1.numbersWithMaxSumDivisors;

import java.util.List;

/**
 * This class is for organizing a loop from 0 to maxNumber.
 */
public class LoopForNumbers {

    /**
     * This method organizes loop, calls CountNumberDivisors class to count
     * number of divisors for the current number. It changes resulted Arrays,
     * according to the results.
     *
     * @param maxNumber              - the maximum number which is upper range
     *                               for the loop
     * @param numbersWithMaxSumDivisors - Array saves numbers with maximum
     *                                  divisors sum
     * @return maxDivisorsSum - saves maximum quantity of divisors
     */
    public static int loopForNumbers(int maxNumber,
            List<Integer> numbersWithMaxSumDivisors) {
        /* every number has 2 divisors - 1 and this number */
        int maxSumDivisors = 1;
        for (int i = maxNumber / 2; i <= maxNumber; i++) {
            int divisorsSumForThisNumber = CountDivisorsSum
                    .countDivisorsSum(i);
            if (divisorsSumForThisNumber > maxSumDivisors) {
                maxSumDivisors = divisorsSumForThisNumber;
                numbersWithMaxSumDivisors.clear();
            }
            if (divisorsSumForThisNumber == maxSumDivisors) {
                numbersWithMaxSumDivisors.add(i);
            }
        }
        return maxSumDivisors;
    }
}
