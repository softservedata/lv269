package tasks.logic;

/**
 * Class for task 108.
 */
public class Task108 {
    //Дано натуральное число n. Получить наименьшее число вида 2^r, превосходящее n.

    /**
     * Calculation method.
     *
     * @param n
     */
    public int calc(int n) {
        int i = 0;
        int x = (int) Math.pow(2, i);

        while (x <= n) {
            x = (int) Math.pow(2, i);
            i++;
        }
        return x;
    }
}
