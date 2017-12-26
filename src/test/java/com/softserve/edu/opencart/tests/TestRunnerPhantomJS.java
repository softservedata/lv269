package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tools.ReporterWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;

public abstract class TestRunnerPhantomJS extends TestRunner{
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected ReporterWrapper reporter;

    // Use, if class Application is not singleton
    // protected Application application;

    @Override
    @BeforeClass
    public void beforeClass(ITestContext context) {
        logger.info("@BeforeTest for " + this.getClass().getName());
        Application.get(ApplicationSourceRepository.get()
                .phantomJSImplicitServer7Windows());
                //.chromeImplicitServer7());
        reporter = Application.get().reporter();
    }

}
