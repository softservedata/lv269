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

public class CurrencyTest {

	@BeforeClass
	public void beforeClass() {
		Application.get(ApplicationSourceRepository.get().chromeServer7());
//		Application.get(ApplicationSourceRepository.get().firefoxServer7());
		
	}

	@AfterClass
	public void afterClass() {
		Application.remove();
	}

	@DataProvider
	public Object[][] productData() {
		return new Object[][] { 
			{ CurrencyRepository.get().euro(), ProductRepository.get().macBook() },
			{ CurrencyRepository.get().dollar(), ProductRepository.get().macBook() },
			{ CurrencyRepository.get().poundSterling(), ProductRepository.get().macBook() } 
			};
	}

	@Test(dataProvider = "productData")
	public void checkChangeCurrency(DetailCategory detailCurency, Product product) throws Exception {
		double actualPrice = Application.get().loadHomePage().chooseCurrencyByDetailCategory(detailCurency)
				.getPriceAmountByProduct(product);
		// TODO getPrices(detailCurency)
		double expectedPrice = product.getPrices().get(detailCurency.getOptionName());
		Assert.assertEquals(actualPrice, expectedPrice, 0.001);
		Thread.sleep(1000);
	}
}
