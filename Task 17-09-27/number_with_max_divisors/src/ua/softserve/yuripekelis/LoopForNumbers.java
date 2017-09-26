package ua.softserve.yuripekelis;

import java.util.ArrayList;

public class LoopForNumbers {
    /**
     * This class organizes loop from 0 to maxNumber, it calls CountNumberDivisors class to count
     * number of divisors for the current number. It changes resulted Arrays, according to the results.
     * @param maxNumber - the maximum number which is upper range for the loop
     * @param numbersWithMaxDivisors - Array saves numbers with maximum divisors
     * @return  maxDivisors - saves maximum quantity of divisors                             ret
     */
    public static int loopForNumbers(int maxNumber , ArrayList<Integer> numbersWithMaxDivisors) {
        /* every number has 2 divisors - 1 and number */
        int maxDivisors = 2;
        for (int i = maxNumber / 2; i < maxNumber; i++) {
            int divisorsForThisNumber = CountNumberDivisors.countDivisors(i);
            if (divisorsForThisNumber > maxDivisors) {
                maxDivisors = divisorsForThisNumber;
                numbersWithMaxDivisors.clear();
            }
            if (divisorsForThisNumber == maxDivisors) {
                numbersWithMaxDivisors.add(i);
            }
        }
        return maxDivisors;
    }
}
