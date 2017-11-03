package Task325.Services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ConsoleWorker implements InputOutput {
    @Override
    public void printToConsole(List<Integer> arrayList) {
        for (Object o : arrayList) {
            System.out.println(o);
        }
    }

    @Override
    public Integer readFromConsole() throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input natural number");
        try {
            return Integer.valueOf(scanner.readLine());

        } catch (NumberFormatException e) {

            System.out.println("You wrote not a natural number");
            return readFromConsole();
        }
    }
}
