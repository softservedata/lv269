package tasks;

import java.util.List;

/**
 * Class for output data.
 */
public class OutputData {

    /**
     * Output data to console.
     * @param s
     */
    void outputToConsole(String s) {
        System.out.println(s);
    }

    /**
     * Output array data to console.
     * @param arr
     */
    void outputToConsole(List<Integer[]> arr) {
        if (arr.size() == 0) {
            System.out.println("It is no possible.");
        } else {
            for (Integer[] mas : arr) {
                System.out.println(mas[0] + " " + mas[1] + " " + mas[2]);
            }
        }
    }
}
