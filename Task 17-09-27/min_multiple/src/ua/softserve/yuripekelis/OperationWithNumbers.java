package ua.softserve.yuripekelis;

public class OperationWithNumbers {

    /**
     * This method is for checking numbers (they must be positive  and not equal
     *
     * @param firstNumber, secondNumber - entered numbers
     *  if not positive exit with status
     */
    static void checkNumbers(Integer firstNumber, Integer secondNumber) {
        if (firstNumber <= 0 || secondNumber <= 0) {
            System.out.println("Numbers must be positive!");
            System.exit(2);
        }
        if (secondNumber == firstNumber) {
            System.out.println("This numbers are equal.");
            System.exit(0);
        }
    }
}
