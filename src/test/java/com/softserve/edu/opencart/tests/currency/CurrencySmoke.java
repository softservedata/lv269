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
public class CurrencySmoke {

	@BeforeClass
	public void beforeClass() {
		Application.get(ApplicationSourceRepository.get().chromeServer7());
		//Application.get(ApplicationSourceRepository.get().firefoxServer7());
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Application.remove();
	}
	
	@Test
	public void enableCurrency() {
		Assert.assertTrue(Application.get().loadHomePage().getCurrency().isEnabled(), "Element 'Currency' not found!");
	}
	
	@Test
	public void enableCurrencyOptions() {
		Assert.assertTrue(!Application.get().loadHomePage().getCurrencyOptions().isEmpty(), "Options of 'Currency' not found!");
	}
	
}
