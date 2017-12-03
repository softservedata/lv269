package com.softserve.edu.opencart.tests.currency;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.categories.CurrencyRepository;
import com.softserve.edu.opencart.data.categories.IDetailCategory;
import com.softserve.edu.opencart.data.products.Product;
import com.softserve.edu.opencart.data.products.ProductRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tests.TestRunner;

/**
 * @author Yurii Ivanytskyi
 */
public class TestCurrency extends TestRunner{
	
	private String PRICES_NOT_EQUALS = "Prices not equals:";

    @DataProvider
    public Object[][] currencyData() {
        return new Object[][] { 
        	{ CurrencyRepository.get().euro(), ProductRepository.get().iPhone() },
            { CurrencyRepository.get().dollar(), ProductRepository.get().iPhone() },
            { CurrencyRepository.get().poundSterling(), ProductRepository.get().iPhone() } };
    }

    @Test(dataProvider = "currencyData")
    public void checkChangeCurrency(IDetailCategory detailCurency, Product product) {
    	logger.info(String.format("Started checkProduct(DetailCategory %s, Product %s)", detailCurency.getCategoryName(), product.getName()));
        reporter.display(String.format("Started checkProduct(DetailCategory %s, Product %s)", detailCurency.getCategoryName(), product.getName()));
        
        Assert.assertEquals(Application.get()
        		.loadHomePage().chooseCurrencyByDetailCategory(detailCurency)
                .getPriceAmountByProduct(product), 
                product.getPrices().get(detailCurency.getOptionName()), 0.001, PRICES_NOT_EQUALS);
    }

}
