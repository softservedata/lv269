package edu.softserve.yuripekelis.minMultiple;

import java.io.InputStream;
import java.util.Scanner;

/**
 * This class is for operations with Scanner, checking a type of data and for
 * output a result.
 */
public class InputOutputData {

    /**
     * This variable is for recieving data from source.
     */
    private IInputFromSource source;

    /**
     * This constant consists of text for error,
     * when user entered something else except digits.
     */
    public static final String ERROR_NOT_NUMBER
            = "Wrong input, please enter the number";

    /**
     * This constant consists of a text for the error,
     * when a user entered a negative number or 0 .
     */
    public static final String ERROR_NEGATIVE_NUMBER
            = "Numbers must be positive!";

    /**
     * Message with command for exit.
     */
    public static final String MESSAGE_QUIT
            = "Or type 'quit' for exit.";

    /**
     * This constant is a command for exit
     */
    public static final String QUIT_COMMAND = "quit";

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
     * This constructor creates Scanner object.
     */
    public InputOutputData(IInputFromSource source) {
        this.source = source;
    }

    /**
     * This method is used for input from keyboard a positive number.
     *
     * @param question - the string that gives an information about the
     *                 entering data.
     * @return The typed number.
     */
    public int getNumberFromSource(String question) {
        System.out.println(question);
        System.out.println(MESSAGE_QUIT);
        int number = 0;
        boolean enteredRight = false;
        do {
            if (source.isNextNumber()) {
                number = source.nextIntFromScanner();
                if (number >= 0) {
                    enteredRight = true;
                } else {
                    System.out.println(ERROR_NEGATIVE_NUMBER);
                }
            } else {
                if (source.nextStringFromScanner().equals(QUIT_COMMAND)) {
                    source.closeSource();
                    System.exit(0);
                }
                System.out.println(ERROR_NOT_NUMBER);
                System.out.println(MESSAGE_QUIT);
            }
        } while (!enteredRight);
        return number;
    }

    /**
     * This method prints result.
     *
     * @param firstNumber  - the given first number.
     * @param secondNumber - the given second number.
     * @param result       - calculated result
     */
    public void printResult(int firstNumber, int secondNumber, int result) {
        System.out.println(LOWEST_MULTIPLE_TEXT + firstNumber + AND_TEXT
                + secondNumber + IS_TEXT + result);
    }
}


