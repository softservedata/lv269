package edu.softserve.yuripekelis.minMultiple;

/**
 * This class is for calculation of the maximum divisor for 2 numbers,
 * using Euclid`s algorithm.
 */
public class Operations {

    /**
     * This method counts the maximum common divisor.
     *
     * @param firstNumber  - the first positive number
     * @param secondNumber - the second positive number
     * @return the maximum common divisor
     */
    private static int findMaxDivisor(
            int firstNumber, int secondNumber) {
        int[] nod = {firstNumber, secondNumber};
        int temp;
        do {
            temp = nod[0] % nod[1];
            nod[0] = nod[1];
            nod[1] = temp;
        } while (temp != 0);
        return nod[0];
    }

    /**
     * This method counts the minimum multiple.
     * @param firstNumber  - the first positive number
     * @param secondNumber - the second positive number
     * @return
     */
    static int minMultipleCount(int firstNumber, int secondNumber) {
        return (firstNumber * secondNumber
                / findMaxDivisor(firstNumber, secondNumber));
    }

}
