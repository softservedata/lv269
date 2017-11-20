package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SuccessSearchPage extends ASearchComponent {

    public final String NO_MATCH = "List of products not matches expected list.";
    public final String PRODUCT_IS_NOT_FOUND = "Product not found by %s query";

    private WebElement selectInputSort;
    private WebElement selectInputLimit;


    public SuccessSearchPage(WebDriver driver) {
        super(driver);

        initProductComponents(By.cssSelector(".product-layout"));
        selectInputSort = driver.findElement(By.id("input-sort"));
        selectInputLimit = driver.findElement(By.id("input-limit"));
    }

    // PageObject

    // get Data
    public WebElement getSelectInputLimit() {
        return selectInputLimit;
    }

    public WebElement getSelectInputSort() {
        return selectInputSort;
    }

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
    public void setSelectInputSortByPartialName(String sortType){
        selectOptionByPartialName(sortType, getSelectInputSort());
    }

    public void setSelectInputLimitByPartialName(String limit){
        selectOptionByPartialName(limit, getSelectInputLimit());
    }
    // set Functional

    // Business Logic
    public boolean isFound(List<String> foundProducts, String elementName){
        for (String current : foundProducts){
            if(current.contains(elementName)){
                return true;
            }
        }
        return false;
    }

}