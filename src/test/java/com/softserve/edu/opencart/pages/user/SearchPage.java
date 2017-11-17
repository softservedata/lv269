package com.softserve.edu.opencart.pages.user;

import com.softserve.edu.opencart.pages.TagAttribute;
import com.softserve.edu.opencart.tools.ErrorUtils;
import com.softserve.edu.opencart.tools.TextUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends ANavigatePanelComponent {

    private final String OPTION_NOT_FOUND_MESSAGE = "Option %s not found in %s";
    private final String XPATH_FOR_OPTIONS = "select[name = %s] > option";

    private WebElement searchHeaderName;
    private WebElement inputSearch;
    private WebElement selectCategorySearch;
    private WebElement categorySearchCheckbox;
    private WebElement descriptionSearchCheckbox;
    private WebElement searchCriteriaButton;
    private WebElement selectInputSort;
    private WebElement selectInputLimit;
    private WebElement noElementsMeetingCriteria;


    public SearchPage(WebDriver driver) {
        super(driver);

        searchHeaderName = driver.findElement(By.cssSelector("#content > h1"));
        inputSearch = driver.findElement(By.id("input-search"));
        selectCategorySearch = driver.findElement(By.cssSelector("select[name = 'category_id']"));
        categorySearchCheckbox = driver.findElement(By.cssSelector(".checkbox-inline > input[name = 'sub_category']"));
        descriptionSearchCheckbox = driver.findElement(By.
                cssSelector(".checkbox-inline > input[name = 'description']"));
        searchCriteriaButton = driver.findElement(By.id("button-search"));

        initSearchResults();
    }

    //getters
    public WebElement getSearchHeaderName() {

        return searchHeaderName;
    }

    public WebElement getInputSearch() {

        return inputSearch;
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

    public WebElement getNoElementsMeetingCriteria() {

        return noElementsMeetingCriteria;
    }

    public WebElement getSelectCategorySearch() {

        return selectCategorySearch;
    }

    public WebElement getSelectInputLimit() {
        return selectInputLimit;
    }

    public WebElement getSelectInputSort() {
        return selectInputSort;
    }

    public List<WebElement> getOptionList(WebElement select){
        return driver.findElements(By.xpath(String.format(XPATH_FOR_OPTIONS, select)));
    }

    public WebElement getSelectOptionByPartialName(String categoryName, List<WebElement> selectOptions){
        WebElement result = null;
        for (WebElement current : selectOptions) {
            if (current.getText().toLowerCase().trim().contains(categoryName.toLowerCase().trim())) {
                result = current;
                break;
            }
        }
        return result;
    }

    //get text data
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

    public String getNoElementsMeetingCriteriaText() {

        return getNoElementsMeetingCriteria().getText();
    }

    @Override
    public List<String> getProductComponentTexts() {
        return super.getProductComponentTexts();
    }

    @Override
    public String getPriceTextByProductName(String productName) {
        return super.getPriceTextByProductName(productName);
    }

    @Override
    public double getPriceAmountByProductName(String productName) {
        return super.getPriceAmountByProductName(productName);
    }

    //get special text
    protected List<String> getSelectTexts(WebElement selectOption) {
        List<String> result = new ArrayList<>();
        for (WebElement current : getOptionList(selectOption)) {
            result.add(current.getText());
        }
        return result;
    }

    //set data
    public void clickSearchCriteriaButton() {
        getSearchCriteriaButton().click();
    }

    public void setInputSearch(String text) {
        getInputSearch().sendKeys(text);
    }

    public void clearInputSearch() {
        getInputSearch().clear();
    }

    public void clickInputSearch() { getInputSearch().click(); }

    public void clickSelectCategorySearch() { getSelectCategorySearch().click(); }

    public void clickSelectInputLimit() { getSelectInputLimit().click(); }

    public void clickSelectInputSort() { getSelectInputSort().click(); }

    public void setSelectCategorySearch(String categoryName){
        boolean isSelectable = false;
        clickSelectCategorySearch();
        for(String current : getSelectTexts(getSelectCategorySearch())){
            if(current.toLowerCase().contains(categoryName.toLowerCase())) {
                isSelectable = true;
            }
        }
        ErrorUtils.createCustomException(!isSelectable,
                String.format(OPTION_NOT_FOUND_MESSAGE,
                        categoryName, getSelectTexts(getSelectCategorySearch()).toString()));
        getSelectOptionByPartialName(categoryName, getOptionList(getSelectCategorySearch())).click();
    }

    public void setSelectInputSort(String categoryName){
        boolean isSelectable = false;
        clickSelectInputSort();
        for(String current : getSelectTexts(getSelectInputSort())){
            if(current.toLowerCase().contains(categoryName.toLowerCase())) {
                isSelectable = true;
            }
        }
        ErrorUtils.createCustomException(!isSelectable,
                String.format(OPTION_NOT_FOUND_MESSAGE,
                        categoryName, getSelectTexts(getSelectInputSort()).toString()));
        getSelectOptionByPartialName(categoryName, getOptionList(getSelectInputSort())).click();
    }

    public void setSelectInputLimit(String categoryName){
        boolean isSelectable = false;
        clickSelectInputLimit();
        for(String current : getSelectTexts(getSelectInputLimit())){
            if(current.toLowerCase().contains(categoryName.toLowerCase())) {
                isSelectable = true;
            }
        }
        ErrorUtils.createCustomException(!isSelectable,
                String.format(OPTION_NOT_FOUND_MESSAGE,
                        categoryName, getSelectTexts(getSelectInputLimit()).toString()));
        getSelectOptionByPartialName(categoryName, getOptionList(getSelectInputLimit())).click();
    }

    public void checkCategorySearchCheckbox() {
        if(!isCheckboxSelected(getCategorySearchCheckbox())){
            getCategorySearchCheckbox().click();
        }
    }

    public void checkDescriptionSearchCheckbox() {
        if(!isCheckboxSelected(getDescriptionSearchCheckbox())){
            getDescriptionSearchCheckbox().click();
        }
    }
    public void sendKeysToInputSearch(String text){
        clickInputSearch();
        clearInputSearch();
        setInputSearch(text);
    }

    //business logic
    public SearchPage findElementByName(String productName){
        sendKeysToInputSearch(productName);
        clickSearchCriteriaButton();
        return new SearchPage(driver);
    }

    public SearchPage findElementUsingCategorySelect(String productName, String category){
        sendKeysToInputSearch(productName);
        setSelectCategorySearch(category);
        clickSearchCriteriaButton();
        return new SearchPage(driver);
    }

    public SearchPage findElementUsingCategorySelectCheckSubcategory(String productName, String category){
        sendKeysToInputSearch(productName);
        setSelectCategorySearch(category);
        checkCategorySearchCheckbox();
        clickSearchCriteriaButton();
        return new SearchPage(driver);
    }

    public SearchPage findElementUsingCategorySelectCheckDescription(String productName, String category){
        sendKeysToInputSearch(productName);
        setSelectCategorySearch(category);
        checkDescriptionSearchCheckbox();
        clickSearchCriteriaButton();
        return new SearchPage(driver);
    }

    public SearchPage findElementUsingCategorySelectCheckSubcategoryDescription(String productName, String category){
        checkDescriptionSearchCheckbox();
        findElementUsingCategorySelectCheckSubcategory(productName, category);
        return new SearchPage(driver);
    }

    public boolean isFound(List<String> foundProducts, String elementName){
        for (String current : foundProducts){
            if(TextUtils.respondsPattern(current, elementName)){
                return true;
            }
        }
        return false;
    }

    public boolean nothingFound(){
        return getProductComponentTexts().isEmpty();
    }

    //additional methods
    public boolean isCheckboxSelected(WebElement checkbox){
        return checkbox.isSelected();
    }

    public void initSearchResults(){
        initProductComponents(By.cssSelector(".product-layout"));
        if(getProductComponentTexts().isEmpty()){
            noElementsMeetingCriteria = driver.findElement(By.cssSelector("#content > p:last-of-type"));
        } else {
            selectInputSort = driver.findElement(By.id("#input-sort"));
            selectInputLimit = driver.findElement(By.id("#input-limit"));
        }
    }
}