package task1.numbersWithMaxSumDivisors;

import org.junit.Assert;
import org.junit.Test;

public class CountNumberDivisorsTest {
    @Test
    public void countDivisors() throws Exception {
        /*
        The first element in a row - input data;
        The second element - expected result.
        */
        /*
        Every row is a test case. Description of cases:
        1 - a regular positive number;
        2 - a prime integer;
        3 - a number that has a divisor and its power of a number (e.g.  powers
            of two);
        4 - number is 0.
         */

        int[][] testNumber = {{20, 42}, {13, 14}, {16, 31}, {0, 0}};

        int realResult;
        for (int i = 0; i < testNumber.length; i++) {
            realResult = CountDivisorsSum.countDivisorsSum(testNumber[i][0]);
            Assert.assertEquals(testNumber[i][1], realResult);
        }


    }
}