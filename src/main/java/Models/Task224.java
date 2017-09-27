package Models;

import java.util.ArrayList;

/*-
 *224. Дано натуральное число n. Получить все его натуральные
 делители.
 */
public class Task224 extends TaskModel {


    public ArrayList<Integer> numberOperation(Integer number) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                arrayList.add(i);
            }

        }
        return arrayList;

    }

}
