package edu.softserve.yuripekelis.minMultiple;

/**
 * This class is for calculation of the maximum divisor for 2 numbers,
 * using Euclid`s algorithm.
 */
class MaxDivisor {

    /**
     * This method counts the maximum common divisor.
     *
     * @param firstNumber  - the first number
     * @param secondNumber - the second entered numbers
     * @return the maximum common divisor
     */
    static int findMaxDivisor(
            Integer firstNumber, Integer secondNumber) {
        int[] nod = {firstNumber, secondNumber};
        int temp;
        do {
            temp = nod[0] % nod[1];
            nod[0] = nod[1];
            nod[1] = temp;
        } while (temp != 0);
        return nod[0];
    }

}
