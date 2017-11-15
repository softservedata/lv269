package com.softserve.edu.opencart.pages.user;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Yurii Ivanytskyi
 */

public class RegisterPage extends AColumnRightGuestComponent {

	private WebElement linkToLogin;
	private WebElement fieldFirstName;
	private WebElement fieldLastName;
	private WebElement fieldEmail;
	private WebElement fieldTelephone;
	private WebElement fieldFax;
	private WebElement fieldCompany;
	private WebElement fieldAddressFirst;
	private WebElement fieldAddressSecond;
	private WebElement fieldCity;
	private WebElement fieldPostCode;
	private Select country;
	private Select zone;
	private WebElement fieldPassword;
	private WebElement fieldConfirmPassword;
	private List<WebElement> radioNewsSubscribe; //?
	private WebElement linkPrivacyPolicy;
	private WebElement checkPrivacyPolicy;
	private WebElement submitButton;

	public RegisterPage(WebDriver driver) {
		super(driver);
		linkToLogin = driver.findElement(By.cssSelector("#content>p>a"));
		fieldFirstName = driver.findElement(By.id("input-firstname"));
		fieldLastName = driver.findElement(By.id("input-lastname"));
		fieldEmail = driver.findElement(By.id("input-email"));
		fieldTelephone = driver.findElement(By.id("input-telephone"));
		fieldFax = driver.findElement(By.id("input-fax"));
		fieldCompany = driver.findElement(By.id("input-company"));
		fieldAddressFirst = driver.findElement(By.id("input-address-1"));
		fieldAddressSecond = driver.findElement(By.id("input-address-2"));
		fieldCity = driver.findElement(By.id("input-city"));
		fieldPostCode = driver.findElement(By.id("input-postcode"));
		country = new Select(driver.findElement(By.id("input-country")));
		zone = new Select(driver.findElement(By.id("input-zone")));
		fieldPassword = driver.findElement(By.id("input-password"));
		fieldConfirmPassword = driver.findElement(By.id("input-confirm"));
		radioNewsSubscribe = driver.findElements(By.cssSelector(".radio-inline")); //?
		linkPrivacyPolicy = driver.findElement(By.cssSelector(".pull-right > a"));
		checkPrivacyPolicy = driver.findElement(By.cssSelector(".pull-right > input"));
		submitButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
	}
	
	// Page Object
	
	// get Data

	public WebElement getLinkToLogin() {
		return linkToLogin;
	}

	public WebElement getFieldFirstName() {
		return fieldFirstName;
	}

	public WebElement getFieldLastName() {
		return fieldLastName;
	}

	public WebElement getFieldEmail() {
		return fieldEmail;
	}

	public WebElement getFieldTelephone() {
		return fieldTelephone;
	}

	public WebElement getFieldFax() {
		return fieldFax;
	}

	public WebElement getFieldCompany() {
		return fieldCompany;
	}

	public WebElement getFieldAddressFirst() {
		return fieldAddressFirst;
	}

	public WebElement getFieldAddressSecond() {
		return fieldAddressSecond;
	}

	public WebElement getFieldCity() {
		return fieldCity;
	}

	public WebElement getFieldPostCode() {
		return fieldPostCode;
	}

	public Select getCountry() {
		return country;
	}

	public Select getZone() {
		return zone;
	}

	public WebElement getFieldPassword() {
		return fieldPassword;
	}

	public WebElement getFieldConfirmPassword() {
		return fieldConfirmPassword;
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
	
	public void clickFieldFirstName() {
		getFieldFirstName().click();
	}
	
	public void setFieldFirstName(String text) {
		getFieldFirstName().sendKeys(text);
	}
	
	public void clearFieldFirstName() {
		getFieldFirstName().clear();
	}
	
	public void clickFieldLastName() {
		getFieldLastName().click();
	}
	
	public void setFieldLastName(String text) {
		getFieldLastName().sendKeys(text);
	}
	
	public void clearFieldLastName() {
		getFieldLastName().clear();
	}
	
	public void clickFieldEmail() {
		getFieldEmail().click();
	}
	
	public void setFieldEmail(String text) {
		getFieldEmail().sendKeys(text);
	}
	
	public void clearFieldEmail() {
		getFieldEmail().clear();
	}

	public void clickFieldTelephone() {
		getFieldTelephone().click();
	}
	
	public void setFieldTelephone(String text) {
		getFieldTelephone().sendKeys(text);
	}
	
	public void clearFieldTelephone() {
		getFieldTelephone().clear();
	}

	public void clickFieldFax() {
		getFieldFax().click();
	}
	
	public void setFieldFax(String text) {
		getFieldFax().sendKeys(text);
	}
	
	public void clearFieldFax() {
		getFieldFax().clear();
	}

	public void clickFieldCompany() {
		getFieldCompany().click();
	}
	
	public void setFieldCompany(String text) {
		getFieldCompany().sendKeys(text);
	}
	
	public void clearFieldCompany() {
		getFieldCompany().clear();
	}

	public void clickFieldAddressFirst() {
		getFieldAddressFirst().click();
	}
	
	public void setFieldAddressFirst(String text) {
		getFieldAddressFirst().sendKeys(text);
	}
	
	public void clearFieldAddressFirst() {
		getFieldAddressFirst().clear();
	}

	public void clickFieldAddressSecond() {
		getFieldAddressSecond().click();
	}
	
	public void setFieldAddressSecond(String text) {
		getFieldAddressSecond().sendKeys(text);
	}
	
	public void clearFieldAddressSecond() {
		getFieldAddressSecond().clear();
	}

	public void clickFieldCity() {
		getFieldCity().click();
	}
	
	public void setFieldCity(String text) {
		getFieldCity().sendKeys(text);
	}
	
	public void clearFieldCity() {
		getFieldCity().clear();
	}

	public void clickFieldPostCode() {
		getFieldPostCode().click();
	}
	
	public void setFieldPostCode(String text) {
		getFieldPostCode().sendKeys(text);
	}
	
	public void clearFieldPostCode() {
		getFieldPostCode().clear();
	}

	public void clickFieldPassword() {
		getFieldPassword().click();
	}
	
	public void setFieldPassword(String text) {
		getFieldPassword().sendKeys(text);
	}
	
	public void clearFieldPassword() {
		getFieldPassword().clear();
	}

	public void clickFieldConfirmPassword() {
		getFieldConfirmPassword().click();
	}
	
	public void setFieldConfirmPassword(String text) {
		getFieldConfirmPassword().sendKeys(text);
	}
	
	public void clearFieldConfirmPassword() {
		getFieldConfirmPassword().clear();
	}

	public void clickLinkPrivacyPolicy() {
		getLinkPrivacyPolicy().click();
	}
	
	public void clickSubmitButton() {
		getSubmitButton().click();
	}
	
	// set Functional
	
	public void selectCountry(String text) {
		getCountry().selectByVisibleText(text);
	}

	public void selectZone(String text) {
		getZone().selectByVisibleText(text);
	}
	
	public void clickRadioNewsSubscribe() {
		for (WebElement radio : radioNewsSubscribe) {
			if(!radio.isSelected()) {
				radio.click();
				break;
			}
		}
	}
	
	public void clickCheckPrivacyPolicy() {
		getCheckPrivacyPolicy().click();
	}
	
	// Business Logic
	
	public LoginPage clickLinkToLogin() {
		getLinkToLogin().click();
		return new LoginPage(driver);
	}
	
	public UserPage gotoRegisteredUserPage() {
		clickSubmitButton();
		return new UserPage(driver);
	}
}
