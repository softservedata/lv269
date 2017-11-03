package com.edu.softserve.task1.pascalTriangle;


/**
 * This class is for operations with Scanner, checking a type of data.
 */
public class InputData {

    /**
     * This variable is for recieving data from source.
     */
    private IInputFromSource source;


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
        System.out.println(Messages.MESSAGE_QUIT.getMessage());
        int number = 0;
        boolean enteredRight = false;
        do {
            if (source.isNextNumber()) {
                number = source.nextIntFromScanner();
                if (number > 0) {
                    enteredRight = true;
                } else {
                    System.out.println(Messages.ERROR_NEGATIVE_NUMBER
                            .getMessage());
                }
            } else {
                if (source.nextStringFromScanner().equals(Messages
                        .QUIT_COMMAND.getMessage())) {
                    source.closeSource();
                    System.exit(0);
                }
                System.out.println(Messages.ERROR_NOT_NUMBER.getMessage());
                System.out.println(Messages.MESSAGE_QUIT.getMessage());
            }
        } while (!enteredRight);
        return number;
    }
}
