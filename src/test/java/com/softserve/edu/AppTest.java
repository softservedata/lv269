package com.softserve.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static final Logger logger = LoggerFactory.getLogger(AppTest.class);
    private boolean isTestComplete;

    //@Test
    public void testApp1() {
        System.out.println("surefire.reports.directory = "
                + System.getProperty("surefire.reports.directory"));
        System.out.println("selenium-version = "
                + System.getProperty("selenium-version"));
        //
        Assert.assertTrue(true);
    }

    @BeforeMethod
    public void setUp() throws Exception {
        System.out.println("CalcTest @Before setUp()");
        isTestComplete = false;
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        Reporter.setCurrentTestResult(result);
        System.out.println("CalcTest @After tearDown()");
        Reporter.log("<BR><FONT SIZE='4' COLOR='RED'>@AfterMethod Non Conditional.</FONT><BR>",true);
        Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>@AfterMethod Level 3</FONT><BR>",3,true);
        Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>@AfterMethod Level 5</FONT><BR>",5);
        Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>@AfterMethod Level 7</FONT><BR>",7,true);
        if (!isTestComplete) {
            Reporter.log("<BR><BR><FONT SIZE='4' COLOR='BLUE'>ALARM TEST FAIL</FONT><BR>",true);    
        }
    }

    @Test
    public void testApp2() {
        Reporter.log("<BR><FONT SIZE='4' COLOR='RED'>Non Conditional.</FONT><BR>",true);
        Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>Level 3</FONT><BR>",3,true);
        Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>Level 5</FONT><BR>",5);
        Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>Level 7</FONT><BR>",7,true);
        System.out.println("Running . . .");
//      ReporterWrapper.get().debug("DEBUG - messages");
//      ReporterWrapper.get().info("INFO - messages");
//      ReporterWrapper.get().warning("WARNING - messages");
//      ReporterWrapper.get().error("ERROR - messages");
        //Assert.assertTrue(false);
        Assert.assertTrue(true);
        isTestComplete = true;
    }
    
    @Test
    public void testApp3() {
        logger.info("\t+++testApp3() DONE");
        Reporter.log("\t+++testApp3() must be", true);
        Reporter.log("\t+++testApp3() 3", 3, true);
        Reporter.log("\t+++testApp3() 5", 5, true);
        Reporter.log("\t+++testApp3() 7", 7, true);
        Reporter.log("\t+++testApp3() 9", 9, true);
        System.out.println("\t+++testApp3() DONE");
        //WebDriver driver = new HtmlUnitDriver();
        isTestComplete = true;
    }

}
