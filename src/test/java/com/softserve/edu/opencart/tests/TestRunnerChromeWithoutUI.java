package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.pages.Application;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

public abstract class TestRunnerChromeWithoutUI extends TestRunner{

    @Override
    @BeforeClass (alwaysRun = true)
    public void beforeClass(ITestContext context) {
        logger.info("@BeforeClass for " + this.getClass().getName());
        Application.get(ApplicationSourceRepository.get().chromeImplicitServer7WithoutUIWindows());
        reporter = Application.get().reporter();
        flexAssert = Application.get().flexAssert();
    }

}
