package edu.softserve.yuripekelis.pascalTriangle;

/**
 * This utility is for searching the biggest element in triangle and
 * returning its size (the number of digits).
 */
public class MaxNumberSize {

    /**
     * This method calculates digits of the biggest element in triangle's array.
     *
     * @param pascalTriangleArray - array with the Pascal triangle
     * @return the biggest number's size in the triangle
     */
    public static int countMaxNumberSize(PascalTriangleArray pascalTriangleArray) {
        int rowsQuantity = pascalTriangleArray.getRowsQuantity();
        int maxElement = 0;
        for (int j = (rowsQuantity - 1); j < rowsQuantity; j++) {
            if (pascalTriangleArray.
                    getElement(rowsQuantity - 1, j) > maxElement) {
                maxElement = pascalTriangleArray.
                        getElement(rowsQuantity - 1, j);
            }
        }
        return String.valueOf(maxElement).length();
    }
}
