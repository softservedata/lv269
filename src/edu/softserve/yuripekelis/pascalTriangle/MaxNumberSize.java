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
    public static int countMaxNumberSize(IPascalTriangleArray pascalTriangleArray) {
        int rowsQuantity = pascalTriangleArray.getRowsQuantity();
        int maxElement = pascalTriangleArray.getElement(rowsQuantity - 1, (rowsQuantity/2)*2);
        return String.valueOf(maxElement).length();
    }
}
