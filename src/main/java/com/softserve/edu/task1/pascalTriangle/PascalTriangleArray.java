package com.softserve.edu.task1.pascalTriangle;

/**
 * This class is for creation, filling array of the Pascal
 * triangle and printing it.
 */
public class PascalTriangleArray implements IPascalTriangleArray{

    /**
     * The number of rows. User entered it.
     */
    private int rowsQuantity;

    /**
     * An array with data of Pascal triangle.
     */
    private int[][] pyramid;

    /**
     * A constant with delimiter that fills empty from numbers space.
     */
    private static final String DELIMITER = " ";

    /**
     * This constant is the upper element of the triangles and side ones in
     * every row.
     */
    private static final int SIDE_ELEMENT = 1;

    /**
     * This constant is a shift from the center for working with not side
     * elements.
     */
    private static final int SHIFT = 3;

    /**
     * This constructor makes copy to the field input data, creates array with
     * appropriate size and run a method that fills the array.
     *
     * @param rowsNumber - quantity of rows, that program has to print
     */
    PascalTriangleArray(int rowsNumber) {
        this.rowsQuantity = rowsNumber;
        pyramid = new int[rowsQuantity][rowsQuantity * 2 - 1];
        this.fillTriangle();
    }

    /**
     * This method fill created array.
     */
    private void fillTriangle() {
        pyramid[0][rowsQuantity - 1] = 1;
        if (rowsQuantity > 1) {
            for (int i = 1; i < rowsQuantity; i++) {
                pyramid[i][rowsQuantity - i - 1] = SIDE_ELEMENT;
                pyramid[i][rowsQuantity + i - 1] = SIDE_ELEMENT;
                for (int j = rowsQuantity - i + 1; j <= (
                        rowsQuantity + i - SHIFT); j += 2) {
                    pyramid[i][j] = pyramid[i - 1][j - 1]
                            + pyramid[i - 1][j + 1];
                }
            }
        }
    }

    public int getRowsQuantity() {
        return rowsQuantity;
    }

    /**
     * Returns element that was placed in the given row and column.
     *
     * @param row    - row, where element is placed.
     * @param column - column, where element is placed.
     * @return element
     */
    public int getElement(final int row, final int column) {
        return pyramid[row][column];
    }

    /**
     * Prints created triangle.
     *
     * @param maxElementSize - Quantity of digits in the biggest element
     */
    public void printTriangle(int maxElementSize) {
        /* Element for filling empty places. */
        StringBuilder delimitersGroup = new StringBuilder();
        for (int i = 0; i < maxElementSize; i++) {
            delimitersGroup.append(DELIMITER);
        }

        StringBuilder currentRow = new StringBuilder();
        for (int i = 0; i < rowsQuantity; i++) {
            for (int j = 0; j < rowsQuantity * 2 - 1; j++) {
                if (pyramid[i][j] == 0) {
                    currentRow.append(delimitersGroup);
                } else {
                    for (int k = 0; k < maxElementSize
                            - String.valueOf(pyramid[i][j]).length(); k++) {
                        currentRow.append(DELIMITER);
                    }
                    currentRow.append(pyramid[i][j]);
                }
            }
            System.out.println(currentRow);
            currentRow.setLength(0);
        }

    }
}
