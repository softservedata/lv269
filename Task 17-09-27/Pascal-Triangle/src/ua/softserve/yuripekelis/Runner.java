/*
 * <h1>Pascal triangle print.</h1>
 * Pascal triangle print program implements an application that
 * prints the preset rows of the Pascal triangle.
 *
 * @author Yuri Pekelis
 * @version 1.01
 * @since 2017-09-21
 */
package ua.softserve.yuripekelis;

/**
 * This class is for running Software.
 */
final class Runner {
    /**
     * The blank constructor.
     */
    private Runner() {
    }

    /**
     * The constant with text for the entering number of rows.
     */
    private static final String ENTER_ROWS_TEXT
            = "Enter number of rows to show:";

    /**
     * This is the main method which makes use of calculation of
     * multiply method.
     *
     * @param args Unused.
     */
    public static void main(final String[] args) {
        InputData inputData = new InputData();
        int numberRows = DataCheck.dataCheck(inputData.getText(
                ENTER_ROWS_TEXT));
        PascalTriangleArray pascalTriangleArray = new PascalTriangleArray(
                numberRows);
        int maxNumberSize = MaxNumberSize.countMaxNumberSize(
                pascalTriangleArray, numberRows);
        pascalTriangleArray.printTriangle(maxNumberSize);
        inputData.closeScanner();
    }
}
