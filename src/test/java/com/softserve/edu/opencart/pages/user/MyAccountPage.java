package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage extends AColumnRightUserComponent {

	public MyAccountPage() {
		super();
	}
	
	 //----------Bussiness logic

	public EditAccountPage gotoEditAccountPageFromRightColumn(){
		clickEditAccount();
		return new EditAccountPage();
	}


}