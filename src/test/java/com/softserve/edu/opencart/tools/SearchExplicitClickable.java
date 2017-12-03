package com.softserve.edu.opencart.tools;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    public WebElement getWebElement(By by) {
        // System.out.println("\t\t\t*** Class SearchExplicitClickable");
        return getWait().until(ExpectedConditions.elementToBeClickable(by));
    }

    @Override
    public WebElement getWebElement(By by, WebElement fromWebElement) {
        // TODO Use elementToBeClickable for Next Version
        return super.getWebElement(by, fromWebElement);
    }

    @Override
    public List<WebElement> getWebElements(By by) {
        // TODO Use elementToBeClickable for Next Version
        return super.getWebElements(by);
    }

    @Override
    public List<WebElement> getWebElements(By by, WebElement fromWebElement) {
        // TODO Use elementToBeClickable for Next Version
        return super.getWebElements(by, fromWebElement);
    }

    @Override
    public boolean stalenessOf(WebElement webElement) {
        return super.stalenessOf(webElement);
    }

}
