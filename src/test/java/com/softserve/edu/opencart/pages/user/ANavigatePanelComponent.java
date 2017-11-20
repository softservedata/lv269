package com.softserve.edu.opencart.pages.user;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

abstract class ANavigatePanelComponent extends AHeaderComponent {

    // Fields

    private List<WebElement> pathElements;
    
    private WebElement homeLogo;

    public ANavigatePanelComponent(WebDriver driver) {
        super(driver);
        homeLogo = driver.findElement(By.cssSelector(".fa.fa-home"));
    }

    // PageObject

    // get Data
    
    public WebElement getHomeLogo() {
    	return homeLogo;
    }

    // get Functional

    // set Data
    
    public void clickHomeLogo() {
    	getHomeLogo().click();
    }

    // set Functional

    // Business Logic
    
    public HomePage gotoHomePageViaHomeLogoClick() {
    	clickHomeLogo();
    	return new HomePage(driver);
    }

}
