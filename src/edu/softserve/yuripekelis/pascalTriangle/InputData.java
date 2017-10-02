package edu.softserve.yuripekelis.pascalTriangle;


/**
 * This class is for operations with Scanner, checking a type of data.
 */
public class InputData {

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
     * This constant is command for exit
     */
    public static final String QUIT_COMMAND = "quit";

    /**
     * Creating Scanner object.
     */
    public InputData(IInputFromSource source) {
        this.source = source;
    }

    /**
     * This method is used for input from keyboard positive number
     *
     * @param question - the string with question, which is printed before
     *                 typing by user.
     * @return The typed number.
     */
    public int getNumberFromSource (String question) {
        System.out.println(question);
        System.out.println(MESSAGE_QUIT);
        int number = 0;
        boolean enteredRight = false;
        do {
            if (source.isNextNumber()) {
                number = source.nextIntFromScanner();
                if (number > 0) {
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
}
