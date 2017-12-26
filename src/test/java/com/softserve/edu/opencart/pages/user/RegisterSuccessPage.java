package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.WebElement;

/**
 * @author Yurii Ivanytskyi
 */
public class RegisterSuccessPage extends AHeaderComponent{
	
	private WebElement tittleSuccess;
	private WebElement linkToContactUs;
	private WebElement continueButton;
	
	public RegisterSuccessPage() {
		super();
		//tittleSuccess = search.cssSelector("#content>h1");
		//linkToContactUs = search.cssSelector("#content>p>a");
		//continueButton = search.cssSelector(".btn.btn-primary");
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
