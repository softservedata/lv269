package Task561.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * 561. Дано натуральное число n. Среди чисел 1, ..., n найти все такие,
 * запись которых совпадает с последними цифрами записи их квадрата
 * (как, например, 62= 36, 252 = 625 и т. д.).
 */
public class Task561 extends TaskModel {


    /**
     * @param number
     * @return arrayList of  n, where last digits of square of n equal  n.
     */
    public List<Integer> numberOperation(Integer number) {
        List<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i <= number; i++) {
            if (returnLastTwoNumbers(i).equals(Integer.valueOf(i))) {
                arrayList.add(i);
            }
        }
        return arrayList;
    }

    /**
     * @param n
     * @return This method returns last digits from square n.
     */
    private Integer returnLastTwoNumbers(Integer n) {
        String[] nTemp = String.valueOf(n).split("");
        String[] square = String.valueOf(n * n).split("");
        String temp = "";
        int count;
        if (n >= 0) {
            count = nTemp.length;
        } else {
            count = nTemp.length - 1;
        }
        for (int i = 0; count > i; count--) {
            temp += square[square.length - count];
        }

        return Integer.valueOf(temp);
    }
}
