package com.softserve.edu.opencart.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.categories.CurrencyRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tools.ReporterWrapper;

public abstract class CurrencyTestRunner {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected ReporterWrapper reporter;
    
    protected final String PRICES_NOT_EQUALS = "Prices not equals:";
    
//    @BeforeSuite
//    public void beforeSuite() {
//    	logger.info("@BeforeSuite for " + this.getClass().getName());
//    	Application.get(ApplicationSourceRepository.get().chromeImplicitServer7());
//    	reporter = Application.get().reporter();
//    }
    
//  @AfterSuite
//  public void afterSuite() {
//  	logger.info("@AfterSuite for " + this.getClass().getName());
//      Application.remove();
//  }
    
    @BeforeClass
    public void beforeClass() {
    	logger.info("@BeforeClass for " + this.getClass().getName());
    	Application.get(ApplicationSourceRepository.get().chromeImplicitServer7());
        Application.get().loadHomePage().chooseCurrencyByDetailCategory(CurrencyRepository.get().dollar());
    	reporter = Application.get().reporter();
    }

    @AfterClass
    public void afterClass() {
        logger.info("@AfterClass for " + this.getClass().getName());
        Application.remove();
    }

}
