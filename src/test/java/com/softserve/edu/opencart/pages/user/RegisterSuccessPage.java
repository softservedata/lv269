package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Yurii Ivanytskyi
 */
public class RegisterSuccessPage extends AColumnRightGuestComponent{
	
	private WebElement tittleSuccess;
	private WebElement linkToContactUs;
	private WebElement continueButton;
	
	public RegisterSuccessPage(WebDriver driver) {
		super(driver);
		tittleSuccess = driver.findElement(By.cssSelector("#content>h1"));
		linkToContactUs = driver.findElement(By.cssSelector("#content>p>a"));
		continueButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
	}

	public WebElement getTittleSuccess() {
		return tittleSuccess;
	}

	public WebElement getLinkToContactUs() {
		return linkToContactUs;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}
	
}
