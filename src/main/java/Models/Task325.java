package Models;

import java.util.ArrayList;

/**
 * 325. Дано натуральное число n. Получить все простые делители этого числа.
 */

public class Task325 extends TaskModel {


    public ArrayList<Integer> numberOperation(Integer number) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 2; i <= number; i++) {
            if ((number % i == 0) &&
                    ((Factorial.factorial(i) - 1) % i == 0) | ((i * i - 1) % 24) == 0) // Wilson's theorem  ((p-1)! -1)%p==0
            {
                arrayList.add(i);
            }
        }
        return arrayList;

    }

}
