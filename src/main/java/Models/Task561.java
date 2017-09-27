package Models;

import java.util.ArrayList;
/**
 * 561. Дано натуральное число n. Среди чисел 1, ..., n найти все такие,
 * запись которых совпадает с последними цифрами записи их квадрата
 * (как, например, 62= 36, 252 = 625 и т. д.).
 */
public class Task561 extends TaskModel {

    public ArrayList<Integer> numberOperation(Integer number) {

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for (int i = 0; i <= number; i++) {
            if (returnLastTwoNumbers(i).equals(Integer.valueOf(i))) {
                arrayList.add(i);
            }
        }
        return arrayList;
    }

    private Integer returnLastTwoNumbers(Integer n) {
        String[] nTemp = String.valueOf(n).split("");
        String[] s = String.valueOf(n * n).split("");
        String temp;
        if (nTemp.length < 2) {
            temp = s[s.length - 1];
        } else if (nTemp.length < 3) {
            temp = String.format("%s%s", s[s.length - 2], s[s.length - 1]);
        } else {
            temp = String.format("%s%s", s[s.length - 3], s[s.length - 2], s[s.length - 1]);
        }
        return Integer.valueOf(temp);
    }
}
