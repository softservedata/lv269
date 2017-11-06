package com.softserve.edu.task1.minMultiple;

/**
 * This class for using in test methods instead of method with Scanner.
 */
public class InputFromSourceStub implements IInputFromSource {

    /**
     * This variables emulates entering data from console.
     */
    private int number;
    private boolean isNumber;
    private String returnedString;

    /**
     * This method emulates input data from console
     * @param enteredString - virtually typed string by user.
     */
    public void setParameters (String enteredString) {
        try {
            number = Integer.parseInt(enteredString);
            isNumber = true;
            returnedString = null;
        } catch (NumberFormatException e) {
            number = 0;
            isNumber = false;
            returnedString = enteredString;
        }
    }

    /**
     * This method returns boolean value, that shows if typed string is number.
     * @return a flag
     */
    @Override
    public boolean isNextNumber() {
        return isNumber;
    }

    /**
     * This method returns the entered number.
     * @return entered number
     */
    @Override
    public int nextIntFromScanner() {
        return number;
    }

    /**
     * This method returns entered string
     * @return entered string.
     */
    @Override
    public String nextStringFromScanner() {
        return returnedString;
    }

    @Override
    public void closeSource() {

    }
}
