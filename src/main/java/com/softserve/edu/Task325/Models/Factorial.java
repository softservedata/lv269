package com.softserve.edu.Task325.Models;

/**
 * class made for counting Factorial
 */
public class Factorial {
    /**
     * @param number
     * @return (n-1)!
     */
    public static Integer factorialFromNMinusOne(Integer number) {
        Integer n = 1;
        for (int i = 1; i < number - 1; i++) {
            n *= i;
        }
        return n;
    }
}

