package edu.softserve.yuripekelis.minMultiple;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;

import static org.junit.Assert.fail;


public class InputNumberTest {

    @Test //(expected = IllegalStateException.class)
    public void getNumber() throws Exception {
        String inputString = "56";
        int expectedResult = Integer.parseInt(inputString);

        InputNumber inputNumber = new InputNumber(new ByteArrayInputStream(inputString.getBytes()));
        int realResult = inputNumber.getNumber("input");

        Assert.assertEquals(realResult, expectedResult);

        inputNumber.closeScanner();
        try {
            inputNumber.getNumber("input");
            fail ();
        } catch (IllegalStateException e) {
            Assert.assertTrue(e.getMessage().contains( "Scanner closed"));
        }
    }

    @Test (expected = NoSuchElementException.class)
    public void getNumberWhenString() throws Exception {
        String inputString = "5q6";

        InputNumber inputNumber = new InputNumber(new ByteArrayInputStream(inputString.getBytes()));
        inputNumber.getNumber("input");
        inputNumber.closeScanner();
    }

//    @Rule
//    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

//    @Test
/*    Test for System Exit (1)
    public void getNumberWhenQuit() throws Exception {
        String inputString = "quit";
        InputNumber inputNumber = new InputNumber(new ByteArrayInputStream(inputString.getBytes()));
        NoExitTestCase noExitTestCase = new NoExitTestCase();
        noExitTestCase.testExit(inputNumber);
    } */
//    public void systemExitWithArbitraryStatusCode() {
//        ExpectedSystemExit exit = ExpectedSystemExit.none();
//        exit.expectSystemExit();
//        System.exit(0);
//    }


}