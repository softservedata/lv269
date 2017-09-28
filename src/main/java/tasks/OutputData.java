package tasks;

import java.util.Collections;
import java.util.List;

/**
 * Class for output data.
 */
public class OutputData {

    /**
     * Output data to console.
     */
    void outputToConsole(String s) {
        System.out.println(s);
    }

    void outputToConsole(List<Integer[]> s) {
        if (s.size() == 0) {
            System.out.println("It is no possible.");
        } else {
            for (Integer[] mas : s) {
                System.out.println(mas[1] + " " + mas[2] + " " + mas[3]);
            }
        }
    }
}
