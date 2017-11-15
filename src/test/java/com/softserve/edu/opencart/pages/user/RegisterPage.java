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
	private Select selectCountry;
	private Select selectZone;
	private WebElement fieldPassword;
	private WebElement fieldConfirmPassword;
	private List<WebElement> radioNewsSubscribe; //?
	private WebElement linkPrivacyPolicy;
	private WebElement checkPrivacyPolicy;

	public RegisterPage(WebDriver driver) {
		super(driver);
		linkToLogin = driver.findElement(By.id("content>p>a"));
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
		selectCountry = new Select(driver.findElement(By.id("input-country")));
		selectZone = new Select(driver.findElement(By.id("input-zone")));
		fieldPassword = driver.findElement(By.id("input-password"));
		fieldConfirmPassword = driver.findElement(By.id("input-confirm"));
		radioNewsSubscribe = driver.findElements(By.cssSelector(".radio-inline")); //?
		linkPrivacyPolicy = driver.findElement(By.cssSelector(".pull-right > a"));
		checkPrivacyPolicy = driver.findElement(By.cssSelector(".pull-right > input"));
		
	}

}
