package tasks;

import java.io.IOException;

/**
 * Class for task 554.
 */
public class Task554 {
    /*Дано натуральное число n. Получить все пифагоровы тройки натуральных чисел, каждое из которых
    не превосходит n, т.е. все такие тройки натуральных чисел a, b, c, что
    а^2 + b^2 = с^2 (а<=b<=c<=n).*/

    /**
     * Calculation method.
     * @param n
     * @throws IOException
     */
    public void calc (int n) throws IOException {

            int count = 0;
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    for (int c = 1; c <= n; c++) {
                        if (a * a + b * b == c * c) {
                            System.out.println(a + " " + b + " " + c);
                            count++;
                        }
                    }
                }
            }

            if (count == 0) System.out.println("It is no possible.");
        }

}
