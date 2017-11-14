package com.softserve.edu.Task325.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * 325. Дано натуральное число n. Получить все простые делители этого числа.
 */
public class Task325 extends TaskModel {

    /**
     * @param number
     * @return arrayList of simple divisors for n.
     */
    public List<Integer> numberOperation(Integer number) {
        List<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 2; i <= number; i++) {
            if ((number % i == 0) &&
                    ((Factorial.factorialFromNMinusOne(i) - 1) % i == 0) | ((i * i - 1) % 24) == 0) // Wilson's theorem  ((p-1)! -1)%p==0
            {
                arrayList.add(i);
            }
        }
        return arrayList;

    }

}
