package Models;

public class Factorial {

    public static Integer factorial(Integer number) {
        Integer n = 1;
        for (int i = 1; i < number - 1; i++) {
            n *= i;
        }
        return n;
    }
}

