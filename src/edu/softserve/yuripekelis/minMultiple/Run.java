/*
 * <h1>Calculation of the common divisor</h1>
 * The Calculation of the common divisor program implements an application that
 * finds the minimal multiple for two positive numbers and prints
 * the result on the screen.
 *
 * @author Yuri Pekelis
 * @version 1.02
 * @since 2017-09-21
 */
package edu.softserve.yuripekelis.minMultiple;

import java.io.InputStream;

/**
 * This class is for running Software.
 */
public class Run {

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
        InputFromSource inputFromSource = new InputFromSource(INPUT_STREAM);
        InputOutputData inputOutputData = new InputOutputData(inputFromSource);
        int firstNumber = inputOutputData.getNumberFromSource(FIRST_NUMBER_TEXT);
        int secondNumber = inputOutputData.getNumberFromSource(SECOND_NUMBER_TEXT);
        inputOutputData.printResult(firstNumber, secondNumber,
                Operations.minMultipleCount(firstNumber, secondNumber));
        inputFromSource.closeSource();
    }
}
