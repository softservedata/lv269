package tasks.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for task 554.
 */
public class Task554 {

    /* Given a natural number n. Get all Pythagorean triples of natural numbers, each of which
     does not exceed n; all such triples of natural numbers a, b, c such that
     a ^ 2 + b ^ 2 = c ^ 2 (a <= b <c <= n). */

    /**
     * Calculation method.
     *
     * @param n
     */
    public List<ArrayObject> calc(int n) {

        List<ArrayObject> rez = new ArrayList<ArrayObject>();
        for (int c = 1; c <= n; c++) {
            for (int a = 1; a <= c; a++) {
                for (int b = 1; b <= a; b++) {
                    if (((a * a) + (b * b)) == (c * c)) {
                        rez.add(new ArrayObject(a, b, c));
                    }
                }
            }
        }
        return rez;
    }
}
