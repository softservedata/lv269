package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tools.ReporterWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

public abstract class TestRunnerPhantomJS {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected ReporterWrapper reporter;
    //protected Application appl;

    // Use, if class Application is not singleton
    // protected Application application;
    
    @BeforeTest
    public void beforeTest(ITestContext context) {
        logger.info("@BeforeTest for " + this.getClass().getName());
        Application.get(ApplicationSourceRepository.get().phantomJSImplicitServer7Windows());
        reporter = Application.get().reporter();
    }

    @AfterTest
    public void afterTest() {
        logger.info("@AfterTest for " + this.getClass().getName());

        Application.remove();
    }

    @BeforeMethod
    public void beforeMethod() {
        logger.debug("@BeforeMethod for " + this.getClass().getName());
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        Reporter.setCurrentTestResult(result);
        logger.debug("@AfterMethod for " + this.getClass().getName());
    }

}
