package com.softserve.edu.opencart.tests.currency;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.categories.CurrencyRepository;
import com.softserve.edu.opencart.data.categories.IDetailCategory;
import com.softserve.edu.opencart.data.products.PriceSymbolProduct;
import com.softserve.edu.opencart.data.products.PriceSymbolRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tests.TestRunner;

/**
 * @author Yurii Ivanytskyi
 */
public class TestCurrencyBySymbol extends TestRunner{
	
	private final String SYMBOLS_NOT_EQUALS = "Symbols not equals: ";

	@DataProvider
    public Object[][] priceSymbolData() {
        return new Object[][] { 
        	{ CurrencyRepository.get().euro(), PriceSymbolRepository.get().macBook() },
            { CurrencyRepository.get().dollar(), PriceSymbolRepository.get().macBook() },
            { CurrencyRepository.get().poundSterling(), PriceSymbolRepository.get().macBook() } };
    }

    @Test(dataProvider = "priceSymbolData")
    public void checkChangeCurrencyBySymbol(IDetailCategory detailCurency, PriceSymbolProduct priceSymbolProduct) {
    	logger.info(String.format("Started checkProduct(DetailCategory %s, Product %s)", detailCurency.getCategoryName(), priceSymbolProduct.getName()));
        reporter.display(String.format("Started checkProduct(DetailCategory %s, Product %s)", detailCurency.getCategoryName(), priceSymbolProduct.getName()));
        
        Assert.assertTrue(Application.get()
        		.loadHomePage().chooseCurrencyByDetailCategory(detailCurency)
                .getPriceSymbolByProduct(priceSymbolProduct).equals( priceSymbolProduct.getSymbols().get(detailCurency.getOptionName())), 
                SYMBOLS_NOT_EQUALS);
    }
	
}
