package com.softserve.edu.registrator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class ATopComponent {

    public static enum ChangeLanguageFields {
        UKRAINIAN("українська"),
        RUSSIAN("русский"),
        ENGLISH("english");
        //
        private String field;

        private ChangeLanguageFields(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return field;
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public static final String CLASS_ATTRIBUTE = "class"; 
    public static final String SRC_ATTRIBUTE = "src"; 
    public static final String VALUE_ATTRIBUTE = "value"; 

    // Fields
    //
    protected WebDriver driver;
    //
    private WebElement titleMessage;
    private Select changeLanguage;

    protected ATopComponent(WebDriver driver) {
        this.driver = driver;
        this.titleMessage = driver.findElement(By.cssSelector("div.col-md-7.col-xs-12"));
        this.changeLanguage = new Select(driver.findElement(By.id("changeLanguage")));
        //
        //this.titleMessage = Search.cssSelector("div.col-md-7.col-xs-12");
        //this.changeLanguage = new Select(Search.id("changeLanguage"));
    }

    // PageObject

    // get Data

    public Select getChangeLanguage() {
        return this.changeLanguage;
    }

    public WebElement getTitleMessage() {
        return this.titleMessage;
    }

    public WebElement getChangeLanguageSelected() {
        return getChangeLanguage().getFirstSelectedOption();
    }

    // Functional

    public String getTitleMessageText() {
        return getTitleMessage().getText();
    }

    public String getChangeLanguageSelectedText() {
        return getChangeLanguageSelected().getText().trim();
    }

    // set Data

    public void setChangeLanguage(ChangeLanguageFields language) {
        getChangeLanguage().selectByVisibleText(language.toString());
    }

    // Business Logic

}
