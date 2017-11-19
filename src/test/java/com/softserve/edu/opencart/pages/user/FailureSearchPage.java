package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FailureSearchPage extends ASearchComponent{

    public final String NO_PRODUCT = "no product";
    private List<WebElement> noElementsMeetingCriteria;

    public FailureSearchPage(WebDriver driver){
        super(driver);

        noElementsMeetingCriteria = driver.findElements(By.xpath("//input[@id='button-search']/following-sibling::p"));
    }

    //getters
    public List<WebElement> getNoElementsMeetingCriteria() {
        return noElementsMeetingCriteria;
    }

    public String getNoElementsMeetingCriteriaText() {

         if(!noElementsMeetingCriteria.isEmpty()){
             return getNoElementsMeetingCriteria().get(0).getText();
         }
        else return null;
    }

    //business logic
    public boolean nothingFound(){
        return !noElementsMeetingCriteria.isEmpty();
    }


}
