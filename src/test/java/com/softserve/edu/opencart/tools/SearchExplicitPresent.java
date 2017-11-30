package com.softserve.edu.opencart.tools;

import com.softserve.edu.opencart.pages.Application;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

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
    protected WebElement getWebElement(By by) {
        return getWait().until(ExpectedConditions.presenceOfElementLocated(by));
    }

    @Override
    protected WebElement getWebElement(By by, WebElement fromWebElement) {
        return getWait().until(ExpectedConditions.presenceOfNestedElementLocatedBy(fromWebElement, by));
    }

    /**
     * Method to explicitly wait for presence of specific elements.
     * @param by
     *            locator for elements.
     * @return present webelements.
     */
    @Override
    protected List<WebElement> getWebElements(By by) {
        return getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    @Override
    protected List<WebElement> getWebElements(By by, WebElement fromWebElement) {
        // TODO Use presenceOfNestedElementLocatedBy Method
        return super.getWebElements(by, fromWebElement);
    }

    @Override
    public boolean stalenessOf(WebElement webElement) {
        return super.stalenessOf(webElement);
    }

    @Override
    public boolean isVisibleCssSelector(String cssSelector) {
        return Application.get().getBrowser().getDriver().findElements(By.cssSelector(cssSelector)).size()>0;
//
//        JavascriptExecutor executor = (JavascriptExecutor)Application.get().getBrowser().getDriver();
//        List<WebElement> temp = executor.executeScript("document.getElementsByClassName(argument[0])", cssSelector);
//        return  (!getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(cssSelector)))); //(cssSelectors(cssSelector).size() >0);
    }
}
