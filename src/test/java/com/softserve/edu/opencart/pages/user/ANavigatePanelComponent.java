package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.WebElement;

import java.util.List;

abstract class ANavigatePanelComponent extends AHeaderComponent {

    // Fields

    private List<WebElement> pathElements;

    private WebElement homeLogo;

    //public ANavigatePanelComponent(WebDriver driver) {
    public ANavigatePanelComponent() {
        //super(driver);
        //homeLogo = driver.findElement(By.cssSelector(".fa.fa-home"));
        homeLogo = search.cssSelector(".fa.fa-home");
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
        return new HomePage();
    }

}
