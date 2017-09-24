import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        int maxNumber = 10000, maxDivisors=0, divisorsForThisNumber;
        ArrayList <Integer> numbersWithMaxDivisors = new ArrayList<>();
        for (int i = maxNumber/2; i < maxNumber; i++) {
            divisorsForThisNumber = 2;
            for (int j=2; j < i; j++)
                if (i % j == 0)
                    divisorsForThisNumber ++;

            if (divisorsForThisNumber > maxDivisors) {
                maxDivisors = divisorsForThisNumber;
                numbersWithMaxDivisors.clear();
            }
            if (divisorsForThisNumber == maxDivisors)
                numbersWithMaxDivisors.add(i);
        }
        System.out.print("Between numbers from 0 to " + maxNumber);
        System.out.print(" the winner");
        if (numbersWithMaxDivisors.size() == 1)
            System.out.print(" is ");
        else
            System.out.print("s are");
        for (Integer number: numbersWithMaxDivisors) {
            System.out.print(number + " ");
        }
        System.out.println("with " + maxDivisors + " divisors.");
    }
}
