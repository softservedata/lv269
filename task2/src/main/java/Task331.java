import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task331 {
    /*Дано натуральное число n. Можно ли представить его в виде суммы трех квадратов натуральных
    чисел? Если можно, то указать тройку x, y, z таких натуральных чисел,
    что n = x^2 + y^2 + z^2.*/

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the natural number. Enter 'q' for the exit");
        while (true) {
            String s = reader.readLine();
            if (s.equals("q")) break;
            int n = Integer.parseInt(s);

            int count = 0;

            for (int x = 1; x <= n; x++) {
                for (int y = 1; y <= x; y++) {
                    for (int z = 1; z <= y; z++) {
                        if (x * x + y * y + z * z ==n) {
                            System.out.println(x + " " + y + " " + z);
                            count++;
                        }
                    }
                }
            }

            if (count == 0) System.out.println("It is no possible.");

        }
    }
}
