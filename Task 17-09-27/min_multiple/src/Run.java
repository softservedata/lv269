import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Integer firstNumber, secondNumber;
        InputNumbers inputNumbers = new InputNumbers();
        firstNumber = inputNumbers.getNumber("Enter the first positive number:");
        secondNumber = inputNumbers.getNumber("Enter the second positive number:");
        OperationWithNumbers.checkNumbers(firstNumber, secondNumber);
        int maxDivisor = MaxDivisor.findMaxDivisor(firstNumber, secondNumber);
        System.out.println("The lowest multiple from " + firstNumber + " and " + secondNumber +
                " is " + (firstNumber/maxDivisor*secondNumber));
    }
}
