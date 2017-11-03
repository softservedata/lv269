package com.edu.softserve.task1.pascalTriangle;

/**
 * enum with printed strings.
 */
public enum Messages {

    /**
     * List of constants:
     * ENTER_ROWS_TEXT - text for the entering a number of rows
     * ERROR_NOT_NUMBER - text for an error - something else except digits
     * was entered
     * ERROR_NEGATIVE_NUMBER - text for an error - negative number was entered
     * MESSAGE_QUIT - message for instructions for exit
     * QUIT_COMMAND - command for exit
     */
    ENTER_ROWS_TEXT("Enter number of rows to show:"),
    ERROR_NOT_NUMBER("Wrong input, please enter the number"),
    ERROR_NEGATIVE_NUMBER("Numbers must be positive!"),
    MESSAGE_QUIT("Or type 'quit' for exit."),
    QUIT_COMMAND("quit");

    private String chosenMessage;

    Messages(String choice) {
        chosenMessage = choice;
    }

    public String getMessage() {
        return chosenMessage;
    }
}
