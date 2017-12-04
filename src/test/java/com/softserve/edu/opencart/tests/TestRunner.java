package com.softserve.edu.opencart.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.categories.CurrencyRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tools.ReporterWrapper;

public abstract class TestRunner {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected ReporterWrapper reporter;

    // Use, if class Application is not singleton
    // protected Application application;
    
    @BeforeSuite
    public void beforeSuite() {
    	logger.info("@BeforeClass for " + this.getClass().getName());
    	Application.get(ApplicationSourceRepository.get().chromeImplicitServer7());
    	reporter = Application.get().reporter();
    }
    
    @BeforeClass
    public void beforeClass() {
        logger.info("@BeforeClass for " + this.getClass().getName());
        Application.get().loadHomePage().chooseCurrencyByDetailCategory(CurrencyRepository.get().dollar());
        reporter = Application.get().reporter();
    }

    @AfterClass
    public void afterClass() {
        logger.info("@AfterClass for " + this.getClass().getName());
//        Application.remove();
    }
    
    @AfterSuite
    public void afterSuite() {
    	logger.info("@AfterClass for " + this.getClass().getName());
        Application.remove();
    }

//    @BeforeMethod
//    public void beforeMethod() {
//        logger.debug("@BeforeMethod for " + this.getClass().getName());
//    }
//
//    @AfterMethod
//    public void afterMethod(ITestResult result) {
//        Reporter.setCurrentTestResult(result);
//        logger.debug("@AfterMethod for " + this.getClass().getName());
//    }

}
