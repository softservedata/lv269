package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.pages.Application;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

public abstract class TestRunnerFireFox extends TestRunner {

    @Override
    @BeforeClass
    public void beforeClass(ITestContext context) {
        logger.info("@BeforeClass for " + this.getClass().getName());

        //
        Application.get(ApplicationSourceRepository.get().firefoxImplicitServer7());
        //Application.get(ApplicationSourceRepository.get().chromeVisibleServer7());
        Application.get(ApplicationSourceRepository.get().firefoxImplicitServer7());

        reporter = Application.get().reporter();
    }

}
