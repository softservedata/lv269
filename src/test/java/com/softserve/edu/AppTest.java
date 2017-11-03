package com.softserve.edu;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testApp() {
        System.out.println("surefire.reports.directory = "
                + System.getProperty("surefire.reports.directory"));
        System.out.println("selenium-version = "
                + System.getProperty("selenium-version"));
        //
        Assert.assertTrue(true);
    }

}
