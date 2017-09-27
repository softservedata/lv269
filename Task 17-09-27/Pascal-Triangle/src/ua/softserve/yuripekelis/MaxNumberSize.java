package ua.softserve.yuripekelis;

/**
 * This utility is for searching the biggest element in triangle and
 * returning its size.
 */
final class MaxNumberSize {
    /**
     * The blank constructor.
     */
    private MaxNumberSize() {
    }

    /**
     * This method calculates digits of the biggest element in triangle's array.
     * @param pascalTriangleArray - array with the Pascal triangle
     * @param rowsQuantity - number of rows for printing
     * @return the biggest number's size in the triangle
     */
    static int countMaxNumberSize(final PascalTriangleArray pascalTriangleArray,
                                  final int rowsQuantity) {
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
