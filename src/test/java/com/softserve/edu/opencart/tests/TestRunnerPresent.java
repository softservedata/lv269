package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.pages.Application;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

public abstract class TestRunnerPresent extends TestRunner {

    @Override
    @BeforeClass
    public void beforeClass(ITestContext context) {
        logger.info("@BeforeClass for " + this.getClass().getName());
        //System.out.println("@BeforeClass");
        //
        Application.get(ApplicationSourceRepository.get().chromePresentServer7WithoutUIWindows());
//        Application.get(ApplicationSourceRepository.get().chromePresentServer7());
        //Application.get(ApplicationSourceRepository.get().chromeVisibleServer7());
        //Application.get(ApplicationSourceRepository.get().firefoxImplicitServer7());
        //
        //Application.get(ApplicationUtils
        //        .updateAll(ApplicationSourcesRepository.getChromeTraining(), context));
        reporter = Application.get().reporter();
    }

}
