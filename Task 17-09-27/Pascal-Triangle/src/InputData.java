import java.util.Scanner;

public class InputData {
    private Scanner scanner;

    InputData () {
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
        if (number <= 0) {
            System.out.println("Numbers must be positive!");
            System.exit(2);
        }
        scanner.close();
        return number;
    }
}


