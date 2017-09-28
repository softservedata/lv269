/*
 * <h1>Pascal triangle print.</h1>
 * Pascal triangle print program implements an application that
 * prints the preset rows of the Pascal triangle.
 *
 * @author Yuri Pekelis
 * @version 1.02
 * @since 2017-09-21
 */
package edu.softserve.yuripekelis.pascalTriangle;

import java.io.InputStream;

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
     * This constant shows where data will be entered from.
     */
    public static final InputStream INPUT_STREAM = System.in;

    /**
     * This is the main method which makes use of calculation of
     * multiply method.
     *
     * @param args Unused.
     */
    public static void main(final String[] args) {
        InputNumber inputNumber = new InputNumber(INPUT_STREAM);
        int numberRows = inputNumber.getNumber(ENTER_ROWS_TEXT);
        PascalTriangleArray pascalTriangleArray = new PascalTriangleArray(
                numberRows);
        int maxNumberSize = MaxNumberSize.countMaxNumberSize(
                pascalTriangleArray, numberRows);
        pascalTriangleArray.printTriangle(maxNumberSize);
        inputNumber.closeScanner();
    }
}
