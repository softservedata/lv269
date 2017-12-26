package com.softserve.edu.opencart.tools;

import org.testng.Assert;

public final class FlexAssert {
    private final String APPEND_TEXT = "\nDescription: %s";
    private final String APPEND_STACK_TRACE_ELEMENT = "\nat %s";
    private final String ERROR_ASSERT_MESSAGE = "\n%s%s";
    private final String NEW_LINE = "\n";
    private final String BREAK_LINE = "<BR>";

    //
    private boolean summaryResult;
    private StringBuilder summaryDescription;
    private ReporterWrapper reporterWrapper;

    public FlexAssert(ReporterWrapper reporterWrapper) {
        initResult();
        initReport(reporterWrapper);
    }

    public void initResult() {
        this.summaryResult = true;
        this.summaryDescription = new StringBuilder();
    }

    private void initReport(ReporterWrapper reporterWrapper) {
        this.reporterWrapper = reporterWrapper;
    }

    public boolean getPassed() {
        return summaryResult;
    }

    public String getSummaryDescription() {
        return summaryDescription.toString();
    }

    private void verify(boolean pass, String errorText) {
        //System.out.println("\t+++ pass = " + pass + "  errorText = " + errorText);
        summaryResult = summaryResult && pass;
        if (!pass) {
            reporterWrapper.error(errorText.replaceAll(NEW_LINE, BREAK_LINE));
            reporterWrapper.addHtmlSourceCode();
            reporterWrapper.addScreenShot();
            addWarning(errorText);
        }
    }

    private void addWarning(String warningText) {
        summaryDescription.append(String.format(APPEND_TEXT, warningText));
    }

    private String getStackTrace() {
        StringBuilder stackTrace = new StringBuilder();
        // get Stack Trace
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (int i = 3; i < stackTraceElements.length; i++) {
            //System.out.println("\nClass: " + stackTraceElements[i].getClassName());
            //System.out.println("Method: " + stackTraceElements[i].getMethodName());
            //System.out.println("Line: " + stackTraceElements[i].getLineNumber());
            //System.out.println("ALL: " + stackTraceElements[i].toString());
            stackTrace.append(String.format(APPEND_STACK_TRACE_ELEMENT,
                    stackTraceElements[i].toString()));
        }
        return stackTrace.toString();
    }

    public void assertEquals(String actual, String expected) {
        try {
            Assert.assertEquals(actual, expected);
        } catch (AssertionError e) {
            //System.out.println("\t***** e.toString() = " + e.toString());
            verify(actual.equals(expected), String.format(ERROR_ASSERT_MESSAGE,
                    e.toString(), getStackTrace()));
        }
    }
    
    public void assertEquals(Double actual, Double expected, String message) {
        try {
            Assert.assertEquals(actual, expected, 0.001, message);
        } catch (AssertionError e) {
            //System.out.println("\t***** e.toString() = " + e.toString());
            verify(actual.equals(expected), String.format(ERROR_ASSERT_MESSAGE,
                    e.toString(), getStackTrace()));
        }
    }
    
    public void assertEquals(Integer actual, Integer expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            //System.out.println("\t***** e.toString() = " + e.toString());
            verify(actual.equals(expected), String.format(ERROR_ASSERT_MESSAGE,
                    e.toString(), getStackTrace()));
        }
    }

    public void assertTrue(boolean condition) {
        try {
            Assert.assertTrue(condition);
        } catch (AssertionError e) {
            verify(condition, String.format(ERROR_ASSERT_MESSAGE,
                    e.toString(), getStackTrace()));
        }
    }
    
    public void assertTrue(boolean condition, String message) {
        try {
            Assert.assertTrue(condition, message);
        } catch (AssertionError e) {
            verify(condition, String.format(ERROR_ASSERT_MESSAGE,
                    e.toString(), getStackTrace()));
        }
    }

    public void assertAll() {
        boolean result = getPassed();
        String description = getSummaryDescription();
        //System.out.println("\n++++++++++\n" + description + "\n++++++++++\n");
        initResult();
        if (!result) {
            throw new AssertionError(description);
        }
        //Assert.assertTrue(result, description);
    }

}
