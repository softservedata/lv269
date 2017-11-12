package com.softserve.edu.opencart.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebDriverManager {

    private static final String GECKO_WEBDRIVER_PARAMETER = "webdriver.gecko.driver";
    private static final String CHROME_WEBDRIVER_PARAMETER = "webdriver.chrome.driver";
    private static final String GECKO_WEBDRIVER_PATH = "C:/AutomationTools/geckodriver.exe";
    private static final String GOOGLE_WEBDRIVER_PATH = "C:/AutomationTools/chromedriver.exe";
    private static final String ELEMENT_IS_NOT_DISPLAYED_MESSAGE = "Element is not visible on the page";

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private Actions action;
    private static final int MAX_DRIVER_PAUSE = 5;

    public void setWebdriverChrome() {
        System.setProperty(CHROME_WEBDRIVER_PARAMETER, GOOGLE_WEBDRIVER_PATH);
        webDriver = new ChromeDriver();
        setWait();
    }

    public void setWebdriverFirefox() {
        System.setProperty(GECKO_WEBDRIVER_PARAMETER, GECKO_WEBDRIVER_PATH);
        webDriver = new FirefoxDriver();
        setWait();
    }

    public void openAddress(String address) {
        webDriver.get(address);
    }

    public void cleanField(By elementLocator) {
        webDriver.findElement(elementLocator).clear();
    }
    public void cleanField(WebElement webElement) {
        webElement.clear();
    }

    public WebElement findElement(By elementLocator) {
        List <WebElement> result = findElements(elementLocator);
        ErrorUtils.createElementIsNotDisplayedException ((result.size() ==0), ELEMENT_IS_NOT_DISPLAYED_MESSAGE);
        return result.get(0);
    }

    public List<WebElement> findElements(By elementLocators) {
        return webDriver.findElements(elementLocators);
    }

    public WebElement findElementInsideElement(WebElement element, By subElementLocator) {
        List <WebElement> result = findElementsInsideElement(element, subElementLocator);
        ErrorUtils.createElementIsNotDisplayedException ((result.size() ==0), ELEMENT_IS_NOT_DISPLAYED_MESSAGE);
        return result.get(0);
    }

    public List<WebElement> findElementsInsideElement(WebElement element, By subElementLocator) {
        return element.findElements(subElementLocator);
    }

    public List<WebElement> findElementsInsideElement(By elementLocator, By subElementLocator) {
        return findElement(elementLocator).findElements(subElementLocator);
    }

    public void clickElement(By elementLocator) {
        waitToBeDisplayed(elementLocator);
        webDriver.findElement(elementLocator).click();
    }

    public void clickElement(WebElement webElement) {
        waitToBeDisplayed(webElement);
        webElement.click();
    }

    public void fillInputField(By elementLocator, String text) {
        clickElement(elementLocator);
        cleanField(elementLocator);
        webDriver.findElement(elementLocator).sendKeys(text);
    }
    public void fillInputField(WebElement webElement, String text) {
        clickElement(webElement);
        webElement.clear();
        webElement.sendKeys(text);
    }

    public boolean isElementDisplayed (WebElement webElement) {
        return (webElement.isDisplayed());
    }

    public void quitDriver() {
        webDriver.quit();
    }

    private void setWait() {
        webDriverWait = new WebDriverWait(webDriver, MAX_DRIVER_PAUSE);
    }

    private void waitToBeDisplayed(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.
                visibilityOf(webElement));
    }

    private void waitToBeDisplayed(By elementLocator) {
        webDriverWait.until(ExpectedConditions.
                visibilityOfElementLocated((elementLocator)));
        
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

}
