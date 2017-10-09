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
        InputFromSource inputFromSource = new InputFromSource(INPUT_STREAM);
        InputData inputData = new InputData(inputFromSource);
        int numberRows = inputData.getNumberFromSource(Messages.ENTER_ROWS_TEXT
                .getMessage());
        IPascalTriangleArray pascalTriangleArray = new PascalTriangleArray(
                numberRows);
        int maxNumberSize = MaxNumberSize.countMaxNumberSize(
                pascalTriangleArray);
        pascalTriangleArray.printTriangle(maxNumberSize);
        inputFromSource.closeSource();
    }
}
