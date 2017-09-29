package edu.softserve.yuripekelis.minMultiple;

import java.io.InputStream;
import java.util.Scanner;

/**
 * This class is for work with Scanner and entering data.
 */
public class InputNumber {
    /**
     * Variable for Scanner object.
     */
    private Scanner scanner;

    /**
     * This constant consists of text for error,
     * when user didn't used only digits.
     */
    public static final String ERROR_NOT_NUMBER
            = "Wrong input, please enter the number";

    /**
     * This constant consists of text for error,
     * when user entered negative number or 0 .
     */
    public static final String ERROR_NEGATIVE_NUMBER
            = "Numbers must be positive!";

    /**
     * Message with command for exit.
     */
    public static final String MESSAGE_QUIT
            = "Or type 'quit' for exit.";

    /**
     * This constant is command for exit
     */
    public static final String QUIT_COMMAND = "quit";


    /**
     * Creating Scanner object.
     */
    InputNumber(InputStream stream) {
        scanner = new Scanner(stream);
    }

    /**
     * This method is used for input from keyboard positive number
     *
     * @param question - the string with question, which is printed before
     *                 typing by user.
     * @return The typed number.
     */
    public int getNumber(String question) {
        System.out.println(question);
        System.out.println(MESSAGE_QUIT);
        int number = 0;
        boolean enteredRight = false;
        do {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number > 0) {
                    enteredRight = true;
                } else {
                    System.out.println(ERROR_NEGATIVE_NUMBER);
                }
            } else {
                if (scanner.next().equals(QUIT_COMMAND)) {
                    scanner.close();
                    System.exit(1);
                }
                System.out.println(ERROR_NOT_NUMBER);
            }
        } while (!enteredRight);
        return number;
    }

    /**
     * This method is used for closing Scanner.
     */
    void closeScanner() {
        scanner.close();
    }
}
