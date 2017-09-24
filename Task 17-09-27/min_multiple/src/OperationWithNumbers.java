public class OperationWithNumbers {
    static void checkNumbers (Integer firstNumber, Integer secondNumber) {
        if (firstNumber <= 0 || secondNumber <= 0) {
            System.out.println("Numbers must be positive!");
            System.exit(2);
        }
        if (secondNumber == firstNumber) {
            System.out.println("This numbers are equal.");
            System.exit(0);
        }

        if (firstNumber < secondNumber) {
            int temp = firstNumber;
            firstNumber = secondNumber.intValue();
            secondNumber = temp;
        }
    }
}
