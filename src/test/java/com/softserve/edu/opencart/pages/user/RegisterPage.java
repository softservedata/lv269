package com.softserve.edu.opencart.pages.user;

import java.util.List;

import com.softserve.edu.opencart.data.users.IUser;
import org.openqa.selenium.WebElement;

/**
 * @author Yurii Ivanytskyi
 */

public class RegisterPage extends AColumnRightGuestComponent {
	
	private PersonalDetailsComponent personalDetailsComponent;
	private AddressComponent addressComponent;
	private PasswordComponent passwordComponent;
	
	private WebElement linkToLogin;
	private List<WebElement> radioNewsSubscribe;
	private WebElement checkPrivacyPolicy;
	private WebElement submitButton;

	public RegisterPage() {
		super();
		this.personalDetailsComponent = new PersonalDetailsComponent();
		this.addressComponent = new AddressComponent();
		this.passwordComponent = new PasswordComponent();
		linkToLogin = search.cssSelector("#content>p>a");
		radioNewsSubscribe = search.cssSelectors(".radio-inline"); // ?
		checkPrivacyPolicy = search.cssSelector(".pull-right > input");
		submitButton = search.cssSelector(".btn.btn-primary");
	}

	// Page Object

	// get Data
	
	public WebElement getLinkToLogin() {
		return linkToLogin;
	}

	public List<WebElement> getRadioNewsSubscribe() {
		return radioNewsSubscribe;	}

	public WebElement getCheckPrivacyPolicy() {
		return checkPrivacyPolicy;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	// get Functional

	public String getWarningDangerTextforField() {
		return getAlertTextDangerText();

	}

	// set Data

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

	public void changeFieldRegister(IUser user){

		personalDetailsComponent.setFieldFirstName(user.getFirstname());
		personalDetailsComponent.setFieldLastName(user.getLastname());
		personalDetailsComponent.setFieldEmail(user.getEmail());
		personalDetailsComponent.setFieldTelephone(user.getPhoneNumber());
		addressComponent.setFieldFirstAddress(user.getAddressFirst());
		addressComponent.setFieldCity(user.getCity());
		addressComponent.selectFieldCountry(user.getCountry());
		addressComponent.selectFieldRegion(user.getRegion());
		passwordComponent.setFieldPassword(user.getPassword());
		passwordComponent.setFieldConfirmPassword(user.getPassword());
		clickCheckPrivacyPolicy();

	}
	public RegisterSuccessPage gotoRegisterSuccessPage() {
		clickSubmitButton();
		return new RegisterSuccessPage();
	}
}
