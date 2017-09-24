public class MaxDivisor {
    public static int findMaxDivisor (Integer firstNumber, Integer secondNumber) {
      int [] nod = {firstNumber, secondNumber};
      int temp;
      do {
          temp = nod[0] % nod [1];
          nod [0] = nod [1];
          nod [1] = temp;
      } while (temp != 0);
      return nod[0];

    }

}
