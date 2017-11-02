package task1.minMultiple;

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
        System.out.println(Messages.MESSAGE_QUIT.getMessage());
        int number = 0;
        boolean enteredRight = false;
        do {
            if (source.isNextNumber()) {
                number = source.nextIntFromScanner();
                if (number >= 0) {
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

    /**
     * This method prints result.
     *
     * @param firstNumber  - the given first number.
     * @param secondNumber - the given second number.
     * @param result       - calculated result
     */
    public void printResult(int firstNumber, int secondNumber, int result) {
        System.out.println(Messages.LOWEST_MULTIPLE_TEXT.getMessage()
                + firstNumber + Messages.AND_TEXT.getMessage() + secondNumber
                + Messages.IS_TEXT.getMessage() + result);
    }
}


