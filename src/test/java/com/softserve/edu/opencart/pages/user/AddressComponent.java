package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tools.ISearch;

/**
 * @author Yurii Ivanytskyi
 */
public class AddressComponent {
	
	protected final ISearch search;

	private WebElement fieldCompany;
	private WebElement fieldAddressFirst;
	private WebElement fieldAddressSecond;
	private WebElement fieldCity;
	private WebElement fieldPostCode;
	private Select country;
	private Select zone;

	public AddressComponent() {
		this.search = Application.get().search();
		fieldCompany = search.id("input-company");
		fieldAddressFirst = search.id("input-address-1");
		fieldAddressSecond = search.id("input-address-2");
		fieldCity = search.id("input-city");
		fieldPostCode = search.id("input-postcode");
		country = new Select(search.id("input-country"));
		zone = new Select(search.id("input-zone"));
	}

	// get Data

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

	// set Data

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

	// set Functional

	public void selectCountry(String text) {
		getCountry().selectByVisibleText(text);
	}

	public void selectZone(String text) {
		getZone().selectByVisibleText(text);
	}
}
