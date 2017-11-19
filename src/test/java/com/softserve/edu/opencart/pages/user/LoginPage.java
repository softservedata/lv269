package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.users.IUser;

public class LoginPage extends AColumnRightGuestComponent {

    // Fields

    private WebElement eMailAddressField;
    private WebElement passwordField;
    private WebElement LoginButton;
    private WebElement warning;

    public LoginPage(WebDriver driver) {
        super(driver);
        eMailAddressField = driver.findElement(By.name("email"));
        passwordField = driver.findElement(By.name("password"));
        LoginButton = driver.findElement(By.xpath("//*[@value='Login'] [@class='btn btn-primary']"));

    }

    // PageObject

    // get Data

    public WebElement geteMailAddressField() {
        return eMailAddressField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getLoginButton() {
        return LoginButton;
    }


    public WebElement getWarningText() {
        return getWarningText();
    }
// get Functional

    // set Data

    public void clickEMailAddressField() {
        geteMailAddressField().click();
    }

    public void clickPasswordField() {
        getPasswordField().click();
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

    public void clearEMailAddressField() {
        geteMailAddressField().clear();
    }

    public void clearPasswordField() {
        getPasswordField().clear();
    }


    // set Functional

    private void inputInEmailField(String eMailAddress) {
        geteMailAddressField().sendKeys(eMailAddress);
    }

    private void inputInPasswordField(String passwordField) {
        getPasswordField().sendKeys(passwordField);
    }

    public void inputEMailAdress(String eMailAddress) {
        clickEMailAddressField();
        clearEMailAddressField();
        inputInEmailField(eMailAddress);
    }

    public void inputPassword(String passwordField) {
        clickPasswordField();
        clearPasswordField();
        inputInPasswordField(passwordField);
    }


    public void loginForLoginPageToMyAccountPage(String email, String password) {
        inputEMailAdress(email);
        inputPassword(password);
        clickLoginButton();
        //return new MyAccountPage(driver);
    }

    public void loginForLoginPageToWarning(String email, String wrongPassword) {
        inputEMailAdress(email);
        inputPassword(wrongPassword);
        clickLoginButton();
        //return new LoginPage(driver);
    }
    
	// Business Logic
    
    public MyAccountPage gotoLoginForLoginPageToMyAccountPage(IUser user) {
        //inputEMailAdress(email);
        //inputPassword(password);
        //clickLoginButton();
    	loginForLoginPageToMyAccountPage(user.getEmail(), user.getPassword());
        return new MyAccountPage(driver);
    }

    public LoginPage gotoLoginForLoginPageToWarning(IUser user) {
        //inputEMailAdress(email);
        //inputPassword(wrongPassword);
        //clickLoginButton();
    	loginForLoginPageToWarning(user.getEmail(), user.getPassword());
        return new LoginPage(driver);
    }
    
     public String getWarningDangerText(){

            return getAlertDangerText();

    }

}