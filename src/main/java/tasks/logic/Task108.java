package tasks.logic;

/**
 * Class for task 108.
 */
public class Task108 {

    // Given a natural number n. Obtain the smallest number of the form 2 ^ r greater than n.

    /**
     * Calculation method.
     *
     * @param n
     */
    public int calc(int n) {
        int i = 0;
        int rez = 0;

        while (rez <= n) {
            rez = (int) (Math.pow(2, i)+0.5);
            i++;
        }
        return rez;
    }
}
