package com.softserve.edu.opencart.pages.user;

import com.softserve.edu.opencart.data.categories.IDetailCategory;
import com.softserve.edu.opencart.data.products.IProduct;
import com.softserve.edu.opencart.data.products.Product;
import com.softserve.edu.opencart.pages.Application;
import org.openqa.selenium.By;

import java.util.List;

public class HomePage extends AHeaderComponent {

    // Fields

    //public HomePage(WebDriver driver) {
    public HomePage() {
        //super(driver);
        super();
        initProductComponents(By.cssSelector(".product-layout"));
    }

    // PageObject

    // get Data

    // get Functional

    @Override
    public List<String> getProductComponentTexts() {
        return super.getProductComponentTexts();
    }

    @Override
    public String getPriceTextByProductName(String productName) {
        return super.getPriceTextByProductName(productName);
    }
    
    @Override
    public int getPriceSymbolAsciiByProductName(String productName) {
        return super.getPriceSymbolAsciiByProductName(productName);
    }

    @Override
    public double getPriceAmountByProductName(String productName) {
        return super.getPriceAmountByProductName(productName);
    }

    // set Data

    @Override
    public void clickAddToCartByProductName(String productName) {
        super.clickAddToCartByProductName(productName);
    }

    @Override
    public void clickAddToWishByProductName(String productName) {
        super.clickAddToWishByProductName(productName);
    }

    // set Functional

    // Business Logic
    
    public HomePage chooseCurrencyByDetailCategory(IDetailCategory detailCategory) {
        logger.debug("Choose detailCategory.getOptionName() = " + detailCategory.getOptionName());
        reporter.debug("Choose detailCategory.getOptionName() = " + detailCategory.getOptionName());
        clickCurrencyByPartialName(detailCategory.getOptionName());
        //return new HomePage(driver); 
        return new HomePage();
    }
    
    public int getPriceSymbolAsciiByProduct(Product product) {
        return getPriceSymbolAsciiByProductName(product.getName());
    }
    
    public double getPriceAmountByProduct(Product product) {
        return getPriceAmountByProductName(product.getName());
    }

    public SuccesSearchPage succesSearchProduct(String partialProductName) {
        clickSearchProductField();
        clearSearchProductField();
        setSearchProductField(partialProductName);
        clickSearchProductButton();
        //return new SuccesSearchPage(driver);
        return new SuccesSearchPage();
    }

    public HomePage gotoHomePageClickAddToWish(IProduct product) {
        clickAddToWishByProductName(product.getName());
        // TODO ChromeDriver/Chrome java script execution BUG!!!
        Application.get().browser().refreshPage();
        //try {Thread.sleep(1000);} catch (InterruptedException ex) {}
        return new HomePage();
    }
}
