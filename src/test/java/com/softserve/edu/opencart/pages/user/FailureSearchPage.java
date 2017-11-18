package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FailureSearchPage extends ASearchComponent{

    public final String NO_PRODUCT = "no product";
    private WebElement noElementsMeetingCriteria;

    public FailureSearchPage(WebDriver driver){
        super(driver);

        noElementsMeetingCriteria = driver.findElement(By.cssSelector("#content > p:last-of-type"));
    }

    //getters
    public WebElement getNoElementsMeetingCriteria() {
        return noElementsMeetingCriteria;
    }

    public String getNoElementsMeetingCriteriaText() {

        return getNoElementsMeetingCriteria().getText();
    }

    //business logic
    public boolean nothingFound(){
        return noElementsMeetingCriteria != null;
    }
}
