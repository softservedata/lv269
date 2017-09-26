package ua.softserve.yuripekelis;

public class CountNumberDivisors {

    /**
     * This class counts quantity of divisors for the number
     * @param number which must be counted
     * @return the number of divisors
     */
    public static int countDivisors (int number) {
        int divisorsForThisNumber = 2;
        /* There is no sense to count after number/2 */
        for (int i=2; i<(number/2+1); i++) {
            if (number%i == 0) {
                divisorsForThisNumber++;
            }
        }
        return divisorsForThisNumber;
    }

}
