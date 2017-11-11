package com.softserve.edu.opencart.testng;

import com.softserve.edu.opencart.testng.constants.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * This class operates with a browser and all its elements.
 */
public class WebDriverManager {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private Actions action;
    private static final int MAX_DRIVER_PAUSE = 5;

    public void setWebdriverChrome() {
        System.setProperty(
                Credentials.CHROME_WEBDRIVER_PARAMETER.get(),
                Credentials.GOOGLE_WEBDRIVER_PATH.get());
        webDriver = new ChromeDriver();
        setWaitsAndActions();
    }

    public void setWebdriverFirefox() {
        System.setProperty(
                Credentials.GECKO_WEBDRIVER_PARAMETER.get(),
                Credentials.GECKO_WEBDRIVER_PATH.get());
        webDriver = new FirefoxDriver();
        setWaitsAndActions();
    }

    public WebDriver getDriver() {
        return webDriver;
    }

    public void clickElement(By byElement) {
        waitToBeDisplayed(byElement);
        webDriver.findElement(byElement).click();
    }
    public void clickElement(WebElement webElement) {
        waitToBeDisplayed(webElement);
        webElement.click();
    }

    public void clickAndHoldElement(By byElement) {
        waitToBeDisplayed(byElement);
        action.moveToElement(webDriver.findElement(byElement)).click();
    }

    public void fillInputField(By byElement, String text) {
        clickElement(byElement);
        cleanField(byElement);
        webDriver.findElement(byElement).click();
        webDriver.findElement(byElement).sendKeys(text);
    }

    public void waitToBeDisplayed(By byElement) {
        webDriverWait.until(ExpectedConditions.
                visibilityOfElementLocated((byElement)));
    }
    public void waitToBeDisplayed(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.
                visibilityOf(webElement));
    }

    public boolean isElementDisplayed(By byElement) {
        waitToBeDisplayed(byElement);
        return webDriver.findElement(byElement).isDisplayed();
    }

    public boolean isElementPresent(By byElement) {
        return (webDriver.findElements(byElement).size() > 0);
    }

    private void setWaitsAndActions() {
        webDriverWait = new WebDriverWait(webDriver, 3);
        action = new Actions(webDriver);
    }

    public void quitDriver() {
        webDriver.quit();
    }

    public WebElement getElement(By byElement) {
        return webDriver.findElement(byElement);
    }

    public List<WebElement> getElements(By byElements) {
        return webDriver.findElements(byElements);
    }

    public void cleanField(By byElement) {
        webDriver.findElement(byElement).clear();
    }

    public void openAddress(String address) {
        webDriver.get(address);
    }

    public String getTextFromElement(By byElement) {
        return webDriver.findElement(byElement).getText();
    }

    public void selectByVisibleText(By byElement, String value) {
        waitToBeDisplayed(byElement);
        Select select = new Select(webDriver.findElement(byElement));
        select.selectByVisibleText(value);
    }

    public WebElement findElementInsideElement(WebElement element, By bySubElement) {
        return element.findElement(bySubElement);
    }

    public List<WebElement> findElementsInsideElement(WebElement element, By bySubElement) {
        return element.findElements(bySubElement);
    }
    public List<WebElement> findElementsInsideElement(By byElement, By bySubElement) {
        return getElement(byElement).findElements(bySubElement);
    }

}
