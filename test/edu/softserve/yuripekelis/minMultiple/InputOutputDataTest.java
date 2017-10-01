package edu.softserve.yuripekelis.minMultiple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;


public class InputOutputDataTest {

    private InputFromSourceStub inputFromParameters;
    private InputOutputData inputOutputData;


    @Before
    public void preparation() {
        inputFromParameters = new InputFromSourceStub();
        inputOutputData = new InputOutputData(inputFromParameters);
    }

    @Test
    public void getNumber() throws Exception {
        String inputString = "56";
        int expectedResult = Integer.parseInt(inputString);

        inputFromParameters.setParameters(inputString);
        int realResult = inputOutputData.getNumberFromSource("test question");
        Assert.assertEquals(realResult, expectedResult);

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