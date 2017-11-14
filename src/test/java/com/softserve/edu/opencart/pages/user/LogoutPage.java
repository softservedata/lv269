package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage extends AColumnRightGuestComponent {
	private WebElement continueButton;

	public LogoutPage(WebDriver driver) {
		super(driver);
		continueButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public void clickContinueButton() {
		getContinueButton().click();
	}

	public HomePage gotoHomePage() {
		clickContinueButton();
		return new HomePage(driver);
	}
}