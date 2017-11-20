package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Yurii Ivanytskyi
 */
public class PasswordComponent {

	private WebElement fieldPassword;
	private WebElement fieldConfirmPassword;

	public PasswordComponent(WebDriver driver) {
		fieldPassword = driver.findElement(By.id("input-password"));
		fieldConfirmPassword = driver.findElement(By.id("input-confirm"));
	}

	// get Data

	public WebElement getFieldPassword() {
		return fieldPassword;
	}

	public WebElement getFieldConfirmPassword() {
		return fieldConfirmPassword;
	}

	// set Data

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

}
