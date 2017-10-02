package edu.softserve.yuripekelis.minMultiple;

/**
 * This class is for calculation of the maximal divisor for 2 numbers
 * using Euclid`s algorithm.
 */
public class Operations {

    /**
     * This method counts the minimal multiple.
     *
     * @param firstNumber  - the first positive number
     * @param secondNumber - the second positive number
     * @return the minimal multiple
     */
    public static int minMultipleCount(int firstNumber, int secondNumber) {
        int minMultiple = 0;
        if ((firstNumber + secondNumber > 0)) {
            minMultiple = firstNumber * secondNumber
                    / findMaxDivisor(firstNumber, secondNumber);
        }
        return minMultiple;
    }

    /**
     * This method counts the maximal common divisor.
     *
     * @param firstNumber  - the first positive number
     * @param secondNumber - the second positive number
     * @return the maximal common divisor
     */
    private static int findMaxDivisor(
            int firstNumber, int secondNumber) {
        if (firstNumber < secondNumber) {
            int temp = secondNumber;
            secondNumber = firstNumber;
            firstNumber = temp;
        }
        int[] nod = {firstNumber, 0};
        if (secondNumber != 0) {
            nod[1] = secondNumber;
            int r;
            do {
                r = nod[0] % nod[1];
                nod[0] = nod[1];
                nod[1] = r;
            } while (r != 0);
        }
        return nod[0];
    }


}
