package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tools.search.ISearch;


/**
 * @author Yurii Ivanytskyi
 */
public class AddressComponent {
	
	protected final ISearch search;

	private WebElement fieldFirstAddress;
	private WebElement fieldSecondAddress;
	private WebElement fieldCompany;
	private WebElement fieldCity;
	private WebElement fieldPostCode;
	private Select fieldCountry;
	private Select fieldRegion;

	public AddressComponent() {
		this.search = Application.get().search();
		fieldCompany = search.id("input-company");
		fieldFirstAddress = search.id("input-address-1");
		fieldSecondAddress = search.id("input-address-2");
		fieldCity = search.id("input-city");
		fieldPostCode = search.id("input-postcode");
		fieldCountry = new Select(search.id("input-country"));
		fieldRegion = new Select(search.id("input-zone"));
	}

	// get Data

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
	// set Data

	public void clickFieldFirstAddress() {
		getFieldFirstAddress().click();
	}

	public void clickFieldSecondAddress() {
		getFieldSecondAddress().click();
	}

	public void clickFieldCompany() {
		getFieldCompany().click();
	}

	public void clickFieldCity() {
		getFieldCity().click();
	}

	public void clickFieldPostCode() {
		getFieldPostCode().click();
	}

	public void selectFieldCountry(String text) {
		getFieldCountry().selectByVisibleText(text);
		//operations.selectByVisibleText(getFieldCountry(), text);
	}

	public void selectFieldRegion(String text) {
		getFieldRegion().selectByVisibleText(text);
		//operations.selectByVisibleText(getFieldRegion(), text);
	}

	public void clearFieldFirstAddress() {
		getFieldFirstAddress().clear();
	}

	public void clearFieldSecondAddress() {
		getFieldSecondAddress().clear();
	}

	public void clearFieldCompany() {
		getFieldCompany().clear();
	}

	public void clearFieldCity() {
		getFieldCity().clear();
	}

	public void cleareFieldPostCode() {
		getFieldPostCode().clear();
	}


	public void setFieldFirstAddress(String text) {
		clickFieldFirstAddress();
		clearFieldFirstAddress();
		getFieldFirstAddress().sendKeys(text);
	}

	public void setFieldSecondAddress(String text) {
		clickFieldSecondAddress();
		clearFieldSecondAddress();
		getFieldSecondAddress().sendKeys(text);
	}

	public void setFieldCompany(String text) {
		clickFieldCompany();
		clearFieldCompany();
		getFieldCompany().sendKeys(text);
	}

	public void setFieldCity(String text) {
		clickFieldCity();
		clearFieldCity();
		getFieldCity().sendKeys(text);
	}

	public void setFieldPostCode(String text) {
		clickFieldPostCode();
		cleareFieldPostCode();
		getFieldPostCode().sendKeys(text);
	}

	// set Functional


}
