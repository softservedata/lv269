package com.softserve.edu.opencart.pages.user;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.data.DetailCategory;

public class SubCategoryProductsPage extends AColumnLeftComponent {

    // Fields

    private List<WebElement> leftSubCategories;
    private List<ProductComponent> productComponents;

    public SubCategoryProductsPage(WebDriver driver) {
        super(driver);
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

    public SubCategoryProductsPage chooseCurrencyByDetailCategory(DetailCategory detailCategory) {
        clickCurrencyByPartialName(detailCategory.getOptionName());
        return new SubCategoryProductsPage(driver); 
    }

}
