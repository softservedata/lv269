package edu.softserve.yuripekelis.minMultiple;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class minMultiple {

    @Test
    public void findMaxDivisor() throws Exception {
        int[][] inputData = {{20, 30, 60}, {13, 7, 91}, {50, 50, 50},
                {0, 8, 1}, {8, 0, 1}};
        int realResult;
        for (int i = 0; i < inputData[0].length; i++) {
            realResult = Operations.minMultipleCount(inputData[i][0],
                    inputData[i][1]);
            Assert.assertEquals(realResult, inputData[i][2]);
        }
    }
}