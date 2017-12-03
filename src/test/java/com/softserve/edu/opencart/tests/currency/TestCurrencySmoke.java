package com.softserve.edu.opencart.tests.currency;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.pages.Application;

/**
 * @author Yurii Ivanytskyi
 */
public class TestCurrencySmoke {
	
	private final String ASSERT_MESSAGE = "Web element(s) not found!";

	@BeforeClass
	public void beforeClass() {
		Application.get(ApplicationSourceRepository.get().chromeImplicitServer7());
//		Application.get(ApplicationSourceRepository.get().firefoxImplicitServer7());
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Application.remove();
	}
	
	@Test
	public void enableCurrencyTest() {
		Assert.assertTrue(Application.get().loadHomePage().getCurrency().isEnabled(), ASSERT_MESSAGE);
	}
	
	@Test
	public void enableCurrencyOptionsTest() {
		Assert.assertTrue(!Application.get().loadHomePage().getCurrencyOptions().isEmpty(), ASSERT_MESSAGE);
	}
	
}
