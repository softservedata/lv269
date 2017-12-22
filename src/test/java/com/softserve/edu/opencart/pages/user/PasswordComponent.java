package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tools.search.ISearch;


/**
 * @author Yurii Ivanytskyi
 */
public class PasswordComponent {
	
	private final ISearch search;

	private WebElement fieldPassword;
	private WebElement fieldConfirmPassword;

	public PasswordComponent() {
		this.search = Application.get().search();
		fieldPassword = search.id("input-password");
		fieldConfirmPassword = search.id("input-confirm");
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



	public void clearFieldPassword() {
		getFieldPassword().clear();
	}

	public void clickFieldConfirmPassword() {
		getFieldConfirmPassword().click();
	}



	public void clearFieldConfirmPassword() {
		getFieldConfirmPassword().clear();
	}
	public void setFieldPassword(String text) {
		clickFieldPassword();
		clearFieldPassword();
		getFieldPassword().sendKeys(text);
	}
	public void setFieldConfirmPassword(String text) {
		clickFieldConfirmPassword();
		clearFieldConfirmPassword();
		getFieldConfirmPassword().sendKeys(text);
	}


}
