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
package task1.minMultiple;

import java.io.InputStream;

/**
 * This class is for running Software.
 */
public class Run {

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
        int firstNumber = inputOutputData.getNumberFromSource(
                Messages.FIRST_NUMBER_TEXT.getMessage());
        int secondNumber = inputOutputData.getNumberFromSource(
                Messages.SECOND_NUMBER_TEXT.getMessage());
        OperationsWithNumbers operationsWithNumbers
                = new OperationsWithNumbers();
        int result = operationsWithNumbers.minMultipleCount(firstNumber,
                secondNumber);
        inputOutputData.printResult(firstNumber, secondNumber, result);
        inputFromSource.closeSource();
    }
}
