package com.softserve.edu.Task224.Models;


import java.util.ArrayList;
import java.util.List;

/**
 * 224. Дано натуральное число n. Получить все его натуральные
 * делители.
 */
public class Task224 extends TaskModel {

    /**
     * @param number
     * @return arrayList of natural divisors for n.
     */

    public List<Integer> numberOperation(Integer number) {
        List<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                arrayList.add(i);
            }

        }
        return arrayList;

    }

}
