import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task108 {
    //Дано натуральное число n. Получить наименьшее число вида 2^r, превосходящее n.

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the natural number. Enter 'q' for the exit");
        while (true) {
            String s = reader.readLine();
            if (s.equals("q")) break;
            int n = Integer.parseInt(s);
            int i = 0;
            int x = (int) Math.pow(2, i);

            while (x <= n) {
                x = (int) Math.pow(2, i);
                i++;
            }
            System.out.println(x);
        }
    }
}
