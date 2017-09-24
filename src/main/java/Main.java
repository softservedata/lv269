public class Main {
    public static void main(String[] args) {
        NaturalNumberWorks naturalNumberWorks = new NaturalNumberWorks();
        naturalNumberWorks.soutArraylist(naturalNumberWorks.findNaturalDel(48));
        System.out.println("------------------------------");
        naturalNumberWorks.soutArraylist(naturalNumberWorks.findSimpleDel(52611));
        System.out.println("------------------------------");
        naturalNumberWorks.soutArraylist(naturalNumberWorks.findAllNumbersWherePowLast(999));
    }
}
