package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class for input data.
 */
public class InputData {

    /**
     * Input data from console.
     *
     * @return
     * @throws IOException
     */
    int inputFromConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the natural number.");
        String s = reader.readLine();
        return Integer.parseInt(s);
    }
}
