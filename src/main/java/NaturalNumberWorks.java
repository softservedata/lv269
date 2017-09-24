import java.util.ArrayList;

public class NaturalNumberWorks {
    public ArrayList<Integer> findNaturalDel(Integer number) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                arrayList.add(i);
            }

        }
        return arrayList;

    }

    public ArrayList<Integer> findSimpleDel(Integer number) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 2; i <= number; i++) {
            if ((number % i == 0) && ((factorial(i) - 1) % i == 0)|((i*i-1)%24)==0 ) // Wilson's theorem  ((p-1)! -1)%p==0
            {
                arrayList.add(i);
            }

        }
        return arrayList;

    }

    public Integer factorial(Integer number) {
        Integer n = 1;
        for (int i = 1; i < number - 1; i++) {
            n *= i;
        }
        return n;
    }


    public void soutArraylist(ArrayList arrayList) {
        for (Object o : arrayList) {
            System.out.println(o);
            ;
        }
    }

    public ArrayList findAllNumbersWherePowLast(Integer number) {

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for (int i = 0; i <= number; i++) {

            if (returnLastTwoNumbers(i).equals(Integer.valueOf(i))) {
                arrayList.add(i);
            }


        }

        return arrayList;
    }


    public Integer returnLastTwoNumbers(Integer n) {
        String[] nTemp = String.valueOf(n).split("");
        String[] s = String.valueOf(n * n).split("");
        String temp;
        if (nTemp.length < 2) {
            temp = s[s.length - 1];
        } else if (nTemp.length < 3) {
            temp = String.format("%s%s", s[s.length - 2], s[s.length - 1]);
        } else {
            temp = String.format("%s%s", s[s.length - 3], s[s.length - 2], s[s.length - 1]);
        }


        return Integer.valueOf(temp);
    }

}
