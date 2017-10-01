package tasks.dataInputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Class for input and output data.
 */
public class InputOutputDataFromConsole {

    /**
     * Input data from console.
     *
     * @return
     * @throws IOException
     */
    public int inputFromConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        outputToConsole("Enter the natural number.");
        String s = reader.readLine();
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            outputToConsole("Something wrong with you number. Try again.");
            return inputFromConsole();
        }
    }

    /**
     * Output data to console.
     *
     * @param s
     */
    public void outputToConsole(String s) {
        System.out.println(s);
    }

    /**
     * Output array data to console.
     *
     * @param arr
     */
    public void outputToConsole (List<Integer[]> arr) {
        if (arr.size() == 0) {
            outputToConsole("It is no possible.");
        } else {
            for (Integer[] mas : arr) {
                System.out.println(mas[0] + " " + mas[1] + " " + mas[2]);
            }
        }
    }
}
