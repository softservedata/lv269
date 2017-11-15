package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by ${Mirek}
 */
public class EditAddressPage extends MyAccountPage {
    private WebElement fieldFirstName;
    private WebElement fieldLastName;
    private WebElement fieldFirstAddress;
    private WebElement fieldSecondAddress;
    private WebElement company;
    private WebElement city;
    private WebElement postCode;
    private Select country;
    private Select region;
    private WebElement continueButton;
    private WebElement backButton;


    public EditAddressPage(WebDriver driver) {
        super(driver);
        fieldFirstName = driver.findElement(By.id("input-firstname"));
        fieldLastName = driver.findElement(By.id("input-lastname"));
        fieldFirstAddress = driver.findElement(By.id("input-address-1"));
        fieldSecondAddress = driver.findElement(By.id("input-address-2"));
        company = driver.findElement(By.id("input-company"));
        city = driver.findElement(By.id("input-city"));
        postCode = driver.findElement(By.id("input-postcode"));
        country = new Select(driver.findElement(By.id("input-country")));
        region = new Select(driver.findElement(By.id("input-zone")));
        continueButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
        backButton = driver.findElement(By.xpath(".//a[contains( text(),'Back')]"));

    }
    // PageObject

    // get Data

    public WebElement getFieldFirstName() {
        return fieldFirstName;
    }

    public WebElement getFieldLastName() {
        return fieldLastName;
    }

    public WebElement getFieldFirstAddress() {
        return fieldFirstAddress;
    }

    public WebElement getFieldSecondAddress() {
        return fieldSecondAddress;
    }

    public WebElement getCompany() {
        return company;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getPostCode() {
        return postCode;
    }

    public Select getCountry() {
        return country;
    }

    public Select getRegion() {
        return region;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public WebElement getBackButton() {
        return backButton;
    }
    // get Functional

    // set Data

    public void clickFieldFirstName(){
        getFieldFirstName().click();
    }

    public void clickFieldLastName(){
        getFieldLastName().click();
    }
    public void clickFieldFirstAddress(){
        getFieldFirstAddress().click();
    }
    public void clickFieldSecondAddress(){
        getFieldSecondAddress().click();
    }
    public void clickCompany(){
        getCompany().click();
    }
    public void clickCity(){
        getCity().click();
    }
    public void clickPostCode(){
        getPostCode().click();
    }
    public void selectCountry(String text){
        country.deselectByVisibleText(text);
    }
    public void selectRegion(String text){
        region.deselectByVisibleText(text);
    }
    //* Business Logic

}
