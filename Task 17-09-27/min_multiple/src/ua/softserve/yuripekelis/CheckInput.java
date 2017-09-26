package ua.softserve.yuripekelis;

public class CheckInput {

    /**
     * This method is used for checking typed string
     *
     * @param enteredString - String that has been typed
     * @return number parsed from the string
     * @throws NumberFormatException - if string isn't number
     */
    public static int enteredStringCheck(String enteredString) {
        int number = 0;
        try {
            number = Integer.parseInt(enteredString);
        } catch (NumberFormatException e) {
            System.out.println("Input numbers next time");
            System.exit(1);
        } finally {
            return number;
        }
    }
}
