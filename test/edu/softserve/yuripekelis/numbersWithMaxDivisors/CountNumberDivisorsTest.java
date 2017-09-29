package edu.softserve.yuripekelis.numbersWithMaxDivisors;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountNumberDivisorsTest {
    @Test
    public void countDivisors() throws Exception {
        int testNumber = 20;
        int expectedResult = 6;

        int realResult = CountNumberDivisors.countDivisors(testNumber);

        Assert.assertEquals(realResult, expectedResult);
    }
}