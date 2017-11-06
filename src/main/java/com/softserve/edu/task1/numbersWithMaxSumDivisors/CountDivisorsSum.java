package com.softserve.edu.task1.numbersWithMaxSumDivisors;

/**
 * This class is for organizing calculations of divisors' sum for the number.
 */
public class CountDivisorsSum implements ICountDivisorsSum {

    /**
     * This class counts a sum of divisors for a number.
     *
     * @param number - a positive number that must be counted
     * @return the sum of divisors
     */
    public static int countDivisorsSum(int number) {
        int divisorsSumForThisNumber = number;
        /* There is no sense to count after number/2 */
        for (int i = 1; i < (number / 2 + 1); i++) {
            if (number % i == 0) {
                divisorsSumForThisNumber += i;
            }
        }
        return divisorsSumForThisNumber;
    }

}
