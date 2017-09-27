package ua.softserve.yuripekelis;

import java.util.Scanner;

/**
 * This class is for work with Scanner and entering data.
 */
class InputData {
    /**
     * Variable for Scanner object.
     */
    private Scanner scanner;

    /**
     * Creating Scanner object.
     */
    InputData() {
        scanner = new Scanner(System.in);
    }

    /**
     * This method is used for input from keyboard Strings: two
     * numbers for calculation.
     *
     * @param question - the string with question, which is printed before
     *                 typing by user.
     * @return String that was typed.
     */
    String getText(final String question) {
        String enteredString = "";
        System.out.println(question);
        if (scanner.hasNext()) {
            enteredString = scanner.next();
        }
        return enteredString;
    }

    /**
     * This method is used for closing Scanner.
     */
    void closeScanner() {
        scanner.close();
    }
}
