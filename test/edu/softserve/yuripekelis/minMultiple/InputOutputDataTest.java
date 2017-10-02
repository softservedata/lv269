package edu.softserve.yuripekelis.minMultiple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;

/**
 * This class is for testing analyzing entered data.
 */
public class InputOutputDataTest {

    /**
     * This variable is used instead of Scanner class.
     */
    private InputFromSourceStub inputFromStub;

    /**
     * This variable of the class that is being tested.
     */
    private InputOutputData inputOutputData;


    @Before
    public void preparation() {
        inputFromStub = new InputFromSourceStub();
        inputOutputData = new InputOutputData(inputFromStub);
    }

    /**
     * Test when non-negative number was enetered
     *
     * @throws Exception none
     */
    @Test
    public void getNumberIntegerEntered() throws Exception {
        String[] inputData = {"56", "0"};

        int[] expectedResult = {56, 0};

        int realResult;
        for (int i = 0; i < inputData.length; i++) {
            inputFromStub.setParameters(inputData[i]);
            realResult = inputOutputData.getNumberFromSource("test question");
            Assert.assertEquals(realResult, expectedResult[i]);
        }


    }

/*    @Test//(expected = NoSuchElementException.class)
    public void getNumberWhenString() throws Exception {
        String inputString = "5q6";

        inputFromParameters.setParameters(inputString);
        ThreadForRunTestIOData loopedEnter = new ThreadForRunTestIOData(inputOutputData);
        loopedEnter.setPriority(Thread.MIN_PRIORITY);
        ThreadTestingLooped runingTestThread = new ThreadTestingLooped(loopedEnter);
        runingTestThread.setPriority(Thread.MAX_PRIORITY);
        Assert.assertTrue(runingTestThread.isLoopedThreadAlive());
        System.out.println("All Right");
//        loopedEnter.interrupt();
//        InputOutputData inputNumber = new InputOutputData(new ByteArrayInputStream(inputString.getBytes()));
//        inputNumber.getNumberFromSource("input");
//        inputNumber.closeScanner();
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