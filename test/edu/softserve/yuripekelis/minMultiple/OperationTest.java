package edu.softserve.yuripekelis.minMultiple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This class is for testing Operations class.
 */
public class OperationTest {

    OperationsWithNumbers operationsWithNumbers;

    @Before
    public void createOperations() {
        operationsWithNumbers = new OperationsWithNumbers();
    }

    /**
     * This test for testing positive cases for the method, that calculate
     * a minimal multiple. Also it tests private method findMaxDivisor that
     * counts a maximal divisor for two non-negative numbers.
     *
     * @throws Exception - none
     */
    @Test
    public void findMaxDivisor() throws Exception {
        /* The first element in every row - the first entered number
         The second element in every row - the second entered number
          The third element in every row - expected result
        */
        /* Description of taken input data:
        * 1 - 2 numbers, that have the least common multiple less than
        *     their multiplication
        * 2 - 2 numbers, that have the least common multiple equal to
        *      their multiplication
        * 3 - one of the number is a divisor of other
        * 4 - 2 equal positive numbers
        * 5 - first number 0, second positive number
        * 6 - first number positive, second number - 0
        * 7 - both numbers 0
        */
        int[][] inputData = {{20, 30, 60}, {13, 7, 91}, {21, 42, 42},
                {50, 50, 50}, {0, 8, 0}, {8, 0, 0}, {0, 0, 0}};
        int realResult;
        for (int i = 0; i < inputData.length; i++) {
            realResult = operationsWithNumbers.minMultipleCount(
                    inputData[i][0], inputData[i][1]);
            Assert.assertEquals(realResult, inputData[i][2]);
        }
    }
}