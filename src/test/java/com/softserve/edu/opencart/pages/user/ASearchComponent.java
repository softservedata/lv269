package com.softserve.edu.opencart.pages.user;

import com.softserve.edu.opencart.pages.TagAttribute;
import com.softserve.edu.opencart.tools.ErrorUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

abstract class ASearchComponent extends ANavigatePanelComponent{

    private final String OPTION_NOT_FOUND_MESSAGE = "Option %s not found in %s";
    //private final String XPATH_FOR_OPTIONS = "select[name = %s] > option";

    private WebElement searchHeaderName;
    private WebElement inputSearch;
    private WebElement selectCategorySearch;
    private WebElement categorySearchCheckbox;
    private WebElement descriptionSearchCheckbox;
    private WebElement searchCriteriaButton;

    public ASearchComponent(WebDriver driver) {
        super(driver);
        searchHeaderName = driver.findElement(By.cssSelector("#content > h1"));
        inputSearch = driver.findElement(By.id("input-search"));
        selectCategorySearch = driver.findElement(By.cssSelector("select[name = 'category_id']"));
        categorySearchCheckbox = driver.findElement(By.cssSelector(".checkbox-inline > input[name = 'sub_category']"));
        descriptionSearchCheckbox = driver.findElement(By.
                cssSelector(".checkbox-inline > input[name = 'description']"));
        searchCriteriaButton = driver.findElement(By.id("button-search"));
    }


    //getters
    public WebElement getSearchHeaderName() {

        return searchHeaderName;
    }

    public WebElement getInputSearch() {

        return inputSearch;
    }

    public WebElement getSelectCategorySearch() {

        return selectCategorySearch;
    }

    public WebElement getCategorySearchCheckbox() {

        return categorySearchCheckbox;
    }

    public WebElement getDescriptionSearchCheckbox() {

        return descriptionSearchCheckbox;
    }

    public WebElement getSearchCriteriaButton() {

        return searchCriteriaButton;
    }

    public List<WebElement> getOptionsList(WebElement selectOption){
        Select select = new Select(selectOption);
        return select.getOptions();
    }

    //get Texts
    public String getSearchHeaderNameText() {
        return getSearchHeaderName().getText().substring(10);
    }

    public String getInputSearchText() {
        return getInputSearch().getAttribute(TagAttribute.VALUE.toString());
    }

    public String getSelectedText(WebElement selectOption) {
        Select select = new Select(selectOption);
        return select.getFirstSelectedOption().getText().trim();
    }

    public String getCategorySearchCheckboxLabel(){
        return getCategorySearchCheckbox().getText();
    }

    public String getDescriptionSearchCheckboxLabel(){
        return getDescriptionSearchCheckbox().getText();
    }

    public String getSearchCriteriaButtonText(){
        return getSearchCriteriaButton().getText();
    }

    public List<String> getOptionsListTexts(WebElement selectOption){
        Select select = new Select(selectOption);
        List<String> optionsText = new ArrayList<>();
        for(WebElement current : getOptionsList(selectOption)){
            optionsText.add(current.getText());
        }
        return optionsText;
    }

    //set data
    public void clickSearchCriteriaButton() {
        getSearchCriteriaButton().click();
    }

    public void clickInputSearch() { getInputSearch().click(); }

    public void clearInputSearch() {
        getInputSearch().clear();
    }

    public void setInputSearch(String text) {
        getInputSearch().sendKeys(text);
    }

    public void clickSelectCategorySearch() { getSelectCategorySearch().click(); }

    public void setSelectCategorySearchByPartialName(String categoryName){
        selectOptionByPartialName(categoryName, getSelectCategorySearch());
    }

    public void checkCategorySearchCheckbox() {
        if(!getCategorySearchCheckbox().isSelected()){
            getCategorySearchCheckbox().click();
        }
    }

    public void checkDescriptionSearchCheckbox() {
        if(!getDescriptionSearchCheckbox().isSelected()){
            getDescriptionSearchCheckbox().click();
        }
    }

    //set functional
    public void sendKeysToInputSearch(String text){
        clickInputSearch();
        clearInputSearch();
        setInputSearch(text);
    }

    public void selectOptionByPartialName(String optionName, WebElement selectOption) {
        boolean isSelectable = false;
        List<String> optionsToRemember = new ArrayList<>();
        Select select = new Select(selectOption);
        selectOption.click();
        for(String current : getOptionsListTexts(selectOption)){
            if(current.toLowerCase().contains(optionName.toLowerCase())) {
                optionsToRemember.add(current);
            }
        }

        if (optionsToRemember.size() > 1){
            for(String foundOption : optionsToRemember){
                if(foundOption.toLowerCase().trim().equals(optionName.toLowerCase())) {
                    isSelectable = true;
                    select.selectByVisibleText(foundOption);
                    break;
                }
            }
        } else{
            isSelectable = true;
            select.selectByVisibleText(optionsToRemember.get(0));
        }
//        for(String current : getOptionsListTexts(selectOption)){
//            if(current.toLowerCase().contains(optionName.toLowerCase())) {
//                isSelectable = true;
//                //Select select = new Select(selectOption);
//                select.selectByVisibleText(current);
//                break;
//            }
//        }
        ErrorUtils.createCustomException(!isSelectable, String.format(OPTION_NOT_FOUND_MESSAGE,
                optionName, getOptionsListTexts(getSelectCategorySearch()).toString()));

    }

    //business logic Pages
    public HomePage toHome(){
        clickLogo();
        return new HomePage(driver);
    }

    public SuccessSearchPage findProductByName(String productName){
        sendKeysToInputSearch(productName);
        clickSearchCriteriaButton();
        return new SuccessSearchPage(driver);
    }

    public FailureSearchPage findNoElements(String searchText){
        sendKeysToInputSearch(searchText);
        clickSearchCriteriaButton();
        return new FailureSearchPage(driver);
    }

    public SuccessSearchPage findProductInRightCategory(String productName, String categoryName){
        sendKeysToInputSearch(productName);
        selectOptionByPartialName(categoryName, getSelectCategorySearch());
        clickSearchCriteriaButton();
        return new SuccessSearchPage(driver);
    }

    public SuccessSearchPage findProductByDescription(String description){
        sendKeysToInputSearch(description);
        checkDescriptionSearchCheckbox();
        clickSearchCriteriaButton();
        return new SuccessSearchPage(driver);
    }

    public FailureSearchPage noProductInCategory(String productName, String categoryName){
        sendKeysToInputSearch(productName);
        selectOptionByPartialName(categoryName, getSelectCategorySearch());
        checkCategorySearchCheckbox();
        clickSearchCriteriaButton();
        return new FailureSearchPage(driver);
    }
}