package ua.softserve.yuripekelis;

import java.util.Scanner;


public class InputNumbers {

    private Scanner scanner;

    InputNumbers() {
        scanner = new Scanner(System.in);
    }

    /**
     * This method is used for input from keyboard Strings: two
     * numbers for calculation.
     * param String with question, which describes input data.
     *
     * @return String that was typed.
     */
    public String getText(String question) {
        String enteredString = "";
        System.out.println(question);
        if (scanner.hasNext()) {
            enteredString = scanner.next();
        }
        return enteredString;
    }

    /**
     * This method is used for closing Scanner.
     * param Unused.
     *
     * @return Nothing
     */
    public void closeScanner() {
        scanner.close();
    }
}
