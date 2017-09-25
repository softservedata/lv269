import java.util.Scanner;

public class InputNumbers {

    private Scanner scanner;

    InputNumbers () {
         scanner = new Scanner(System.in);
    }

    public int getNumber (String question) {
        int number = 0;
        System.out.println(question);
        try {
            if (scanner.hasNext())
                number=Integer.parseInt(scanner.next());

        } catch (NumberFormatException e) {
            System.out.println("Input numbers next time");
            System.exit(1);
        }
        return number;
    }

    public void closeScanner () {
        scanner.close();
    }
}
