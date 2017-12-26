package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.db.service.ReviewService;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tools.FlexAssert;
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

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class ATestRunnerReview {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected ReporterWrapper reporter;
    //protected FlexAssert flexAssert;
    protected ReviewService reviewService;

    @BeforeClass
    public void beforeClass(ITestContext context) {
        logger.info("@BeforeClass for " + this.getClass().getName());
        Application.get(ApplicationSourceRepository.get().chromeImplicitServer7WithoutUIWindows());
        reporter = Application.get().reporter();
        //flexAssert = Application.get().flexAssert();

        Application.get().login().gotoLoginForLoginPageToMyAccountPage(UserRepository.get().valid());
        reviewService = new ReviewService();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        logger.info("@AfterClass for " + this.getClass().getName());
        Application.get().logout();
        Application.remove();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        logger.debug("@BeforeMethod for " + this.getClass().getName());
        //flexAssert = Application.get().flexAssert();
        //flexAssert.initResult();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        Reporter.setCurrentTestResult(result);
        logger.debug("@AfterMethod for " + this.getClass().getName());
        //flexAssert.assertAll();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sDate = sdf.format(new Date());
        reviewService.deleteByDay(sDate);
    }

}
