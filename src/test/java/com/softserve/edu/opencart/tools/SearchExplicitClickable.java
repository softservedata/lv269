package com.softserve.edu.opencart.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchExplicitClickable extends SearchExplicitVisible {

    public SearchExplicitClickable() {
        super();
    }

    /**
     * Method to explicitly wait for clickability of specific element.
     * @param by
     *            locator for element.
     * @return clickable webelement.
     */
    @Override
    protected WebElement getWebElement(By by) {
        // System.out.println("\t\t\t*** Class SearchExplicitClickable");
        return getWait().until(ExpectedConditions.elementToBeClickable(by));
    }

    @Override
    protected WebElement getWebElement(By by, WebElement fromWebElement) {
        // TODO Use elementToBeClickable for Next Version
        return super.getWebElement(by, fromWebElement);
    }

    @Override
    protected List<WebElement> getWebElements(By by) {
        // TODO Use elementToBeClickable for Next Version
        return super.getWebElements(by);
    }

    @Override
    protected List<WebElement> getWebElements(By by, WebElement fromWebElement) {
        // TODO Use elementToBeClickable for Next Version
        return super.getWebElements(by, fromWebElement);
    }

    @Override
    public boolean stalenessOf(WebElement webElement) {
        return super.stalenessOf(webElement);
    }

}
