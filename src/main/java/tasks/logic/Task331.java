package tasks.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for task 331.
 */
public class Task331 {
    /*Дано натуральное число n. Можно ли представить его в виде суммы трех квадратов натуральных
    чисел? Если можно, то указать тройку x, y, z таких натуральных чисел,
    что n = x^2 + y^2 + z^2.*/

    /**
     * Calculation method.
     *
     * @param n
     */
    public List<Integer[]> calc(int n) {

        ArrayList<Integer[]> rez = new ArrayList<Integer[]>();
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= x; y++) {
                for (int z = 1; z <= y; z++) {
                    if (((x * x) + (y * y) + (z * z)) == n) {
                        rez.add(new Integer[]{x, y, z});
                    }
                }
            }
        }
        return rez;
    }
}
