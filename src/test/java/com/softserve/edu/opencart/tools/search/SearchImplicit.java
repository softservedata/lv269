package com.softserve.edu.opencart.tools.search;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.edu.opencart.pages.Application;

/**
 * Class for searching visible elements with implicit timeout.
 */
public class SearchImplicit extends ASearch {

    public SearchImplicit() {
        initImplicitWaits();
        // System.out.println("***SearchImplicit");
    }

    private void initImplicitWaits() {
        Application.get().browser().getDriver().manage().timeouts()
                .implicitlyWait(Application.get().getApplicationSource().getImplicitWaitTimeOut(), TimeUnit.SECONDS);
        Application.get().browser().getDriver().manage().timeouts()
                .pageLoadTimeout(Application.get().getApplicationSource().getImplicitLoadTimeOut(), TimeUnit.SECONDS);
        Application.get().browser().getDriver().manage().timeouts()
                .setScriptTimeout(Application.get().getApplicationSource().getImplicitScriptTimeOut(), TimeUnit.SECONDS);
    }

    private void removeImplicitWaits() {
        Application.get().browser().getDriver().manage().timeouts().implicitlyWait(0L, TimeUnit.SECONDS);
        Application.get().browser().getDriver().manage().timeouts().pageLoadTimeout(0L, TimeUnit.SECONDS);
        Application.get().browser().getDriver().manage().timeouts().setScriptTimeout(0L, TimeUnit.SECONDS);
    }

    /**
     * Method to implicitly wait for visibility of specific element.
     * @param by
     *            locator for element.
     * @return visible WebElement.
     */
    @Override
    public WebElement getWebElement(By by) {
        //System.out.println("\t\t\t*** Class SearchImplicit");
        return Application.get().browser().getDriver().findElement(by);
    }

    /**
     * Method to implicitly wait for visibility of specific element, located
     * from already located WebElement.
     * @param by
     *            locator for element.
     * @param fromWebElement
     *            located WebElement to start searching from.
     * @return visible WebElement.
     */
    @Override
    public WebElement getWebElement(By by, WebElement fromWebElement) {
        return fromWebElement.findElement(by);
    }

    /**
     * Method to implicitly wait for visibility of specific elements.
     * @param by
     *            locator for elements.
     * @return visible WebElement.
     */
    @Override
    public List<WebElement> getWebElements(By by) {
        return Application.get().browser().getDriver().findElements(by);
    }

    @Override
    public List<WebElement> getWebElements(By by, WebElement fromWebElement) {
        return fromWebElement.findElements(by);
    }

    @Override
    public boolean stalenessOf(WebElement webElement) {
        removeImplicitWaits();
        new WebDriverWait(Application.get().browser().getDriver(),
                Application.get().getApplicationSource().getExplicitTimeOut())
                        .until(ExpectedConditions.stalenessOf(webElement));
        initImplicitWaits();
        return true;
    }
}
