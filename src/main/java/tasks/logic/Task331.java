package tasks.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for task 331.
 */
public class Task331 {

    /* Given a natural number n. Can I imagine it as a sum of three squares of natural
     numbers? If it is possible, then indicate the triplet x, y, z of such natural numbers,
     that n = x ^ 2 + y ^ 2 + z ^ 2. */

    /**
     * Calculation method.
     *
     * @param n
     */
    public List<ArrayObject> calc(int n) {

        List<ArrayObject> rez = new ArrayList<ArrayObject>();
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= x; y++) {
                for (int z = 1; z <= y; z++) {
                    if (((x * x) + (y * y) + (z * z)) == n) {
                        rez.add(new ArrayObject(x, y, z));
                    }
                }
            }
        }
        return rez;
    }
}
