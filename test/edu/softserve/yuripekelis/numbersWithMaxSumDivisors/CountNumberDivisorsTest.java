package edu.softserve.yuripekelis.numbersWithMaxSumDivisors;

import org.junit.Assert;
import org.junit.Test;

public class CountNumberDivisorsTest {
    @Test
    public void countDivisors() throws Exception {
        int testNumber = 20;

        int expectedResult = 42;

        int realResult = CountDivisorsSum.countDivisorsSum(testNumber);

        Assert.assertEquals(realResult, expectedResult);
    }
}