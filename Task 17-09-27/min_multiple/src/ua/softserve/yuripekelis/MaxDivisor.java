package ua.softserve.yuripekelis;

public class MaxDivisor {
    /**
     * This method counts the maximum common divisor
     *
     * @param firstNumber, secondNumber entered numbers
     * @return the common divisor
     */
    public static int findMaxDivisor(Integer firstNumber, Integer secondNumber) {
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
