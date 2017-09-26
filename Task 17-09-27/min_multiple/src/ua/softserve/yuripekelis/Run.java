/**
 * <h1>Calculation of the common divisor</h1>
 * The Calculation of the common divisor program implements an application that
 * finds the minimum multiply of two positive numbers and prints
 * the output on the screen.
 * @author  Yuri Pekelis
 * @version 1.01
 * @since   2017-09-21
 */
package ua.softserve.yuripekelis;

public class Run {
    public static final String FIRST_NUMBER_TEXT = "Enter the first positive number:";
    public static final String SECOND_NUMBER_TEXT = "Enter the second positive number:";
    public static final String LOWEST_MULTIPLE_TEXT = "The lowest multiple from ";
    public static final String AND_TEXT = " and ";
    public static final String IS_TEXT = " is ";

    /**
     * This is the main method which makes use of calculation of multiply method.
     * @param args Unused.
     * @return Nothing.
     */

    public static void main(String[] args) {
        InputNumbers inputNumbers = new InputNumbers();
        Integer firstNumber = CheckInput.enteredStringCheck(inputNumbers.getText(FIRST_NUMBER_TEXT));
        Integer secondNumber = CheckInput.enteredStringCheck(inputNumbers.getText(SECOND_NUMBER_TEXT));
        OperationWithNumbers.checkNumbers(firstNumber, secondNumber);
        int maxDivisor = MaxDivisor.findMaxDivisor(firstNumber, secondNumber);
        System.out.println(LOWEST_MULTIPLE_TEXT + firstNumber + AND_TEXT + secondNumber + IS_TEXT
                + (firstNumber * secondNumber / maxDivisor));
        inputNumbers.closeScanner();
    }
}
