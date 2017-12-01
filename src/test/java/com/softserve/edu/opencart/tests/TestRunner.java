package com.softserve.edu.opencart.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tools.ReporterWrapper;

public abstract class TestRunner {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected ReporterWrapper reporter;

    // Use, if class Application is not singleton
    // protected Application application;
    
    @BeforeClass
    public void beforeClass(ITestContext context) {
        logger.info("@BeforeClass for " + this.getClass().getName());
        //System.out.println("@BeforeClass");
        //
        Application.get(ApplicationSourceRepository.get().chromeImplicitServer7());
        //Application.get(ApplicationSourceRepository.get().chromeVisibleServer7());
        //Application.get(ApplicationSourceRepository.get().firefoxImplicitServer7());
        //
        //Application.get(ApplicationUtils
        //        .updateAll(ApplicationSourcesRepository.getChromeTraining(), context));
        reporter = Application.get().reporter();
    }

    @AfterClass
    public void afterClass() {
        logger.info("@AfterClass for " + this.getClass().getName());
        //System.out.println("@AfterClass");
        //
        Application.remove();
    }

    @BeforeMethod
    public void beforeMethod() {
        logger.debug("@BeforeMethod for " + this.getClass().getName());
        //logger.info("@BeforeMethod for " + this.getClass().getName());
        //System.out.println("@BeforeMethod");
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        Reporter.setCurrentTestResult(result);
        logger.debug("@AfterMethod for " + this.getClass().getName());
        //logger.info("@AfterMethod for " + this.getClass().getName());
        //System.out.println("@AfterMethod");
    }

}
