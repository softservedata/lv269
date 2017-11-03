package com.edu.softserve.task1.minMultiple;

/**
 * enum with printed strings.
 */
public enum Messages {

    /**
     * List of constants:
     * FIRST_NUMBER_TEXT - text for the entering the first number
     * SECOND_NUMBER_TEXT - text for the entering the second number
     * ERROR_NOT_NUMBER - text for an error - something else except digits
     * was entered
     * ERROR_NEGATIVE_NUMBER - text for an error - negative number was entered
     * MESSAGE_QUIT - message for instructions for exit
     * QUIT_COMMAND - command for exit
     * LOWEST_MULTIPLE_TEXT - a part of the answer
     * AND_TEXT - a part of the answer
     * IS_TEXT - a part of the answer
     */
    FIRST_NUMBER_TEXT("Enter the first positive number:"),
    SECOND_NUMBER_TEXT("Enter the second positive number:"),
    ERROR_NOT_NUMBER("Wrong input, please enter the number"),
    ERROR_NEGATIVE_NUMBER("Numbers must be positive!"),
    MESSAGE_QUIT("Or type 'quit' for exit."),
    QUIT_COMMAND("quit"),
    LOWEST_MULTIPLE_TEXT("The lowest multiple for "),
    AND_TEXT(" and "),
    IS_TEXT(" is ");

    private String chosenMessage;

    Messages(String choice) {
        chosenMessage = choice;
    }

    public String getMessage() {
        return chosenMessage;
    }
}
