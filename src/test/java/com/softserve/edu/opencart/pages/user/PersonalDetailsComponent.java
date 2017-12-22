package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tools.search.ISearch;


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
	public void clickFieldLastName() {
		getFieldLastName().click();
	}
	public void clickFieldEmail() {
		getFieldEmail().click();
	}
	public void clickFieldTelephone() {
		getFieldTelephone().click();
	}
	public void clickFieldFax() {
		getFieldFax().click();
	}

	public void clearFieldFirstName() {
		getFieldFirstName().clear();
	}
	public void clearFieldTelephone() {
		getFieldTelephone().clear();
	}
	public void clearFieldLastName() {
		getFieldLastName().clear();
	}
	public void clearFieldEmail() {
		getFieldEmail().clear();
	}
	public void clearFieldFax() {
		getFieldFax().clear();
	}

	public void setFieldFirstName(String text) {
		clickFieldFirstName();
		clearFieldFirstName();
		getFieldFirstName().sendKeys(text);
	}

	public void setFieldLastName(String text) {
		clickFieldLastName();
		clearFieldLastName();
		getFieldLastName().sendKeys(text);
	}

	public void setFieldEmail(String text) {
		clickFieldEmail();
		clearFieldEmail();
		getFieldEmail().sendKeys(text);
	}

	public void setFieldTelephone(String text) {
		clickFieldTelephone();
		clearFieldTelephone();
		getFieldTelephone().sendKeys(text);
	}

	public void setFieldFax(String text) {
		clickFieldFax();
		clearFieldFax();
		getFieldFax().sendKeys(text);
	}


}
