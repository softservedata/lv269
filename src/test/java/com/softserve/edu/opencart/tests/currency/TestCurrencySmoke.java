package com.softserve.edu.opencart.tests.currency;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tests.TestRunner;


/**
 * @author Yurii Ivanytskyi
 */
public class TestCurrencySmoke extends TestRunner{
	
	private final String ASSERT_MESSAGE = "Web element(s) not found!";
	
	@Test
	public void enableCurrencyTest() {
		logger.info(String.format("Started enableCurrencyTest()"));
        reporter.display(String.format("Started enableCurrencyTest()"));
		Assert.assertTrue(Application.get().loadHomePage().getCurrency().isEnabled(), ASSERT_MESSAGE);
	}
	
	@Test
	public void enableCurrencyOptionsTest() {
		logger.info(String.format("Started enableCurrencyOptionsTest()"));
        reporter.display(String.format("Started enableCurrencyOptionsTest()"));
		Assert.assertTrue(!Application.get().loadHomePage().getCurrencyOptions().isEmpty(), ASSERT_MESSAGE);
	}
	
}
