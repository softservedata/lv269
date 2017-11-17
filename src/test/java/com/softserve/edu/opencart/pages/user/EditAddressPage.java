package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class EditAddressPage extends MyAccountPage {
    private WebElement fieldFirstName;
    private WebElement fieldLastName;
    private WebElement fieldFirstAddress;
    private WebElement fieldSecondAddress;
    private WebElement fieldCompany;
    private WebElement fieldCity;
    private WebElement fieldPostCode;
    private Select fieldCountry;
    private Select fieldRegion;
    private WebElement continueButton;
    private WebElement backButton;


    public EditAddressPage(WebDriver driver) {
        super(driver);
        fieldFirstName = driver.findElement(By.id("input-firstname"));
        fieldLastName = driver.findElement(By.id("input-lastname"));
        fieldFirstAddress = driver.findElement(By.id("input-address-1"));
        fieldSecondAddress = driver.findElement(By.id("input-address-2"));
        fieldCompany = driver.findElement(By.id("input-company"));
        fieldCity = driver.findElement(By.id("input-city"));
        fieldPostCode = driver.findElement(By.id("input-postcode"));
        fieldCountry = new Select(driver.findElement(By.id("input-country")));
        fieldRegion = new Select(driver.findElement(By.id("input-zone")));
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

    public WebElement getFieldCompany() {
        return fieldCompany;
    }

    public WebElement getFieldCity() {
        return fieldCity;
    }

    public WebElement getFieldPostCode() {
        return fieldPostCode;
    }

    public Select getFieldCountry() {
        return fieldCountry;
    }

    public Select getFieldRegion() {
        return fieldRegion;
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

    public void clickFieldCompany(){
        getFieldCompany().click();
    }

    public void clickFieldCity(){
        getFieldCity().click();
    }

    public void clickFieldPostCode(){
        getFieldPostCode().click();
    }

    public void clickContinueButton(){getContinueButton().click();}

    public void clickBackButton(){getBackButton().click();}

    public void selectFieldCountry(String text){
        getFieldCountry().selectByVisibleText(text);
    }

    public void selectFieldRegion(String text){
        getFieldRegion().selectByVisibleText(text);
    }

    public void clearFieldFirstName(){
        getFieldFirstName().clear();
    }

    public void clearFieldLastName(){
        getFieldLastName().clear();
    }

    public void clearFieldFirstAddress(){
        getFieldFirstAddress().clear();
    }

    public void clearFieldSecondAddress(){
        getFieldSecondAddress().clear();
    }

    public void clearFieldCompany(){
        getFieldCompany().clear();
    }

    public void clearFieldCity(){
        getFieldCity().clear();
    }

    public void cleareFieldPostCode(){
        getFieldPostCode().clear();
    }

    public void setFieldFirstName(String text){
        getFieldFirstName().sendKeys(text);
    }

    public void setFieldLastName(String text){
        getFieldLastName().sendKeys(text);
    }

    public void setFieldFirstAddress(String text){
        getFieldFirstAddress().sendKeys(text);
    }

    public void setFieldSecondAddress(String text){
        getFieldSecondAddress().sendKeys(text);
    }

    public void setFieldCompany(String text){
        getFieldCompany().sendKeys(text);
    }

    public void setFieldCity(String text){
        getFieldCity().sendKeys(text);}

    public void setFieldPostCode(String text){
        getFieldPostCode().sendKeys(text);}


    //* Business Logic

    public AddressBookPage saveChangesAddress(){
        clickContinueButton();
        return new AddressBookPage(driver);
    }
    public AddressBookPage backWithoutChangesAddress(){
        clickBackButton();
        return new AddressBookPage(driver);
    }
    public void pasteData(String fieldFirstName, String fieldLastName, String fieldFirstAddress, String fieldSecondAddress
                           ,String fieldCompany, String fieldCity, String fieldPostCode
            ,String fieldCountry,String fieldRegion ){
        setFieldFirstName(fieldFirstName);
        setFieldLastName(fieldLastName);
        setFieldFirstAddress(fieldFirstAddress);
        setFieldSecondAddress(fieldSecondAddress);
        setFieldCompany(fieldCompany);
        setFieldCity(fieldCity);
        setFieldPostCode(fieldPostCode);
        selectFieldCountry(fieldCountry);
        selectFieldRegion(fieldRegion);
        saveChangesAddress();
    }



}
