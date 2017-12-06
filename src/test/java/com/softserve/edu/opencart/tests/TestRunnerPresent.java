package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tools.ReporterWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class TestRunnerPresent extends TestRunner {

    @Override
    @BeforeClass
    public void beforeClass(ITestContext context) {
        logger.info("@BeforeClass for " + this.getClass().getName());
        //System.out.println("@BeforeClass");
        //
        Application.get(ApplicationSourceRepository.get().chromePresentServer7());
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
}
