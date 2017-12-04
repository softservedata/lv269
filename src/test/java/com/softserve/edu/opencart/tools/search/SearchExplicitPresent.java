package com.softserve.edu.opencart.tools.search;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class for searching present elements with explicit timeout.
 */
public class SearchExplicitPresent extends SearchExplicitVisible {

    public SearchExplicitPresent() {
        super();
    }

    /**
     * Method to explicitly wait for presence of specific element.
     * @param by
     *            locator for element.
     * @return present webelement.
     */
    @Override
    public WebElement getWebElement(By by) {
        return getWait().until(ExpectedConditions.presenceOfElementLocated(by));
    }

    @Override
    public WebElement getWebElement(By by, WebElement fromWebElement) {
        return getWait().until(ExpectedConditions.presenceOfNestedElementLocatedBy(fromWebElement, by));
    }

    /**
     * Method to explicitly wait for presence of specific elements.
     * @param by
     *            locator for elements.
     * @return present webelements.
     */
    @Override
    public List<WebElement> getWebElements(By by) {
        return getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    @Override
    public List<WebElement> getWebElements(By by, WebElement fromWebElement) {
        // TODO Use presenceOfNestedElementLocatedBy Method
        return super.getWebElements(by, fromWebElement);
    }

    @Override
    public boolean stalenessOf(WebElement webElement) {
        return super.stalenessOf(webElement);
    }
}
