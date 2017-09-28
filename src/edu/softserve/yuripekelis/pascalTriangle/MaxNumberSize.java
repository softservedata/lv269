package edu.softserve.yuripekelis.pascalTriangle;

/**
 * This utility is for searching the biggest element in triangle and
 * returning its size.
 */
class MaxNumberSize {

    /**
     * This method calculates digits of the biggest element in triangle's array.
     * @param pascalTriangleArray - array with the Pascal triangle
     * @param rowsQuantity - number of rows for printing
     * @return the biggest number's size in the triangle
     */
    static int countMaxNumberSize(PascalTriangleArray pascalTriangleArray,
                                  int rowsQuantity) {
        int maxElement = 0;
        for (int j = 0; j < (rowsQuantity * 2 - 1); j++) {
            if (pascalTriangleArray.
                    getElement(rowsQuantity - 1, j) > maxElement) {
                maxElement = pascalTriangleArray.
                        getElement(rowsQuantity - 1, j);
            }
        }
        return String.valueOf(maxElement).length();
    }
}
