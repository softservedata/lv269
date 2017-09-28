/*
 * <h1>Calculation of the common divisor</h1>
 * The Calculation of the common divisor program implements an application that
 * finds the minimum multiply of two positive numbers and prints
 * the output on the screen.
 *
 * @author Yuri Pekelis
 * @version 1.01
 * @since 2017-09-21
 */
package edu.softserve.yuripekelis.minMultiple;

import java.io.InputStream;

/**
 * This class is for running Software.
 */
class Run {

    /**
     * The constant with text for the entering the first number.
     */
    public static final String FIRST_NUMBER_TEXT =
            "Enter the first positive number:";

    /**
     * The constant with text for the entering the second number.
     */
    public static final String SECOND_NUMBER_TEXT =
            "Enter the second positive number:";

    /**
     * The constant with text for a part of the answer.
     */
    public static final String LOWEST_MULTIPLE_TEXT =
            "The lowest multiple for ";

    /**
     * The constant with text for a part of the answer.
     */
    public static final String AND_TEXT = " and ";

    /**
     * The constant with text for a part of the answer.
     */
    public static final String IS_TEXT = " is ";

    /**
     * This constant shows where data will be entered from.
     */
    public static final InputStream INPUT_STREAM = System.in;

    /**
     * This is the main method which makes use of calculation of
     * multiply method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        InputNumber inputNumbers = new InputNumber(INPUT_STREAM);
        Integer firstNumber = inputNumbers.getNumber(FIRST_NUMBER_TEXT);
        Integer secondNumber = inputNumbers.getNumber(SECOND_NUMBER_TEXT);
        int maxDivisor = MaxDivisor.findMaxDivisor(firstNumber, secondNumber);
        System.out.println(LOWEST_MULTIPLE_TEXT + firstNumber + AND_TEXT
                + secondNumber + IS_TEXT + (firstNumber
                * secondNumber / maxDivisor));
        inputNumbers.closeScanner();
    }
}
