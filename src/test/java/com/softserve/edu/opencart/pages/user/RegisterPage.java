package com.softserve.edu.opencart.pages.user;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Yurii Ivanytskyi
 */

public class RegisterPage extends AColumnRightGuestComponent {
	
	private PersonalDetailsPage personalDetailsPage;
	private AddressPage addressPage;
	private PasswordPage passwordPage;
	
	private WebElement linkToLogin;
	private List<WebElement> radioNewsSubscribe; // ?
	private WebElement linkPrivacyPolicy;
	private WebElement checkPrivacyPolicy;
	private WebElement submitButton;

	public RegisterPage(WebDriver driver) {
		super(driver);
		personalDetailsPage = new PersonalDetailsPage(driver);
		addressPage = new AddressPage(driver);
		passwordPage = new PasswordPage(driver);
		linkToLogin = driver.findElement(By.cssSelector("#content>p>a"));
		radioNewsSubscribe = driver.findElements(By.cssSelector(".radio-inline")); // ?
		linkPrivacyPolicy = driver.findElement(By.cssSelector(".pull-right > a"));
		checkPrivacyPolicy = driver.findElement(By.cssSelector(".pull-right > input"));
		submitButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
	}

	// Page Object

	// get Data
	
	public PersonalDetailsPage getPersonalDetailsPage() {
		return personalDetailsPage;
	}

	public AddressPage getAddressPage() {
		return addressPage;
	}

	public PasswordPage getPasswordPage() {
		return passwordPage;
	}
	
	public WebElement getLinkToLogin() {
		return linkToLogin;
	}

	public List<WebElement> getRadioNewsSubscribe() {
		return radioNewsSubscribe;
	}

	public WebElement getLinkPrivacyPolicy() {
		return linkPrivacyPolicy;
	}

	public WebElement getCheckPrivacyPolicy() {
		return checkPrivacyPolicy;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	// get Functional

	// set Data

	public void clickLinkPrivacyPolicy() {
		getLinkPrivacyPolicy().click();
	}

	public void clickSubmitButton() {
		getSubmitButton().click();
	}

	// set Functional

	public void clickRadioNewsSubscribe() {
		for (WebElement radio : radioNewsSubscribe) {
			if (!radio.isSelected()) {
				radio.click();
				break;
			}
		}
	}

	public void clickCheckPrivacyPolicy() {
		getCheckPrivacyPolicy().click();
	}

	// Business Logic

	public LoginPage gotoLinkToLogin() {
		getLinkToLogin().click();
		return new LoginPage(driver);
	}

	public RegisterSuccessPage gotoRegisterSuccessPage() {
		clickSubmitButton();
		return new RegisterSuccessPage(driver);
	}
}
