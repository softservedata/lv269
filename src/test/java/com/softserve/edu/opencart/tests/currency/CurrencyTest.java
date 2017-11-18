package com.softserve.edu.opencart.tests.currency;

import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.categories.CurrencyRepository;
import com.softserve.edu.opencart.data.categories.DetailCategory;
import com.softserve.edu.opencart.data.products.Product;
import com.softserve.edu.opencart.data.products.ProductRepository;
import com.softserve.edu.opencart.pages.Application;

/**
 * @author Yurii Ivanytskyi
 */
public class CurrencyTest {

	@BeforeClass
	public void beforeClass() {
		Application.get(ApplicationSourceRepository.get().chromeServer7());
		//Application.get(ApplicationSourceRepository.get().firefoxServer7());
		Application.get().loadHomePage().clickCurrencyByPartialName("US Dollar");
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Application.get().loadHomePage().clickCurrencyByPartialName("US Dollar");
		Application.remove();
	}
	
//	@BeforeMethod
//	public void startState() {
//		Application.get().loadHomePage().clickCurrencyByPartialName("US Dollar");
//	}
//	
//	@BeforeMethod
//	public void backToStartState() {
//		Application.get().loadHomePage().clickCurrencyByPartialName("US Dollar");
//	}

	@DataProvider
	public Object[][] currencyDataMacBook() {
		return new Object[][] { 
			{ CurrencyRepository.get().euro(), ProductRepository.get().macBook() },
			{ CurrencyRepository.get().dollar(), ProductRepository.get().macBook() },
			{ CurrencyRepository.get().poundSterling(), ProductRepository.get().macBook() }
			};
	}

	@DataProvider
	public Object[][] currencyDataIPhone() {
		return new Object[][] { 
			{ CurrencyRepository.get().euro(), ProductRepository.get().iPhone() },
			{ CurrencyRepository.get().dollar(), ProductRepository.get().iPhone() },
			{ CurrencyRepository.get().poundSterling(), ProductRepository.get().iPhone() }
			};
	}

	@DataProvider
	public Object[][] currencyDataCanon() {
		return new Object[][] { 
			{ CurrencyRepository.get().euro(), ProductRepository.get().canonEOS5D() },
			{ CurrencyRepository.get().dollar(), ProductRepository.get().canonEOS5D() },
			{ CurrencyRepository.get().poundSterling(), ProductRepository.get().canonEOS5D() }
			};
	}

	@Test(dataProvider = "currencyDataMacBook", priority = 1)
	public void checkChangeCurrencyByMacBook(DetailCategory detailCurency, Product product) throws Exception {
		double actualPrice = Application.get().loadHomePage().chooseCurrencyByDetailCategory(detailCurency)
				.getPriceAmountByProduct(product);
		double expectedPrice = product.getPrices().get(detailCurency.getOptionName());
		Assert.assertEquals(actualPrice, expectedPrice, 0.001, "Prices not equals. Price = " + actualPrice + ", but must be = " + expectedPrice);
	}

	@Test(dataProvider = "currencyDataIPhone", priority = 2)
	public void checkChangeCurrencyByIPhone(DetailCategory detailCurency, Product product) throws Exception {
		double actualPrice = Application.get().loadHomePage().chooseCurrencyByDetailCategory(detailCurency)
				.getPriceAmountByProduct(product);
		double expectedPrice = product.getPrices().get(detailCurency.getOptionName());
		Assert.assertEquals(actualPrice, expectedPrice, 0.001, "Prices not equals. Price = " + actualPrice + ", but must be = " + expectedPrice);
	}

	@Test(dataProvider = "currencyDataCanon", priority = 3)
	public void checkChangeCurrencyByCanon(DetailCategory detailCurency, Product product) throws Exception {
		double actualPrice = Application.get().loadHomePage().chooseCurrencyByDetailCategory(detailCurency)
				.getPriceAmountByProduct(product);
		double expectedPrice = product.getPrices().get(detailCurency.getOptionName());
		Assert.assertEquals(actualPrice, expectedPrice, 0.001, "Prices not equals. Price = " + actualPrice + ", but must be = " + expectedPrice);
	}
	
}
