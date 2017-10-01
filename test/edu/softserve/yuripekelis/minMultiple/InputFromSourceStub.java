package edu.softserve.yuripekelis.minMultiple;


public class InputFromSourceStub implements IInputFromSource {

    private int number;
    private boolean isNumber;
    private String returnedString;

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

    @Override
    public boolean isNextNumber() {
        return isNumber;
    }

    @Override
    public int nextIntFromScanner() {
        return number;
    }

    @Override
    public String nextStringFromScanner() {
        return returnedString;
    }

    @Override
    public void closeSource() {

    }
}
