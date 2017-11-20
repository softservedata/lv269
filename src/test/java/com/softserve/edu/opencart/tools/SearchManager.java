package com.softserve.edu.opencart.tools;

import com.softserve.edu.opencart.constants.URLs;
import com.softserve.edu.opencart.pages.admin.LoginAdminPage;
import com.softserve.edu.opencart.pages.user.HomePage;
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

public class SearchManager {

    private static final String ELEMENT_IS_NOT_DISPLAYED_MESSAGE = "Element is not visible on the page";
    private static final String VALUE_NOT_FOUND_MESSAGE = "For select, value = %s was not found.";

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private Actions action;
    private static final int MAX_DRIVER_PAUSE = 5;

    public SearchManager(WebDriver webDriver) {
        this.webDriver=webDriver;
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
        List<WebElement> result = findElements(elementLocator);
        ErrorUtils.createElementIsNotDisplayedException((result.size() == 0), ELEMENT_IS_NOT_DISPLAYED_MESSAGE);
        return result.get(0);
    }

    public List<WebElement> findElements(By elementLocators) {
        return webDriver.findElements(elementLocators);
    }

    public WebElement findElementInsideElement(WebElement element, By subElementLocator) {
        List<WebElement> result = findElementsInsideElement(element, subElementLocator);
        ErrorUtils.createElementIsNotDisplayedException((result.size() == 0), ELEMENT_IS_NOT_DISPLAYED_MESSAGE);
        return result.get(0);
    }

    public WebElement findElementInsideElement(By elementLocator, By subElementLocator) {
        List<WebElement> result = findElementsInsideElement(findElement(elementLocator), subElementLocator);
        ErrorUtils.createElementIsNotDisplayedException((result.size() == 0), ELEMENT_IS_NOT_DISPLAYED_MESSAGE);
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

    public boolean isElementDisplayed(WebElement webElement) {
        return (webElement.isDisplayed());
    }

    public void quitDriver() {
        if (getWebDriver() != null) {
            webDriver.quit();
        }
        webDriver = null;
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

    public void selectByVisibleText(Select selectElement, String valueText) {
        boolean flag = false;
        int selectedValueNumber = -1;
        for (WebElement current : selectElement.getOptions()) {
            if (current.getText().toLowerCase().contains(valueText.toLowerCase())) {
                valueText = current.getText();
                flag = true;
                break;
            }
        }
        ErrorUtils.createValueNotFoundException(!flag,
                String.format(VALUE_NOT_FOUND_MESSAGE, valueText));
        selectElement.selectByVisibleText(valueText);
    }

    public LoginAdminPage openLoginAdminPage () {
        openAddress(URLs.URL_SERVER.toString() + URLs.URL_ADMIN_PAGE.toString());
        return new LoginAdminPage(this);
    }

    public HomePage openHomePage () {
        openAddress(URLs.URL_SERVER.toString());
        return new HomePage(getWebDriver());
    }

    public boolean isElementVisible(By elementLocator) {
        return (findElements(elementLocator).size()>0);
    }

    public void selectCheckBox(WebElement checkBoxElement) {
        if (!isCheckboxSelected(checkBoxElement)) {
         clickElement(checkBoxElement);
        }
    }

    public void deselectCheckBox(WebElement checkBoxElement) {
        if (isCheckboxSelected(checkBoxElement)) {
            clickElement(checkBoxElement);
        }
    }

    public boolean isCheckboxSelected(WebElement checkBoxElement) {
        return (checkBoxElement.isSelected());
    }

}
