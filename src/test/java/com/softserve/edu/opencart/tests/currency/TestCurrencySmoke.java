package com.softserve.edu.opencart.tests.currency;

import org.testng.annotations.Test;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tests.TestRunner;

import static com.softserve.edu.opencart.tests.TestContextAttributes.ELEMENT_NOT_FOUND;
import static com.softserve.edu.opencart.tests.TestContextAttributes.ENABLE_CURRENCY;

/**
 * @author Yurii Ivanytskyi
 */
public class TestCurrencySmoke extends TestRunner{
	
	@Test
	public void enableCurrencyTest() {
		logger.info(ENABLE_CURRENCY.toString());
        reporter.display(ENABLE_CURRENCY.toString());
        flexAssert.assertTrue(Application.get().loadHomePage().getCurrency().isEnabled(), ELEMENT_NOT_FOUND.toString());
		flexAssert.assertTrue(!Application.get().loadHomePage().getCurrencyOptions().isEmpty(), ELEMENT_NOT_FOUND.toString());
		flexAssert.assertAll();
	}
	
}
