package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tools.ISearch;

/**
 * @author Yurii Ivanytskyi
 */
public class PersonalDetailsComponent {
	
	private final ISearch search;

	private WebElement fieldFirstName;
	private WebElement fieldLastName;
	private WebElement fieldEmail;
	private WebElement fieldTelephone;
	private WebElement fieldFax;

	public PersonalDetailsComponent() {
		this.search = Application.get().search();
		fieldFirstName = search.id("input-firstname");
		fieldLastName = search.id("input-lastname");
		fieldEmail = search.id("input-email");
		fieldTelephone = search.id("input-telephone");
		fieldFax = search.id("input-fax");
	}

	// Page Object

	// get Data

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
}
