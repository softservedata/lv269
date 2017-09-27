package Services;

import java.io.IOException;

public class Input {
    public static Integer input() throws IOException {
        System.out.println("Input natural number");
        try {
            return Integer.valueOf(Scanner.scanner.readLine());

        } catch (NumberFormatException e) {

            System.out.println("You wrote not a natural number");
            return input();
        }

    }
}
