package edu.softserve.yuripekelis.minMultiple;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxDivisorTest {
    @Test
    public void findMaxDivisor() throws Exception {
        int first = 20;
        int second = 30;
        int expectedResult = 60;

        int realResult = Operations.minMultipleCount(first, second);

        Assert.assertEquals(realResult, expectedResult);
    }

}