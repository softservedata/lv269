package tasks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class for task 554.
 */
public class Task554 {
    /*Дано натуральное число n. Получить все пифагоровы тройки натуральных чисел, каждое из которых
    не превосходит n, т.е. все такие тройки натуральных чисел a, b, c, что
    а^2 + b^2 = с^2 (а<=b<=c<=n).*/

    /**
     * Calculation method.
     *
     * @param n
     * @throws IOException
     */
    public List<Integer[]> calc(int n) throws IOException {

        ArrayList<Integer[]> rez = new ArrayList<Integer[]>();
        for (int c = 1; c <= n; c++) {
            for (int a = 1; a <= c; a++) {
                for (int b = 1; b <= a; b++) {
                    if (((a * a) + (b * b)) == (c * c)) {
                        rez.add(new Integer[]{a, b, c});
                    }
                }
            }
        }

        return rez;
    }

}
